package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import frc.robot.commands.auto.DoNothingAuto;
// import frc.robot.commands.auto.FourBallAuto;
import frc.robot.commands.auto.TwoBallAuto;
// import frc.robot.commands.auto.testingTTA;
// import frc.robot.commands.auto.TaxiPreload2;
// import frc.robot.commands.auto.ThreeBallAutoAlt;
import frc.robot.commands.auto.ThreeBallAutoMain;
import frc.robot.commands.auto.OneBallAuto;
import frc.robot.commands.drivetrain.TimedDrive;
// import frc.robot.commands.drivetrain.TurnToAngle;
import frc.robot.commands.drivetrain.TimedTurn;
import frc.robot.commands.drivetrain.TurnToAngle;

//import frc.robot.commands.climber.ClimberOff;
//import frc.robot.commands.climber.ExtendClimber;
//import frc.robot.commands.climber.RetractClimber

import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.drivetrain.AngleTurn;
import frc.robot.commands.drivetrain.Drive;
import frc.robot.commands.feeder.IncrementFeeder;
import frc.robot.commands.Intake.SpinIntakeIn;
import frc.robot.commands.feeder.StopFeeder;
import frc.robot.commands.flywheel.FlywheelShootOff;
import frc.robot.commands.flywheel.FlywheelShootValue;
import frc.robot.commands.flywheel.flywheelAuto;
import frc.robot.commands.pneumatics.Fingers.DeployFingers;
import frc.robot.commands.pneumatics.Fingers.RetractFingers;
import frc.robot.commands.pneumatics.Intake.DeployIntake;
import frc.robot.commands.pneumatics.Intake.RetractIntake;
import frc.robot.commands.selfTest.RobotSelfTest;
import frc.robot.commands.sushiKicker.spinSushiOff;
import frc.robot.commands.sushiKicker.spinSushiOn;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Sushi;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pneumatics;
import frc.libs.*;

public class RobotContainer implements Constants.ElectricalPortConstants {
  // The robot's subsystems and OI devices
 
  // Subsystems and class objects used elsewhere in the code
  //  are declared here.
  // All classes required by any class instantiated here must, be instantiated before the instatiated class.

  public static final Drivetrain dt = new Drivetrain();
  public static final Pneumatics pn = new Pneumatics();
  public static final Climber cl = new Climber();
  public static final Intake in = new Intake();
  public static final Flywheel fw = new Flywheel();
  public static final Feeder fd = new Feeder();
  public static final Sushi su = new Sushi();
  

  // public static final AutoGenerator ag = new AutoGenerator();
  private static final SendableChooser<Command> chooser = new SendableChooser<>();

  // Xbox controllers
  public static final SmoothXboxController xbox = new SmoothXboxController(xboxPrimaryDriver);
  public static final Joystick joystick = new Joystick(joystickDriver);

  private UsbCamera camera;

  public RobotContainer() {
    camera = CameraServer.startAutomaticCapture();
    camera.setFPS(30);
    camera.setResolution(
      Constants.GeneralConstants.RobotPhysicalConstants.x_resolution, 
      Constants.GeneralConstants.RobotPhysicalConstants.y_resolution
    );
    

      NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
      NetworkTableEntry tx = table.getEntry("tx");
      NetworkTableEntry ty = table.getEntry("ty");
      NetworkTableEntry ta = table.getEntry("ta");
      
      //read values periodically
      double x = tx.getDouble(0.0);
      double y = ty.getDouble(0.0);
      double area = ta.getDouble(0.0);
      
      //post to smart dashboard periodically
      SmartDashboard.putNumber("LimelightX", x);
      SmartDashboard.putNumber("LimelightY", y);
      SmartDashboard.putNumber("LimelightArea", area);  


    chooser.setDefaultOption("Do Nothing Auto", new DoNothingAuto());
    chooser.addOption("TD: 2s", new TimedDrive(0.25, 2));
    chooser.addOption("TD: 5s", new TimedDrive(0.25, 5));
    chooser.addOption("RTD: 2s", new TimedDrive(-0.25, 2));
    chooser.addOption("RTD: 5s", new TimedDrive(-0.25, 5));
    chooser.addOption("1 Ball Auto", new OneBallAuto());
    chooser.addOption("2 Ball Auto", new TwoBallAuto());
    chooser.addOption("3 Ball Auto Main", new ThreeBallAutoMain());
    // chooser.addOption("testing TTA", new testingTTA());
    // chooser.addOption("2 Preloaded", new TaxiPreload2());
    // chooser.addOption("3 Ball Auto Alt", new ThreeBallAutoAlt());
    // chooser.addOption("4 Ball Auto", new FourBallAuto());
   //chooser.setDefaultOption("Limelight off", NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1));

    Shuffleboard.getTab("Selector").add(chooser);
    
    // Robot Self Test
    SmartDashboard.putData("Robot Self Test", new RobotSelfTest());

    configureButtonBindings();
    configureDefaultCommands();
  }

  private void configureButtonBindings() {

    // Primary Driver Controls

    new JoystickButton(xbox, Button.kLeftBumper.value)
      .whenPressed(new SpinIntakeIn())
      .whenPressed(new DeployIntake())
      .whenReleased(new RetractIntake());

      // new JoystickButton(xbox, Button.kRightBumper.value)
      // .whenPressed(new SpinIntakeIn())
      // .whenPressed(new DeployIntake())
      // .whenReleased(new RetractIntake());

    new JoystickButton(xbox, Button.kB.value)
    .whenPressed(new AngleTurn(.1, 3, .5));

    new JoystickButton(xbox, Button.kA.value)
    .whenPressed(new flywheelAuto());
    
      new JoystickButton(joystick, 1)
      .whenPressed(new DeployFingers())
      .whenReleased(new RetractFingers());
      
      new JoystickButton(joystick, 2) 
      .whenPressed(new spinSushiOn()) 
      .whenPressed(new IncrementFeeder())
      .whenReleased(new StopFeeder())
      .whenReleased(new spinSushiOff());
      
      new JoystickButton(joystick, 5)
      .whenPressed(new FlywheelShootOff());

      new JoystickButton(joystick, 3)
      .whenPressed(new flywheelAuto());

      new JoystickButton(joystick, 6)
      .whenPressed(new FlywheelShootValue(0.25)); // Tarmac, low, good 69
      
      new JoystickButton(joystick, 7)
      .whenPressed(new FlywheelShootValue(0.3)); // Field Side, low, good, 122
      
      new JoystickButton(joystick, 8)
      .whenPressed(new FlywheelShootValue(0.455)); // Launch Pad Close, High, goodish, hits center, long adjust to 46 was 45, 168

      new JoystickButton(joystick, 10)
      .whenPressed(new FlywheelShootValue(0.44)); // Launch Pad Close, High, untested, short adjust, was not used or 45, 168
      
      new JoystickButton(joystick, 9)
      .whenPressed(new FlywheelShootValue(0.5)); // Launch Pad Far, High, no comment on accuracy, 203

      new JoystickButton(joystick, 11)
      .whenPressed(new FlywheelShootValue(.275)); // 95 inches away 98 20 degrees 39.5 inches off the ground 68.5 inches from limelight to goal

    /* Climber
    xbox2.dpadUp.whenPressed(new ExtendClimber());
    xbox2.dpadUp.whenReleased(new ClimberOff());
    xbox2.dpadDown.whenReleased(new ClimberOff());
    xbox2.dpadDown.whenPressed(new RetractClimber());
    */
    //69- tarmac shot, 122 inches- To the flagship logo shot , launchpad shot close- 168 inches, 
  }

  private void configureDefaultCommands() {
    dt.setDefaultCommand(new Drive());
  }

  public Command getAutonomousCommand() {
    return chooser.getSelected();
  }
}

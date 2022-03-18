package frc.robot;

import frc.robot.commands.Intake.SpinIntakeIn;
import frc.robot.commands.Intake.SpinIntakeOff;
//import frc.robot.commands.climber.ClimberOff;
//import frc.robot.commands.climber.ExtendClimber;
//import frc.robot.commands.climber.RetractClimber
import frc.robot.commands.drivetrain.Drive;
import static edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// import frc.robot.commands.drivetrain.DriveDistanceCommandGenerator;
// import frc.robot.commands.drivetrain.HoldPositionController;
// import frc.robot.commands.drivetrain.ReducedSpeedTurningDrive;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.drivetrain.TimedTurn;
import frc.robot.commands.feeder.IncrementFeeder;
import frc.robot.commands.feeder.StopFeeder;
import frc.robot.commands.flywheel.FlywheelShootOff;
import frc.robot.commands.flywheel.FlywheelShootOut;
import frc.robot.commands.flywheel.FlywheelShootPole;
import frc.robot.commands.pneumatics.Fingers.DeployFingers;
import frc.robot.commands.pneumatics.Fingers.RetractFingers;
import frc.robot.commands.pneumatics.Intake.DeployIntake;
import frc.robot.commands.pneumatics.Intake.RetractIntake;
import frc.robot.commands.sushiKicker.spinSushiOff;
import frc.robot.commands.sushiKicker.spinSushiOn;
//import frc.robot.commands.turret.AngleWithTurret;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Sushi;
// import frc.robot.subsystems.Hood;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pneumatics;
//import frc.robot.subsystems.Turret;
import frc.libs.*;
// import frc.robot.Constants;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;
// import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
// import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer implements Constants.ElectricalPortConstants {
  // The robot's subsystems and OI devices
 
  // Subsystems and class objects used elsewhere in the code
  //  are declared here.
  // All classes required by any class instantiated here must, be instantiated before the instatiated class.

  public static final Drivetrain dt = new Drivetrain();
  public static final Pneumatics pn = new Pneumatics();
  // public static final Climber cl = new Climber();
  public static final Intake in = new Intake();
  public static final Flywheel fw = new Flywheel();
  public static final Feeder fd = new Feeder();
  public static final Sushi su = new Sushi();
  // public static final Hood hd = new Hood();
//  public static final Turret tr = new Turret();
  
  // e.x. AutoGenerator uses Drivetrain classes, so it must be made after drivetrain

  // By creating an AutoGenerator object
  // We are effectively importing all of the .json trajectory files on robot
  // startup.
  // This is because the AutoGenerator object is made on robot init and so everything
  // .json file is loaded on robot init as well. This saves time during auto as .json file
  // loading can take some time, and this time would normally be wasted with the robot just 
  // sitting still during auto.
  // public static final AutoGenerator ag = new AutoGenerator();
  private static final SendableChooser<Command> chooser = new SendableChooser<>();

  // Xbox controllers
  public static final SmoothXboxController xbox = new SmoothXboxController(xboxPrimaryDriver);
  public static final SmoothXboxController xbox2 = new SmoothXboxController(xboxSecondaryDriver);
  public static final Joystick joystick = new Joystick(joystickDriver);

  private UsbCamera camera;

  public RobotContainer() {
    camera = CameraServer.startAutomaticCapture();
    camera.setFPS(30);
    camera.setResolution(320, 240);

   // chooser.setName("Please Select and Auto"); // (this works; find alternatives)
    chooser.setDefaultOption("Do Nothing Auto", new TimedDrive(0, 0));
    chooser.addOption("Timed Drive Short", new TimedDrive(0.5, 2));
    chooser.addOption("Timed Drive Long", new TimedDrive(0.5, 5));
    // chooser.addOption("Do Nothing", ag.getDoNothingAuto());

  
    // chooser.addOption("Drive Straight", ag.getDriveStraightAuto());
    // chooser.addOption("Three Ball Auto", ag.getThreeBallAuto());
    // chooser.addOption("Five Ball Auto", ag.getFiveBallAuto());
    // chooser.addOption("Eight Ball Auto", ag.getEightBallAuto());
    // chooser.addOption("Ten Ball Auto", ag.getTenBallAuto());
    // chooser.addOption("Drive Around Post", ag.makeFollowingCommandForAuto("AroundPostTest.wpilib.json"));
    // chooser.addOption("Hold Position Test", new HoldPositionController());
    // chooser.addOption("Timed Drive", new TimedDrive(0.5, 2));
    // chooser.addOption("Trajectory Distance Drive", new DriveDistanceCommandGenerator(3).getCommand());
    // chooser.addOption("Trajectory Distance Drive Backwards", new DriveDistanceCommandGenerator(-3).getCommand());
  

    Shuffleboard.getTab("Selector").add(chooser);

    configureButtonBindings();
    configureDefaultCommands();
  }

  private void configureButtonBindings() {
    // Primary Driver Controls

    // new JoystickButton(xbox, Button.kA.value)
    //   .whenPressed(new TimedDrive(0.3,0.5));

    // new JoystickButton(xbox, Button.kB.value)
    //   .whenPressed(new TimedTurn(0.3,0.5));  
    new JoystickButton(xbox, Button.kLeftBumper.value)
      .whenPressed(new SpinIntakeIn())
      .whenPressed(new IncrementFeeder())
      .whenPressed(new DeployIntake())
      .whenReleased(new RetractIntake());

      new JoystickButton(xbox, Button.kRightBumper.value)
      .whenPressed(new SpinIntakeIn())
      .whenPressed(new IncrementFeeder())
      .whenPressed(new DeployIntake())
      .whenReleased(new RetractIntake());

    //  new JoystickButton(xbox2, Button.kRightBumper.value) 
    //   .whenPressed(new IncrementFeeder()) 
    //   .whenReleased(new StopFeeder());

    // new JoystickButton(xbox2, Button.kX.value)
    //   .whenPressed(new DeployFingers())
    //   .whenReleased(new RetractFingers());

    // new JoystickButton(xbox2, Button.kLeftBumper.value)
    //   .whenPressed(new FlywheelShootOut())
    //   .whenReleased(new FlywheelShootOff())
    //   .whenPressed(new spinSushiOn()) 
    //   .whenReleased(new spinSushiOff());

    new JoystickButton(joystick, 1)
      .whenPressed(new DeployFingers())
      .whenReleased(new RetractFingers());

    new JoystickButton(joystick,2) 
      .whenPressed(new spinSushiOn()) 
      .whenPressed(new IncrementFeeder())
      .whenPressed(new FlywheelShootOut())
      .whenReleased(new spinSushiOff())
      .whenReleased(new FlywheelShootOff());

      
      // .whenPressed(new FlywheelShootPole())


    
    /* Climber
    xbox2.dpadUp.whenPressed(new ExtendClimber());
    xbox2.dpadUp.whenReleased(new ClimberOff());
    xbox2.dpadDown.whenReleased(new ClimberOff());
    xbox2.dpadDown.whenPressed(new RetractClimber());
    */
  }

  private void configureDefaultCommands() {
    dt.setDefaultCommand(new Drive());
    
   // tr.setDefaultCommand(new AngleWithTurret());
  }

  public Command getAutonomousCommand() {
    return chooser.getSelected();
  }
}

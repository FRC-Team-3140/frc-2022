package frc.robot;

import frc.robot.commands.auto.DoNothingAuto;
import frc.robot.commands.auto.TaxiPreload;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.Intake.SpinIntakeIn;
// import frc.robot.commands.drivetrain.TimedTurn;
// import frc.robot.commands.drivetrain.MeterDrive;


//import frc.robot.commands.climber.ClimberOff;
//import frc.robot.commands.climber.ExtendClimber;
//import frc.robot.commands.climber.RetractClimber

import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
// import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.drivetrain.Drive;
import frc.robot.commands.feeder.IncrementFeeder;
// import frc.robot.commands.feeder.StopFeeder;
import frc.robot.commands.flywheel.FlywheelShootOff;
import frc.robot.commands.flywheel.FlywheelShootOut;
// import frc.robot.commands.flywheel.FlywheelShootPole;
import frc.robot.commands.pneumatics.Fingers.DeployFingers;
import frc.robot.commands.pneumatics.Fingers.RetractFingers;
import frc.robot.commands.pneumatics.Intake.DeployIntake;
import frc.robot.commands.pneumatics.Intake.RetractIntake;
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
  // public static final Hood hd = new Hood();
  // public static final Turret tr = new Turret();
  

  // public static final AutoGenerator ag = new AutoGenerator();
  private static final SendableChooser<Command> chooser = new SendableChooser<>();

  // Xbox controllers
  public static final SmoothXboxController xbox = new SmoothXboxController(xboxPrimaryDriver);
  public static final SmoothXboxController xbox2 = new SmoothXboxController(xboxSecondaryDriver);
  public static final Joystick joystick = new Joystick(joystickDriver);

  private UsbCamera camera;

  public RobotContainer() {
    camera = CameraServer.startAutomaticCapture();
    camera.setFPS(20);
    camera.setResolution(320, 240);


    chooser.setDefaultOption("Do Nothing Auto", new DoNothingAuto());
    chooser.addOption("TD: 2s", new TimedDrive(0.25, 2));
    chooser.addOption("RTD: 2s", new TimedDrive(-0.25, 2));
    chooser.addOption("TD: 5s", new TimedDrive(0.25, 5));
    chooser.addOption("RTD: 5s", new TimedDrive(-0.25, 5));
    chooser.addOption("Drive to LP", new TimedDrive(0.25, 2));
    chooser.addOption("Taxi & Preload", new TaxiPreload());


    Shuffleboard.getTab("Selector").add(chooser);

    configureButtonBindings();
    configureDefaultCommands();
  }

  private void configureButtonBindings() {

    // Primary Driver Controls

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

      new JoystickButton(xbox, Button.kX.value)
      .whenPressed(new TaxiPreload());
 
      new JoystickButton(joystick, 1)
      .whenPressed(new DeployFingers())
      .whenReleased(new RetractFingers());
      // .whenPressed(new spinSushiOn()) 
      // .whenReleased(new spinSushiOff())
      // .whenHeld(new FlywheelShootOut())
      
      new JoystickButton(joystick,2) 
      .whenPressed(new spinSushiOn()) 
      .whenReleased(new spinSushiOff());
      // .whenHeld(new FlywheelShootOut())



    
    /* Climber
    xbox2.dpadUp.whenPressed(new ExtendClimber());
    xbox2.dpadUp.whenReleased(new ClimberOff());
    xbox2.dpadDown.whenReleased(new ClimberOff());
    xbox2.dpadDown.whenPressed(new RetractClimber());
    */
  }

  private void configureDefaultCommands() {
    dt.setDefaultCommand(new Drive());
  }

  public Command getAutonomousCommand() {
    return chooser.getSelected();
  }
}

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
import frc.robot.commands.pneumatics.Intake.DeployIntake;
import frc.robot.commands.pneumatics.Intake.RetractIntake;
//import frc.robot.commands.turret.AngleWithTurret;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Flywheel;
// import frc.robot.subsystems.Hood;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pneumatics;
//import frc.robot.subsystems.Turret;
import frc.libs.*;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.XboxController.Axis;
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

  private UsbCamera camera;

  public RobotContainer() {
    camera = CameraServer.startAutomaticCapture();
    camera.setFPS(30);
    camera.setResolution(320, 240);

   // chooser.setName("Please Select and Auto"); // (this works; find alternatives)
    chooser.setDefaultOption("Timed Drive", new TimedDrive(0.5, 1));
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
    //xbox.leftBumper.whileHeld(new HoldPositionController());
    // xbox.rightBumper.whileHeld(new ReducedSpeedTurningDrive());

    new JoystickButton(xbox, Button.kA.value)
      .whenPressed(new TimedDrive(0.3,0.5));

    new JoystickButton(xbox, Button.kB.value)
      .whenPressed(new TimedTurn(0.3,0.5));  

    new JoystickButton(xbox, Button.kRightBumper.value)
      .whenPressed(new SpinIntakeIn())
      .whenPressed(new DeployIntake())
      .whenPressed(new IncrementFeeder())
      .whenReleased(new SpinIntakeOff())
      .whenReleased(new RetractIntake())
      .whenReleased(new StopFeeder());

    new JoystickButton(xbox, Button.kLeftBumper.value)
      .whenPressed(new FlywheelShootOut())
      .whenReleased(new FlywheelShootOff());

    // new JoystickButton(xbox, Axis.kRightTrigger)

      
    //if (timer is in endgame/last 30 seconds)
    // new JoystickButton(xbox, Button.kX.value)
    //  .whenPressed(new MoveClimber)
    
    //new JoystickButton(xbox, Button.kY.value)
    //  .whenPressed(new MoveClimber)


    
    /* Climber
    xbox2.dpadUp.whenPressed(new ExtendClimber());
    xbox2.dpadUp.whenReleased(new ClimberOff());
    xbox2.dpadDown.whenReleased(new ClimberOff());
    xbox2.dpadDown.whenPressed(new RetractClimber());
    */
  
    // xbox2 x automated shooting
    

    /* climber piston
    xbox2.start.whenPressed(new LockClimber());
    xbox2.select.whenPressed(new UnlockClimber());
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

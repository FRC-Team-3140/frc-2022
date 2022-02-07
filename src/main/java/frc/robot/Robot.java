package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import edu.wpi.first.wpilibj.motorcontrol.MotorController;
// import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.pneumatics.climber.UnlockClimber;
import frc.robot.commands.pneumatics.intake.RetractIntake;
// import frc.robot.Constants;
// import frc.robot.RobotContainer;
// import frc.robot.HardwareAdapter;

public class Robot extends TimedRobot {
  private Command autoCommand;
  private RobotContainer robotContainer;
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  // private Joystick m_rightStick;



  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.


    // m_myRobot = new DifferentialDrive(rightSideMotors, leftSideMotors);
    m_leftStick = new Joystick(0);

    robotContainer = new RobotContainer();

    new UnlockClimber().schedule();
    new RetractIntake().schedule();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    autoCommand = robotContainer.getAutonomousCommand();

    if (autoCommand != null) {
      autoCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    if (autoCommand != null) {
      autoCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(m_leftStick.getY(), -m_leftStick.getRawAxis(5));
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}

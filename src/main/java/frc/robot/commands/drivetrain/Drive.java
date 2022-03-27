package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Drive extends CommandBase {
  public Drive() {
    addRequirements(RobotContainer.dt);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    double throttle = -RobotContainer.xbox.getSmoothedMainY();
    double heading = -RobotContainer.xbox.getSmoothedAltX();
    heading *= 0.45;// make it a little less sensitive
    RobotContainer.dt.tankDrive(throttle - heading, throttle + heading);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

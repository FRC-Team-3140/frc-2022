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
    double LeftSide = RobotContainer.xbox.getLeftY();
    double RightSide = RobotContainer.xbox.getRightY();

    RobotContainer.dt.tankDrive(LeftSide, RightSide);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

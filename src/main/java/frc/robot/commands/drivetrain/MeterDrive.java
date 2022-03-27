package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.HardwareAdapter;
import frc.robot.RobotContainer;

public class MeterDrive extends CommandBase implements HardwareAdapter {
  private double throttle = 0;
  private double dist = 0;

  public MeterDrive(double throttle, double dist) {
    this.throttle = throttle;
    this.dist = dist;
    addRequirements(RobotContainer.dt);
  }

  @Override
  public void initialize() {
    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);
  }

  @Override
  public void execute() {
    RobotContainer.dt.tankDrive(throttle, throttle);
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.dt.tankDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return dist >= leftEncoder.getPosition() && dist >= rightEncoder.getPosition();
  }
}

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.HardwareAdapter;
import frc.robot.RobotContainer;

public class TurnToAngle extends CommandBase {
  private double throttle = 0;
  private double angle = 0;
  private double tolerance = 0;
  private boolean reinit = true;
  private double minSpeed = 0;

  private double currentAngle = 0;
  private boolean turningRight = false;

  public TurnToAngle(double throttle, double angle, double tolerance, boolean reinit, double minSpeed) {
    this.throttle = throttle;
    this.angle = angle;
    this.tolerance = tolerance;
    this.reinit = reinit;
    this.minSpeed = minSpeed;

    addRequirements(RobotContainer.dt);
  }

  @Override
  public void initialize() {
    if (reinit) {
      HardwareAdapter.navx.zeroYaw();
      currentAngle = 0;
    }

    // this logic will only run once
    turningRight = (angle > currentAngle); // move this
  }

  @Override
  public void execute() {
    currentAngle = HardwareAdapter.navx.getYaw();

    double power = Math.max(Math.abs((angle - currentAngle) / angle), minSpeed);

    // this logic runs multiple times
    if (turningRight) // to here, that way direction of turning can change if you overshoot your target
      RobotContainer.dt.tankDrive(throttle * power, -throttle * power);
    else
      RobotContainer.dt.tankDrive(-throttle * power, throttle * power);
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.dt.tankDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return Math.abs(angle - currentAngle) <= tolerance;
  }
}

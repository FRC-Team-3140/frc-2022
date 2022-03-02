package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.RobotContainer;

public class TurnToAngle extends CommandBase {
    private Timer timer = new Timer();
    private double throttle = 0;
    private double time = 0;

    // public TurnToAngle(double throttle, double time) {
    //   this.throttle = throttle;    (-throttle, throttle  or  throttle, -throttle)
    //   this.angle = angle;
    //   this.time = time;
    //   addRequirements(RobotContainer.dt);
  // }

    public TurnToAngle(double throttle, double time) {
    this.throttle = throttle;
    this.time = time;
    addRequirements(RobotContainer.dt);
  }

  @Override
  public void initialize() {
    // angle.get();
    timer.start();
  }

  @Override
  public void execute() {
    // RobotContainer.dt.turnToAngle(if __ turn ___ else turn ___)
    RobotContainer.dt.tankDrive(-throttle, throttle);
  }

  @Override
  public void end(boolean interrupted) {
      RobotContainer.dt.tankDrive(0, 0);
      timer.stop();
      timer.reset();
  }

  @Override
  public boolean isFinished() {
    // return angle.get() == angle;
    return timer.get() > time;
  }
}

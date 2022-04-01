package frc.robot.commands.selfTest;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.RobotContainer;

public class SelfTestTimedTurn extends CommandBase {
    private Timer timer = new Timer();
    private double throttle = 0;
    private double time = 0;


    public SelfTestTimedTurn(double throttle, double time) {
    this.throttle = throttle;
    this.time = time;
    addRequirements(RobotContainer.dt);
  }

  @Override
  public void initialize() {
      timer.start();
  }

  @Override
  public void execute() {
    RobotContainer.dt.tankDrive(-throttle, throttle);
  }

  @Override
  public void end(boolean interrupted) {
      // RobotContainer.dt.tankDrive(0, 0); Causes issues with self test
      timer.stop();
      timer.reset();
  }

  @Override
  public boolean isFinished() {
    return timer.get() > time;
  }
}

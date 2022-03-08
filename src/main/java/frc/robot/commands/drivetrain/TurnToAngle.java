package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.HardwareAdapter;
import frc.robot.RobotContainer;

public class TurnToAngle extends CommandBase {
    private double throttle = 0;
    private double angle = 0;

    public TurnToAngle(double throttle, double angle) {
    this.throttle = throttle;
    this.angle = angle;
    addRequirements(RobotContainer.dt);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    RobotContainer.dt.tankDrive(-throttle, throttle);
  } 


  
  @Override
  public void end(boolean interrupted) {
      RobotContainer.dt.tankDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return (HardwareAdapter.navx.getAngle()+ 360) % 360 <= angle;
  }
} 

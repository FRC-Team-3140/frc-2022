package frc.robot.commands.drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.HardwareAdapter;
import frc.robot.RobotContainer;
public class TurnToAngle extends CommandBase{
    private double throttle = 0;
    private double angle = 0;
    private double tolerance = 0;


    public TurnToAngle(double throttle, double angle, double tolerance) {
    this.throttle = throttle;
    this.angle = angle;
    this.tolerance = tolerance;
    addRequirements(RobotContainer.dt);
  }

  @Override
  public void initialize() {
    HardwareAdapter.navx.reset();
  }

  @Override
  public void execute() {
  double power = Math.max(Math.abs((this.angle - HardwareAdapter.navx.getYaw())/this.angle), 0.5);
    if (this.angle>0){
      RobotContainer.dt.tankDrive(throttle * power, -throttle * power);
    } 
    else {
      RobotContainer.dt.tankDrive(-throttle * power, throttle * power); 
    }
  } 


  
  @Override
  public void end(boolean interrupted) {
      RobotContainer.dt.tankDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    // return HardwareAdapter.navx.getYaw() + 180   <= angle + 5  && HardwareAdapter.navx.getYaw() + 180 >= angle - 5; 
    return Math.abs(angle - HardwareAdapter.navx.getYaw()) <= this.tolerance;
  }
} 

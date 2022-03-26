package frc.robot.commands.drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.HardwareAdapter;
import frc.robot.RobotContainer;
public class TurnToAngle extends CommandBase{
    private double throttle = 0;
    private double angle = 0;
    private double tolerance = 0;
    private double startPoint;
    private double currentAngle;
    private boolean reinit;
    private boolean turningRight;

    public TurnToAngle(double throttle, double angle, double tolerance, boolean reinit) {
    this.throttle = throttle;
    this.angle = angle;
    this.tolerance = tolerance;
    this.reinit = reinit;

    addRequirements(RobotContainer.dt);
  }

  @Override
  public void initialize() {
    if (this.reinit==true){
      HardwareAdapter.navx.zeroYaw();
      if (this.angle>0){
        this.turningRight=true;
      }
      else {
        this.turningRight=false;
      }
    }
    else{
      if (this.angle-this.currentAngle>0){
        this.turningRight=true;
      }
      else {
        this.turningRight=false;
      }
    }
  }
  
  @Override
  public void execute() {
    //modulus to keep in 0-360 range then shift back to -180 to 180 range with the subtraction
    this.currentAngle = HardwareAdapter.navx.getYaw();
    double power = Math.max(Math.abs((this.angle - this.currentAngle)/this.angle), 0.5);
    if (turningRight=true){
      RobotContainer.dt.tankDrive(throttle * power, -throttle * power);
    }
    else{
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
    return Math.abs(this.angle - this.currentAngle) <= this.tolerance;
  }
} 

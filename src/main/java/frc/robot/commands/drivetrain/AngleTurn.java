package frc.robot.commands.drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.HardwareAdapter;
import frc.robot.RobotContainer;
public class AngleTurn extends CommandBase implements HardwareAdapter {
    private double throttle = 0;
    private double angle = 0;
    private double tolerance = 0;
    private double minSpeed;
    private double currentAngle;

    public AngleTurn(double throttle, double tolerance, double minSpeed) {
    this.throttle = throttle;
    this.tolerance = tolerance;
    this.minSpeed = minSpeed;

    addRequirements(RobotContainer.dt);
  }

  @Override
  public void initialize() {
    HardwareAdapter.navx.zeroYaw();
    angle = table.getEntry("tx").getDouble(0.0);
    System.out.println("Vision Angle to turn to: " + Double.toString(angle));
  }
  
  @Override
  public void execute() {
    currentAngle = HardwareAdapter.navx.getYaw();
    double power = Math.max(Math.abs((angle - currentAngle) / angle), minSpeed);

    if (currentAngle > angle)
      RobotContainer.dt.tankDrive(-throttle * power, throttle * power);
   else
      RobotContainer.dt.tankDrive(throttle * power, -throttle * power);
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

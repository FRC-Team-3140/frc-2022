package frc.robot.subsystems;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ElectricalPortConstants.TurnMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.commands.drivetrain.TurnToAngle;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.HardwareAdapter;
import frc.robot.RobotContainer;


public class VisionAngle {
    float Kp = -0.1f;  // Proportional control constant 
   
NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    double tx = table.getEntry("tx").getDouble(0);
    
    private double throttle = 0;
    private double angle = 0;
    private double tolerance = 0;
    private double minSpeed;
    private double currentAngle;
    private boolean reinit;
    private boolean turningRight;

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
    if (this.reinit==true){
      HardwareAdapter.navx.zeroYaw();
    }
    if (this.angle>0){
      this.turningRight=true;
    }
    else {
      this.turningRight=false;
    }
  }
  
  @Override
  public void execute() {
    this.currentAngle = HardwareAdapter.navx.getYaw();
    double power = Math.max(Math.abs((this.angle - this.currentAngle)/this.angle), minSpeed);
    if (this.currentAngle>this.angle){
      this.turningRight=true;
    }
    else {
      this.turningRight=false;
    }
    if (this.turningRight==true){
      RobotContainer.dt.tankDrive(-throttle * power, throttle * power);
    }
   else {
      RobotContainer.dt.tankDrive(throttle * power, -throttle * power);
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



// if (joystick->GetRawButton(10)){

//         double heading_error = tx;
//         steering_adjust = Kp * tx;

//         left_command+=steering_adjust;
//         right_command-=steering_adjust;
    
// }

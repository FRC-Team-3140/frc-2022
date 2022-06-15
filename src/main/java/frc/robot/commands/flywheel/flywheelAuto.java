package frc.robot.commands.flywheel;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.HardwareAdapter;
import frc.robot.RobotContainer;

public class flywheelAuto extends CommandBase implements HardwareAdapter {
    public flywheelAuto(){
        addRequirements(RobotContainer.fw);
    }
    double length;
    @Override
    public void initialize() {
    NetworkTableInstance.getDefault().getTable("Testing").getEntry("Testing").setDouble(length);
    double angleAdjustment = table.getEntry("ty").getDouble(0.00);
    length = 68.5/(Math.tan(0.423 + angleAdjustment * Math.PI/180)) * 1.18 - 15.68;
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
         //low shot
         if(length < 122){
            RobotContainer.fw.shootValue(0.00094*length+ 0.2);
         }
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return true;
    }



    
    
}

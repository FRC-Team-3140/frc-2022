package frc.robot.commands.auto;
import java.lang.reflect.Array;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.commands.drivetrain.TurnToAngle;

public class Limelightvision extends SequentialCommandGroup {
    public Limelightvision() {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        
        // tv	Whether the limelight has any valid targets (0 or 1)
        // tx	Horizontal Offset From Crosshair To Target (-27 degrees to 27 degrees)
        // ty	Vertical Offset From Crosshair To Target (-20.5 degrees to 20.5 degrees)
        // ta	Target Area (0% of image to 100% of image)

        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");
        
        //read values periodically
        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);
        
        //post to smart dashboard periodically
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);
        double angle=0;
        addCommands(
            new TurnToAngle(0.5, angle, 20, true, .2),
            new TurnToAngle(0.15, angle, 0.5, false, .4)
        );
    }
  }
  
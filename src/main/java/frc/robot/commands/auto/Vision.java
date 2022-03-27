package frc.robot.commands.auto;
import java.lang.reflect.Array;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivetrain.TurnToAngle;

public class Vision extends SequentialCommandGroup {
    public Vision() {
        NetworkTableEntry xEntry;
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("Smartdashboard");
        xEntry = table.getEntry("x");
        int x_resolution = 640;
        double x = (xEntry.getDouble(0))/x_resolution*2-1; 
        // x is a value from -1 to 1 where 1 is
        // on the far right of the field of view and -1 is on the far left
        
        addCommands( 
          
      );
    }
  }
  
// package frc.robot.commands.auto;
// import java.lang.reflect.Array;

// import edu.wpi.first.networktables.EntryListenerFlags;
// import edu.wpi.first.networktables.NetworkTable;
// import edu.wpi.first.networktables.NetworkTableEntry;
// import edu.wpi.first.networktables.NetworkTableInstance;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
// import frc.robot.commands.drivetrain.TurnToAngle;
// import frc.robot.Constants;

// public class Vision extends SequentialCommandGroup {
//     public Vision() {
//         NetworkTableEntry xEntry;
//         NetworkTableInstance inst = NetworkTableInstance.getDefault();
//         NetworkTable table = inst.getTable("bounding box");
//         xEntry = table.getEntry("Center X Coord");
//         double x_res = Constants.GeneralConstants.RobotPhysicalConstants.x_resolution;
//         double x = (xEntry.getDouble(0))/x_res*2-1; 
//         // x is a value from -1 to 1 where 1 is
//         // on the far right of the field of view and -1 is on the far left
//         double angle=0;
//         double camera_FOV = 68.5; // the angle swing of the camera from left to right
//         angle = camera_FOV/2*x;
//         addCommands(
//                 new TurnToAngle(0.5, angle, 20, true, .2),
//                 new TurnToAngle(0.15, angle, 0.5, false, .4)
//         );
//     }
//   }
  
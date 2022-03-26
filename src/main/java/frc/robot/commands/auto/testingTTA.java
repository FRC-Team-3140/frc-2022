package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.drivetrain.TurnToAngle;


public class testingTTA extends SequentialCommandGroup {
  public testingTTA() {
    addCommands(
     new TimedDrive(0.25, 2), 
     new WaitCommand(0.5),
     new TurnToAngle(0.25, 90, 2)
     );
  }
}
package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.drivetrain.TurnToAngle;


public class testingTTA extends SequentialCommandGroup {
  public testingTTA() {
    addCommands(
     new TurnToAngle(0.15, 90, 20, true),
    //  new WaitCommand(2),
     new TurnToAngle(0.15, 90, 2, false)
     );
  }
}
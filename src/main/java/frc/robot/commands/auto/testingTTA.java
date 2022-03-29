package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.drivetrain.TurnToAngle;


public class testingTTA extends SequentialCommandGroup {
  public testingTTA() {
    addCommands(
     new TurnToAngle(0.5, 179, 1, true, .1),
     new WaitCommand(2),
     new TurnToAngle(0.2, 175, 1, false, .2)
     );
  }
}
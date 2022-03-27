package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.drivetrain.TurnToAngle;

public class testingTTA extends SequentialCommandGroup {
  public testingTTA() {
    addCommands(
        new TurnToAngle(0.5, -90, 20, true, .2),
        new WaitCommand(2),
        new TurnToAngle(0.15, -90, 3, false, .2));
  }
}
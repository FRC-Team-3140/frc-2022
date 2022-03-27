package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// This class will eventually be setup to provide a quick check in the pits for full robot functionality.
public class SelfTest extends SequentialCommandGroup {
    public SelfTest() {
      addCommands(
          new WaitCommand(1),
          new WaitCommand(2));
    }
  }

package frc.robot.commands.pneumatics.Fingers;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;

public class DeployFingers extends SequentialCommandGroup implements Constants {
  public DeployFingers() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(new MoveFingers(EXT), new WaitCommand(.2), new MoveFingers(OFF));
  }
}

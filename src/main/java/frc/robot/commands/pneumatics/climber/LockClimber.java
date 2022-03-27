package frc.robot.commands.pneumatics.climber;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class LockClimber extends SequentialCommandGroup implements Constants {
  public LockClimber() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(new MoveClimber(EXT), new WaitCommand(.2), new MoveClimber(OFF));
  }
}

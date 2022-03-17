package frc.robot.commands.pneumatics.Fingers;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;

public class RetractFingers extends SequentialCommandGroup implements Constants.GeneralConstants {

  public RetractFingers() {
    super(new MoveFingers(RET), new WaitCommand(.2), new MoveFingers(OFF));
  }
}

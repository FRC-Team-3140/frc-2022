package frc.robot.commands.pneumatics.Intake;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.commands.Intake.SpinIntakeOff;

public class RetractIntake extends SequentialCommandGroup implements Constants {
  public RetractIntake() {
    super(new MoveIntake(RET), new WaitCommand(.2), new MoveIntake(OFF), new WaitCommand(1), new SpinIntakeOff());
  }
}

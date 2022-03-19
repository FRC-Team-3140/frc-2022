package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Intake.SpinIntakeIn;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.drivetrain.TimedTurn;
import frc.robot.commands.feeder.IncrementFeeder;
import frc.robot.commands.feeder.StopFeeder;
import frc.robot.commands.pneumatics.Intake.DeployIntake;
import frc.robot.commands.pneumatics.Intake.RetractIntake;

public class AttemptShootAuto extends CommandBase {
  public AttemptShootAuto() {
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    new SequentialCommandGroup(new TimedDrive(0.5, 2), 
    new WaitCommand(1),
    new TimedTurn(0.5, 1),
    new IncrementFeeder(),
    new SpinIntakeIn(),
    new DeployIntake(),
    new WaitCommand(1),
    new RetractIntake(),
    new StopFeeder());
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}

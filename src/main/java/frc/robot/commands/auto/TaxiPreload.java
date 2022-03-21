package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Intake.SpinIntakeIn;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.feeder.IncrementFeeder;
import frc.robot.commands.feeder.StopFeeder;
import frc.robot.commands.flywheel.FlywheelShootOff;
import frc.robot.commands.flywheel.FlywheelShootOut;
import frc.robot.commands.pneumatics.Fingers.DeployFingers;
import frc.robot.commands.pneumatics.Fingers.RetractFingers;
import frc.robot.commands.pneumatics.Intake.DeployIntake;
import frc.robot.commands.pneumatics.Intake.RetractIntake;
import frc.robot.commands.sushiKicker.spinSushiOff;
import frc.robot.commands.sushiKicker.spinSushiOn;

public class TaxiPreload extends CommandBase {
  public TaxiPreload() {
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    new SequentialCommandGroup(
    new TimedDrive(-0.5, 2), 
    new WaitCommand(1),
    new FlywheelShootOut(),
    new spinSushiOn(),
    new IncrementFeeder(),
    new WaitCommand(1),
    new DeployFingers(),
    new WaitCommand(1),
    new spinSushiOff(),
    new FlywheelShootOff(),
    new StopFeeder(),
    new RetractFingers()
    );
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}

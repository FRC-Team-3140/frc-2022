package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Intake.SpinIntakeIn;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.drivetrain.TimedTurn;
import frc.robot.commands.feeder.IncrementFeeder;
import frc.robot.commands.feeder.StopFeeder;
import frc.robot.commands.flywheel.FlywheelShootOff;
import frc.robot.commands.flywheel.FlywheelShoot45;
import frc.robot.commands.flywheel.FlywheelShoot50;
import frc.robot.commands.pneumatics.Fingers.DeployFingers;
import frc.robot.commands.pneumatics.Fingers.RetractFingers;
import frc.robot.commands.pneumatics.Intake.DeployIntake;
import frc.robot.commands.pneumatics.Intake.RetractIntake;
import frc.robot.commands.sushiKicker.spinSushiOff;
import frc.robot.commands.sushiKicker.spinSushiOn;

public class FourBallAuto extends SequentialCommandGroup {
  public FourBallAuto() {
    addCommands(
        new DeployIntake(),
        new SpinIntakeIn(),
        new TimedDrive(0.25, 2),
        new WaitCommand(0.25),
        new RetractIntake(),
        new FlywheelShoot45(),
        new WaitCommand(0.5),
        new TimedTurn(0.25, 1.11),
        new spinSushiOn(),
        new IncrementFeeder(),
        new WaitCommand(1),
        new DeployFingers(),
        new WaitCommand(0.1),
        new RetractFingers(),
        new WaitCommand(1),
        new DeployFingers(),
        new WaitCommand(0.5),
        new StopFeeder(),
        new RetractFingers(),
        new TimedTurn(0.25, 0.95),
        new DeployIntake(),
        new SpinIntakeIn(),
        new TimedDrive(0.25, 1.6),
        new WaitCommand(2),
        new RetractIntake(),
        new TimedDrive(-0.25, 0.5),
        new FlywheelShoot50(),
        new TimedTurn(0.25, 1.3),
        new spinSushiOn(),
        new IncrementFeeder(),
        new WaitCommand(0.5),
        new DeployFingers(),
        new WaitCommand(0.5),
        new RetractFingers(),
        new WaitCommand(0.5),
        new DeployFingers(),
        new WaitCommand(0.5),
        new RetractFingers(),
        new spinSushiOff(),
        new FlywheelShootOff(),
        new StopFeeder());
  }
}

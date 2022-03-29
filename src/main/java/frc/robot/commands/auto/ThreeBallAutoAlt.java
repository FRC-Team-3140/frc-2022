package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.HardwareAdapter;
import frc.robot.Constants;
import frc.robot.commands.Intake.SpinIntakeIn;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.drivetrain.TimedTurn;
import frc.robot.commands.drivetrain.TurnToAngle;
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

public class ThreeBallAutoAlt extends SequentialCommandGroup {
  public ThreeBallAutoAlt() {
    addCommands(
        new DeployIntake(),
        new SpinIntakeIn(),
        new TimedDrive(0.6, 1),
        new WaitCommand(0.25),
        new IncrementFeeder(),
        new RetractIntake(),
        new FlywheelShoot45(),
        new TurnToAngle(0.25, 160, 10, true, 0.5),
        new StopFeeder(),
        new WaitCommand(2),
        new TurnToAngle(0.25, 160, 1, false, 0.2),
        new spinSushiOn(),
        new IncrementFeeder(),
        new WaitCommand(0.3),
        new DeployFingers(),
        new WaitCommand(0.4),
        new RetractFingers(),
        new WaitCommand(0.3),
        new DeployFingers(),
        new WaitCommand(0.4),
        new RetractFingers(),
        new StopFeeder(),
        new spinSushiOff(),
        new TurnToAngle(0.25, -172, 10, true, 0.8),
        new WaitCommand(2),
        new TurnToAngle(0.25, -172, 1, false, 0.2),
        new DeployIntake(),
        new SpinIntakeIn(),
        new TimedDrive(0.5, 1.3),
        new WaitCommand(0.25),
        new RetractIntake(),
        new TimedDrive(-0.5, 0.25),
        new WaitCommand(0.05),
        new TurnToAngle(0.25, 160, 10, true, 0.5),
        new WaitCommand(2),
        new TurnToAngle(0.25, 160, 1, false, 0.2),
        new FlywheelShoot50(),
        new IncrementFeeder(),
        new spinSushiOn(),
        new WaitCommand(0.1),
        new DeployFingers(),
        new WaitCommand(0.1),
        new RetractFingers(),
        new FlywheelShootOff(),
        new spinSushiOff(),
        new StopFeeder()
   );
  }
}

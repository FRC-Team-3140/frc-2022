package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Intake.SpinIntakeIn;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.drivetrain.TurnToAngle;
import frc.robot.commands.feeder.IncrementFeeder;
import frc.robot.commands.feeder.StopFeeder;
import frc.robot.commands.flywheel.FlywheelShootOff;
import frc.robot.commands.flywheel.FlywheelShoot40;
import frc.robot.commands.flywheel.FlywheelShoot45;
import frc.robot.commands.pneumatics.Fingers.DeployFingers;
import frc.robot.commands.pneumatics.Fingers.RetractFingers;
import frc.robot.commands.pneumatics.Intake.DeployIntake;
import frc.robot.commands.pneumatics.Intake.RetractIntake;
import frc.robot.commands.sushiKicker.spinSushiOff;
import frc.robot.commands.sushiKicker.spinSushiOn;

public class ThreeBallAutoMain extends SequentialCommandGroup {
  public ThreeBallAutoMain() {
    addCommands(
        new DeployIntake(),
        new SpinIntakeIn(),
        new TimedDrive(0.25, 2.25),
        new FlywheelShoot45(),
        new WaitCommand(0.25),
        new RetractIntake(),
        new IncrementFeeder(),
        new TurnToAngle(0.5, 156, 20, true, 0.3),
        new TurnToAngle(0.5, 156, 3, false, 0.2),
        new spinSushiOn(),
        new DeployFingers(),
        new WaitCommand(0.5),
        new RetractFingers(),
        new WaitCommand(1),
        new DeployFingers(),
        new WaitCommand(0.5),
        new RetractFingers(),
        new FlywheelShootOff(),
        new spinSushiOff(),
        new FlywheelShoot40(),
        new TurnToAngle(0.5, 60, 7, true, 0.3),
        new TurnToAngle(0.5, 60, 1, false, 0.2),
        new DeployIntake(),
        new SpinIntakeIn(),
        new TimedDrive(0.25, 2.9),
        new WaitCommand(0.1),
        new RetractIntake(),
        new TurnToAngle(0.5, -95, 10, true, 0.3),
        new TurnToAngle(0.5, -95, 1, false, 0.2),
        new spinSushiOn(),
        new DeployFingers(),
        new WaitCommand(0.5),
        new RetractFingers(),
        new WaitCommand(1),
        new DeployFingers(),
        new WaitCommand(0.5),
        new RetractFingers(),
        new spinSushiOff(),
        new FlywheelShootOff(),
        new StopFeeder()
   );
  }
}
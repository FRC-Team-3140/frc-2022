package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Intake.SpinIntakeIn;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.drivetrain.TurnToAngle;
import frc.robot.commands.feeder.IncrementFeeder;
import frc.robot.commands.feeder.StopFeeder;
import frc.robot.commands.flywheel.FlywheelShootOff;
import frc.robot.commands.flywheel.FlywheelShootValue;
import frc.robot.commands.pneumatics.Fingers.DeployFingers;
import frc.robot.commands.pneumatics.Fingers.RetractFingers;
import frc.robot.commands.pneumatics.Intake.DeployIntake;
import frc.robot.commands.pneumatics.Intake.RetractIntake;
import frc.robot.commands.sushiKicker.spinSushiOff;
import frc.robot.commands.sushiKicker.spinSushiOn;

public class TwoBallAuto extends SequentialCommandGroup {
  public TwoBallAuto() {
    addCommands(
        new DeployIntake(),
        new SpinIntakeIn(),
        new IncrementFeeder(),
        new TimedDrive(0.25, 2.25),
        new WaitCommand(0.25),
        new RetractIntake(),
        new FlywheelShootValue(0.43), // Was 0.45 on Thursday, hit dead center
        new WaitCommand(0.5),
        new TurnToAngle(0.5, 173, 20, true, 0.3),
        new TurnToAngle(0.5, 173, 3, false, 0.2),
        new spinSushiOn(),
        new WaitCommand(1),
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
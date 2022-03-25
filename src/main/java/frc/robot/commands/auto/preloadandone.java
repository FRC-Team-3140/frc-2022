package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Intake.SpinIntakeIn;
import frc.robot.commands.Intake.SpinIntakeOff;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.drivetrain.TimedTurn;
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

public class preloadandone extends SequentialCommandGroup {
  public preloadandone() {
    addCommands(
        new DeployIntake(),
        new SpinIntakeIn(),
        new IncrementFeeder(),
        new TimedDrive(0.25, 2),
        new WaitCommand(0.25),
        new RetractIntake(),
        new FlywheelShootOut(),
     new WaitCommand(0.5),
     new WaitCommand(0.5),
     new SpinIntakeOff(),
     new TimedTurn(0.25, 1.125),
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
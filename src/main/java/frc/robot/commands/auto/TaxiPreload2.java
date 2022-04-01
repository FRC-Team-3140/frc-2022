package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.feeder.IncrementFeeder;
import frc.robot.commands.feeder.StopFeeder;
import frc.robot.commands.flywheel.FlywheelShootOff;
import frc.robot.commands.flywheel.FlywheelShootValue;
import frc.robot.commands.pneumatics.Fingers.DeployFingers;
import frc.robot.commands.pneumatics.Fingers.RetractFingers;
import frc.robot.commands.sushiKicker.spinSushiOff;
import frc.robot.commands.sushiKicker.spinSushiOn;

public class TaxiPreload2 extends SequentialCommandGroup {
  public TaxiPreload2() {
    addCommands(
     new FlywheelShootValue(0.4),
     new TimedDrive(-0.25, 2), 
     new WaitCommand(1),
     new IncrementFeeder(),
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
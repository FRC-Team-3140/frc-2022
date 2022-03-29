package frc.robot.commands.flywheel;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.feeder.IncrementFeeder;
import frc.robot.commands.feeder.StopFeeder;
import frc.robot.commands.pneumatics.Fingers.DeployFingers;
import frc.robot.commands.pneumatics.Fingers.RetractFingers;
import frc.robot.commands.sushiKicker.spinSushiOff;
import frc.robot.commands.sushiKicker.spinSushiOn;
public class FlywheelFullRoutine extends SequentialCommandGroup {
    public FlywheelFullRoutine(int speed){
        addCommands(
            new FlywheelShootPercent(speed),
            new WaitCommand(1),
            new spinSushiOn(),
            new IncrementFeeder(),
            new DeployFingers(),
            new RetractFingers(),
            new StopFeeder(),
            new spinSushiOff(),
            new FlywheelShootOff()
        );
    }
}

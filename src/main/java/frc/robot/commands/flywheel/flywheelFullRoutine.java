package frc.robot.commands.flywheel;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivetrain.AngleTurn;
import frc.robot.commands.feeder.IncrementFeeder;
import frc.robot.commands.pneumatics.Fingers.DeployFingers;
import frc.robot.commands.pneumatics.Fingers.RetractFingers;

public class flywheelFullRoutine extends SequentialCommandGroup{
    public flywheelFullRoutine(){
        addCommands(new ParallelDeadlineGroup( new flywheelAuto(), new AngleTurn(.1, 3, .5), new IncrementFeeder()), new DeployFingers(), new RetractFingers());
    }
}

package frc.robot.commands.selfTest;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Intake.SpinIntakeIn;
import frc.robot.commands.Intake.SpinIntakeOff;
import frc.robot.commands.selfTest.SelfTestTimedDrive;
import frc.robot.commands.selfTest.SelfTestTimedTurn;
import frc.robot.commands.drivetrain.TurnToAngle;
import frc.robot.commands.feeder.IncrementFeeder;
import frc.robot.commands.feeder.StopFeeder;
import frc.robot.commands.flywheel.FlywheelShootValue;
import frc.robot.commands.pneumatics.Fingers.DeployFingers;
import frc.robot.commands.pneumatics.Fingers.RetractFingers;
import frc.robot.commands.pneumatics.Intake.DeployIntake;
import frc.robot.commands.pneumatics.Intake.RetractIntake;
import frc.robot.commands.sushiKicker.spinSushiOff;
import frc.robot.commands.sushiKicker.spinSushiOn;

// This class will eventually be setup to provide a quick check in the pits for full robot functionality.
public class RobotSelfTest extends SequentialCommandGroup {
    // In the future this should be improved, such that it implements
	// sensor checking to determine if motors are at the correct speed, voltage, and current
	// and that all other sensors, network interfaces, and systems are working properly
	public RobotSelfTest() {
		addCommands(
			/***********************
			 * Drive Systems Test
			 */
			// Increment Forwards Drive
			new SelfTestTimedDrive(0.0, 0.5),
			new SelfTestTimedDrive(0.1, 0.5),
			new SelfTestTimedDrive(0.2, 0.5),
			new SelfTestTimedDrive(0.3, 0.5),
			new SelfTestTimedDrive(0.4, 0.5),
			new SelfTestTimedDrive(0.5, 0.5),
			new SelfTestTimedDrive(0.6, 0.5),
			new SelfTestTimedDrive(0.7, 0.5),
			new SelfTestTimedDrive(0.8, 0.5),
			new SelfTestTimedDrive(0.9, 0.5),
			new SelfTestTimedDrive(1.0, 0.5),
			new SelfTestTimedDrive(0.9, 0.5),
			new SelfTestTimedDrive(0.8, 0.5),
			new SelfTestTimedDrive(0.7, 0.5),
			new SelfTestTimedDrive(0.6, 0.5),
			new SelfTestTimedDrive(0.5, 0.5),
			new SelfTestTimedDrive(0.4, 0.5),
			new SelfTestTimedDrive(0.3, 0.5),
			new SelfTestTimedDrive(0.2, 0.5),
			new SelfTestTimedDrive(0.1, 0.5),
			new SelfTestTimedDrive(0.0, 0.5),
			
			// Increment Backwards Drive
			new SelfTestTimedDrive(0.0, 0.5),
			new SelfTestTimedDrive(-0.1, 0.5),
			new SelfTestTimedDrive(-0.2, 0.5),
			new SelfTestTimedDrive(-0.3, 0.5),
			new SelfTestTimedDrive(-0.4, 0.5),
			new SelfTestTimedDrive(-0.5, 0.5),
			new SelfTestTimedDrive(-0.6, 0.5),
			new SelfTestTimedDrive(-0.7, 0.5),
			new SelfTestTimedDrive(-0.8, 0.5),
			new SelfTestTimedDrive(-0.9, 0.5),
			new SelfTestTimedDrive(-1.0, 0.5),
			new SelfTestTimedDrive(-0.9, 0.5),
			new SelfTestTimedDrive(-0.8, 0.5),
			new SelfTestTimedDrive(-0.7, 0.5),
			new SelfTestTimedDrive(-0.6, 0.5),
			new SelfTestTimedDrive(-0.5, 0.5),
			new SelfTestTimedDrive(-0.4, 0.5),
			new SelfTestTimedDrive(-0.3, 0.5),
			new SelfTestTimedDrive(-0.2, 0.5),
			new SelfTestTimedDrive(-0.1, 0.5),
			new SelfTestTimedDrive(0.0, 0.5),
			
			// Increment Left Turn
			new SelfTestTimedDrive(0.0, 0.5),
			new SelfTestTimedTurn(-0.1, 0.5),
			new SelfTestTimedTurn(-0.2, 0.5),
			new SelfTestTimedTurn(-0.3, 0.5),
			new SelfTestTimedTurn(-0.4, 0.5),
			new SelfTestTimedTurn(-0.5, 0.5),
			new SelfTestTimedTurn(-0.6, 0.5),
			new SelfTestTimedTurn(-0.7, 0.5),
			new SelfTestTimedTurn(-0.8, 0.5),
			new SelfTestTimedTurn(-0.9, 0.5),
			new SelfTestTimedTurn(-1.0, 0.5),
			new SelfTestTimedTurn(-0.9, 0.5),
			new SelfTestTimedTurn(-0.8, 0.5),
			new SelfTestTimedTurn(-0.7, 0.5),
			new SelfTestTimedTurn(-0.6, 0.5),
			new SelfTestTimedTurn(-0.5, 0.5),
			new SelfTestTimedTurn(-0.4, 0.5),
			new SelfTestTimedTurn(-0.3, 0.5),
			new SelfTestTimedTurn(-0.2, 0.5),
			new SelfTestTimedTurn(-0.1, 0.5),
			new SelfTestTimedDrive(0.0, 0.5),

			// Increment Right Turn
			new SelfTestTimedDrive(0.0, 0.5),
			new SelfTestTimedTurn(0.1, 0.5),
			new SelfTestTimedTurn(0.2, 0.5),
			new SelfTestTimedTurn(0.3, 0.5),
			new SelfTestTimedTurn(0.4, 0.5),
			new SelfTestTimedTurn(0.5, 0.5),
			new SelfTestTimedTurn(0.6, 0.5),
			new SelfTestTimedTurn(0.7, 0.5),
			new SelfTestTimedTurn(0.8, 0.5),
			new SelfTestTimedTurn(0.9, 0.5),
			new SelfTestTimedTurn(1.0, 0.5),
			new SelfTestTimedTurn(0.9, 0.5),
			new SelfTestTimedTurn(0.8, 0.5),
			new SelfTestTimedTurn(0.7, 0.5),
			new SelfTestTimedTurn(0.6, 0.5),
			new SelfTestTimedTurn(0.5, 0.5),
			new SelfTestTimedTurn(0.4, 0.5),
			new SelfTestTimedTurn(0.3, 0.5),
			new SelfTestTimedTurn(0.2, 0.5),
			new SelfTestTimedTurn(0.1, 0.5),
			new SelfTestTimedTurn(0.0, 0.5),
					
			// Turn To Angle
			new TurnToAngle(0.5, 45, 20, true, 0.3), // Right 45
			new WaitCommand(1),
			new TurnToAngle(0.5, -45, 20, true, 0.3), // Return to 0
			new WaitCommand(1),
			new TurnToAngle(0.5, -45, 20, true, 0.3), // Left 45
			new WaitCommand(1),
			new TurnToAngle(0.5, 45, 20, true, 0.3), // Return to 0
			new WaitCommand(1),
			new TurnToAngle(0.5, 90, 20, true, 0.3), // Right 90
			new WaitCommand(1),
			new TurnToAngle(0.5, -90, 20, true, 0.3), // Return to 0
			new WaitCommand(1),
			new TurnToAngle(0.5, -90, 20, true, 0.3), // Left 90
			new WaitCommand(1),
			new TurnToAngle(0.5, 90, 20, true, 0.3), // Return to 0
			new WaitCommand(1),
			new TurnToAngle(0.5, 180, 20, true, 0.3), // Right 180
			new WaitCommand(1),
			new TurnToAngle(0.5, -180, 20, true, 0.3), // Return to 0
			new WaitCommand(1),
			new TurnToAngle(0.5, -180, 20, true, 0.3), // Left 180
			new WaitCommand(1),
			new TurnToAngle(0.5, 180, 20, true, 0.3), // Return to 0
					
			// Stop & Wait
			new SelfTestTimedDrive(0.0, 0.5),

			/***********************
			 * Flywheel Test
			 */
			// Ramp Up
			new FlywheelShootValue(0.1),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.2),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.3),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.4),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.5),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.6),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.7),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.8),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.9),
			new WaitCommand(0.5),
			new FlywheelShootValue(1.0),
			new WaitCommand(0.5),
			// Ramp Down
			new FlywheelShootValue(1.0),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.9),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.8),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.7),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.6),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.5),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.4),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.3),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.2),
			new WaitCommand(0.5),
			new FlywheelShootValue(0.1),
			new WaitCommand(0.5),
			// Full Off
			new FlywheelShootValue(0.0),

			/***********************
			 * Sushi Kicker Test
			 */
			new spinSushiOn(),
			new WaitCommand(3),
			new spinSushiOff(),
			
			/***********************
			 * Feeder System Test
			 */
			new IncrementFeeder(),
			new WaitCommand(3),
			new StopFeeder(),
			
			/***********************
			 * Pneumatics System Test
			 */
			// Intake System (Pneumatics and Motors Test)
			new DeployIntake(), // Deploy First for intake wheel clearance
			new SpinIntakeIn(),
			new WaitCommand(3),
			new SpinIntakeOff(),
			new RetractIntake(),

			// Fingers
			new DeployFingers(),
			new WaitCommand(1.0),
			new RetractFingers(),
			new WaitCommand(1.0),
			new DeployFingers(),
			new WaitCommand(1.0),
			new RetractFingers()
		);
	}	
  }

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 */

// Use meters, seconds, degrees (180deg to -180deg) (CCWP), and volts for all units.
public interface Constants {
	// Use meters, seconds, degrees (180deg to -180deg) (CCWP), and volts for all units.
	public interface GeneralConstants {
		// Pnuematics
		public final static Value EXT = Value.kForward;
		public final static Value RET = Value.kReverse;
		public final static Value OFF = Value.kOff;  
		// OI
		public final static double DEADBAND = 0.2;

		// Use meters, seconds, degrees (180deg to -180deg) (CCWP), and volts for all units.
		public interface PhysicalConstants {
			public final double heightDeltaFromShooterReleaseToPowerPortCenter = 0; // m
			// Field dimensions, etc.
			
		}

		// Use meters, seconds, degrees (180deg to -180deg), and volts for all motion profiling based units.
		public interface RobotPhysicalConstants {
			// Robot dimensions  (these will need to be updated to the 2022 counts)
			public static final double robotLengthIntakeInWithBumpers = 0.953;
			public static final double robotLengthIntakeOutWithBumpers = 1.1;
			public static final double robotWidthWithBumpers = 0.889;
			public static final double shooterCenterFromRobotRearWithBumpers = 0.734;
						
			// Camera offsets
			public static final int x_resolution = 640;
			public static final int y_resolution = 480;

			// Gear Ratio's  (these will need to be updated to the 2022 counts)
			public static final double driveTrainGearRatio = 7.88;
			public static final double flyWheelGearRatio = 0.7159;
			public static final double turretGearRatio = 11.1;
			public static final double hoodDegreesPerRotation = 0;

			// Diameters  (these will need to be updated to the 2022 counts)
			public static final double wheelDiameterMeters = 0.1524;
			public static final double flyWheelDiameterMeters = 0.1016;
		}

		// Use meters, seconds, degrees (180deg to -180deg) (CCWP), and volts for all units.
		public interface SensorConstants {
			// Gyro
			// True to make Counter Clockwise Angles Positive, and Clockwise Negative.
			public static final boolean kGyroReversed = true; 

			// Position Conversions
			// (Native units for the Spark Max are in Rotations)
			public static final int kDriveTrainEncoderCPR = 1; // Encoder Counts/Pulses per Rotation (usually > 1)
			public static final int kFlyWheelEncoderCPR = 1; // Encoder Counts/Pulses per Rotation (usually > 1)
			public static final double kDriveTrainEncoderMetersPerPulse = (RobotPhysicalConstants.wheelDiameterMeters
					* Math.PI) / ((double) kDriveTrainEncoderCPR * RobotPhysicalConstants.driveTrainGearRatio);
			public static final double kFlyWheelEncoderMetersPerPulse = (RobotPhysicalConstants.flyWheelDiameterMeters
					* Math.PI) / ((double) kFlyWheelEncoderCPR * RobotPhysicalConstants.flyWheelGearRatio);

			// Velocity Conversions
			public static final double RPM_to_RPS = ((double) 1 / 60);
			public static final double driveTrainMetersPerRotation = kDriveTrainEncoderMetersPerPulse
					* kDriveTrainEncoderCPR;
			public static final double flyWheelMetersPerRotation = kFlyWheelEncoderMetersPerPulse
					* kFlyWheelEncoderCPR;
			public static final double kDriveTrainEncoderLinearMetersPerSecondPerRPM = driveTrainMetersPerRotation
					* RPM_to_RPS;
			public static final double kFlyWheelEncoderLinearMetersPerSecondPerRPM = flyWheelMetersPerRotation
					* RPM_to_RPS;
		}
	}

	public interface ElectricalPortConstants {
		// Xbox Controllers
		public static final int xboxPrimaryDriver = 0;
		public static final int xboxSecondaryDriver = 2;
		public static final int joystickDriver = 1;

		// Other Can Bus
		public final static int PDP = 0;
		public final static int PCM = 1;

		// Drivetrain
		public final static int rightMotor1 = 6;
		public final static int rightMotor2 = 5;
		public final static int rightMotor3 = 4;
		public final static int leftMotor1 = 1;
		public final static int leftMotor2 = 2;
		public final static int leftMotor3 = 3;

		public static enum TurnMode {Right, Left};

		// Intake
		public final static int intakeMotor1 = 9;
		public final static int intakeMotor2 = 10;

		// Flywheel
		public final static int flyWheelMotor1 = 7;
		public final static int flyWheelMotor2 = 8;

		// Feeders
		public final static int sushiMotor = 11;

		// Climber
		public final static int climberMotor1 = 13;
		public final static int climberMotor2 = 14;

		// Shooter Rotary Components
		// public final static int hoodMotor = 15;
		// public final static int turretMotor = 16;

		// Limit Switches
		public final static int HOOD_LIMIT = 0;
		public final static int TURRET_LIMIT = 1;

		// Pnuematic solenoids
		public final static int INTAKE_SOLENOID_EXT = 3;
		public final static int INTAKE_SOLENOID_RET = 2;
		public final static int CLIMBER_LOCK_SOLENOID_EXT = 0;
		public final static int CLIMBER_LOCK_SOLENOID_RET = 1;
	}

	// Update from Characterization tool.
	// Use meters, seconds, degrees (180deg to -180deg), and volts for all motion profiling based units.
	public interface ControllerConstants {
		public interface General {
			// Ramsete controller recommended values
			public static final double kRamseteB = 2;
			public static final double kRamseteZeta = 0.7;

			// Max speed and acceleration for trajectories
			// Both must be positive values
			// -------------These are approximate right now, verify on robot--------------
    		public static final double trajectoryMaxVelocity = 4; // m/s
    		public static final double trajectoryMaxAcceleration = 2; // m/s^2  
		}

		public interface DriveTrain {
			// Uses velocity control constants generated from characterization tool
			public interface TrajectoryFollowing {
				// Distance between wheel centers + needed controller gain offsets
				// Generated from Robot Characterization tool, should be a positive number (generally > 0.33m)
				public static final double kTrackWidthMeters = 0;
				public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(
					kTrackWidthMeters);

				// The constants below are 10X the characterization tool output's.
				public static final double ksVolts = 0;
				public static final double kvVoltSecondsPerMeter = 0;
				public static final double kaVoltSecondsSquaredPerMeter = 0;
				// The constants below are not 10X
				public static final double kPDriveVel = 0;
				public static final double kIDriveVel = 0;
				public static final double kDDriveVel = 0;
			}

			// Uses posiiton control constants generated from characterization tool
			public interface HoldPosition {
				// Hold Position
				// From characterization tool using position instead of velocity modes
				// Use P gain only
				// Max position error 0.01 units
				// Max velocitry error 0.02 units
				// Max control effort 7 volts
				public static final double holdPositonKP = 0;
				public static final double holdPositonKI = 0;
				public static final double holdPositonKD = 0;
			}
		}

		// Uses velocity control constants generated from characterization tool
		public interface FlyWheel {
			// The constants below are 10X the characterization tool output's.
			public static final double ksVolts = 0;
			public static final double kvVoltSecondsPerMeter = 0;
			public static final double kaVoltSecondsSquaredPerMeter = 0;
			// The constants below are not 10X
			public static final double kPDriveVel = 0;
			public static final double kIDriveVel = 0;
			public static final double kDDriveVel = 0;
		}
	}
}
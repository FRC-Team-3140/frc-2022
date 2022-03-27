package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 */

public interface Constants {
	// Pnuematics
	public final static Value EXT = Value.kForward;
	public final static Value RET = Value.kReverse;
	public final static Value OFF = Value.kOff;

	// OI
	public final static double DEADBAND = 0.2; // Unused

	// Xbox Controllers
	public static final int xboxPrimaryDriver = 0;
	public static final int xboxSecondaryDriver = 2;
	public static final int joystickDriver = 1;

	// Update for 2022
	public static final double driveTrainGearRatio = 7.88; // (Rotations of motor / Rotations of wheel)
	public static final double wheelDiameterMeters = 0.1524;

	// Encoder Conversions (Native units for the Spark Max are in Rotations)
	// Position Conversions
	public static final int kDriveTrainEncoderCPR = 1; // Encoder Counts/Pulses per Rotation (greater than 1 for other
														// encoder brands)
	public static final double kDriveTrainEncoderMetersPerPulse = (wheelDiameterMeters
			* Math.PI) / ((double) kDriveTrainEncoderCPR * driveTrainGearRatio);
	public static final double driveTrainMetersPerRotation = kDriveTrainEncoderMetersPerPulse
			* kDriveTrainEncoderCPR;

	// Velocity Conversions
	public static final double RPM_to_RPS = ((double) 1 / 60);
	public static final double kDriveTrainEncoderLinearMetersPerSecondPerRPM = driveTrainMetersPerRotation
			* RPM_to_RPS;
}
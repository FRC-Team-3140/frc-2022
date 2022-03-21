package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import edu.wpi.first.math.geometry.Pose2d;
// import edu.wpi.first.math.geometry.Rotation2d;
// import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
// import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;
import frc.robot.Constants;


public class Drivetrain extends SubsystemBase implements HardwareAdapter, Constants.GeneralConstants.SensorConstants {
  // The robot's drive
  private final DifferentialDrive dt = new DifferentialDrive(leftSideMotors, rightSideMotors);

  /** Creates a new DriveSubsystem. */
  public Drivetrain() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    leftEncoder.setPositionConversionFactor(kDriveTrainEncoderMetersPerPulse);
    rightEncoder.setPositionConversionFactor(kDriveTrainEncoderMetersPerPulse);
    leftEncoder.setVelocityConversionFactor(kDriveTrainEncoderLinearMetersPerSecondPerRPM);
    rightEncoder.setVelocityConversionFactor(kDriveTrainEncoderLinearMetersPerSecondPerRPM);
    rightMotor1.setInverted(true);
    rightMotor1.setSmartCurrentLimit(60);
    rightMotor1.burnFlash();
    rightMotor2.setInverted(true);
    rightMotor2.setSmartCurrentLimit(60);
    rightMotor2.burnFlash();
    rightMotor3.setInverted(true);
    rightMotor3.setSmartCurrentLimit(60);
    rightMotor3.burnFlash();
    leftMotor1.setInverted(false);
    leftMotor1.setSmartCurrentLimit(60);
    leftMotor1.burnFlash();
    leftMotor2.setInverted(false);
    leftMotor2.setSmartCurrentLimit(60);
    leftMotor2.burnFlash();
    leftMotor3.setInverted(false);
    leftMotor3.setSmartCurrentLimit(60);
    leftMotor3.burnFlash();
  }

  /**
   * Arcade drive method for differential drive platform.
   *
   * @param speed The robot's speed along the foward/reverse axis [-1.0..1.0]. Forward is positive.
   * @param rotation The robot's rotation rate around the Z/vertical axis [-1.0..1.0]. Clockwise is
   *     positive.
   */
  public void arcadeDrive(double speed, double rotation) {
    dt.arcadeDrive(speed, rotation, false);
    //We do not need to square inputs because we cube the inputs
    // with SmoothXboxController's getSmooth____() classes so the
    //the last argument to arcadeDrive is false
  }

  /**
   * Tank drive method for differential drive platform.
   *
   * @param leftSpeed The robot's left side speed along the X axis [-1.0..1.0]. Forward is positive.
   * @param rightSpeed The robot's right side speed along the X axis [-1.0..1.0]. Forward is
   *     positive.
   */
  public void tankDrive(double leftSpeed, double rightSpeed) {
    dt.tankDrive(leftSpeed, rightSpeed, false); 
    //We do not need to square inputs because we cube the inputs
    // with SmoothXboxController's getSmooth____() classes so the
    //the last argument to tankDrive is false
  }

  public void timedTurn(TurnMode mode, double throttle) {
		if (mode == TurnMode.Left) tankDrive(-throttle, throttle);
		if (mode == TurnMode.Right) tankDrive(throttle, -throttle);
	}

}



// public class Drivetrain extends DifferentialDrive implements HardwareAdapter, Constants.GeneralConstants.SensorConstants {
//   private final DifferentialDriveOdometry odometry;
//   private boolean reversedTrajectory = false;
//     boolean leftInverted = true;
//     boolean rightInverted = false;

//     leftSideMotors.setInverted(leftInverted);

//     rightSideMotors.setInverted(rightInverted);

//     setIdleMode(IdleMode.kBrake);
//   public Drivetrain() {
//     super(leftSideMotors, rightSideMotors);
//     setupMotors();
//     leftEncoder.setPositionConversionFactor(kDriveTrainEncoderMetersPerPulse);
//     rightEncoder.setPositionConversionFactor(kDriveTrainEncoderMetersPerPulse);
//     leftEncoder.setVelocityConversionFactor(kDriveTrainEncoderLinearMetersPerSecondPerRPM);
//     rightEncoder.setVelocityConversionFactor(kDriveTrainEncoderLinearMetersPerSecondPerRPM);
//     resetEncoders();
//     resetGyro();
//     this.odometry = new DifferentialDriveOdometry(Rotation2d.fromDegrees(getHeading()));
//   }
//   /**********
//    * CONFIG *
//    **********/

//   public void setIdleMode(IdleMode mode) {
//     ((CANSparkMax) rightMotor1).setIdleMode(mode);
//     ((CANSparkMax) rightMotor2).setIdleMode(mode);
//     ((CANSparkMax) rightMotor3).setIdleMode(mode);

//     ((CANSparkMax) leftMotor1).setIdleMode(mode);
//     ((CANSparkMax) leftMotor2).setIdleMode(mode);
//     ((CANSparkMax) leftMotor3).setIdleMode(mode);

//   // (problem here, not sure why; if fixable change to fixed version)
//     // leftMotor3.setIdleMode(mode); 
//   }

//   /**********
//    * RESETS *
//    **********/

//   public void resetEncoders() {
//     leftEncoder.setPosition(0);
//     rightEncoder.setPosition(0);
//   }

//   public void resetGyro() {
//     navx.reset();
//   }
  
//   private void resetOdometry() {
//     Pose2d defaultPose = new Pose2d();
//     odometry.resetPosition(defaultPose, Rotation2d.fromDegrees(getHeading()));
//   }
  
//   public void resetAll() {
//     resetEncoders();
//     resetGyro();
//     resetOdometry();
//   }

//   /******************
//    * GETTER METHODS *
//    ******************/

//   public IdleMode getIdleMode() {
//     return ((CANSparkMax) leftMotor1).getIdleMode();
//   }

//   public boolean isTrajectoryReversed() {
//     return reversedTrajectory;
//   }
  
//   public double getLeftEncoderDistance() {
//     double output = leftEncoder.getPosition();

//     return reversedTrajectory ? -output : output;
//   }

//   public double getRightEncoderDistance() {
//     double output = rightEncoder.getPosition();

//     return reversedTrajectory ? -output : output;
//   }

//   public double getLeftEncoderVelocity() {
//     double output = rightEncoder.getVelocity();

//     return reversedTrajectory ? -output : output;
//   }

//   public double getRightEncoderVelocity() {
//     double output = rightEncoder.getVelocity();

//     return reversedTrajectory ? -output : output;
//   }

//   // Returns left and right linear speeds in m/s j
//   public DifferentialDriveWheelSpeeds getWheelSpeeds() {
//     if(isTrajectoryReversed())
//       return new DifferentialDriveWheelSpeeds(getRightEncoderVelocity(), getLeftEncoderVelocity());
//     else
//       return new DifferentialDriveWheelSpeeds(getLeftEncoderVelocity(), getRightEncoderVelocity());
//   }

//   // (kGyroReversed == true) 180 deg. to -180 deg. CCWP
//   // (kGyroReversed == false) -180 deg. to 180 deg. CWP
//   public double getHeading() {
//     return navx.getYaw() * (kGyroReversed ? -1.0 : 1.0);
//   }

//   public Pose2d getCurrentPose() {
//     return odometry.getPoseMeters();
//   }
// }

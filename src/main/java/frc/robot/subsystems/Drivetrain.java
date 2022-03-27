package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase implements HardwareAdapter, Constants {
  private final DifferentialDrive dt = new DifferentialDrive(leftSideMotors, rightSideMotors);

  public Drivetrain() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.

    leftEncoder.setPositionConversionFactor(kDriveTrainEncoderMetersPerPulse);
    rightEncoder.setPositionConversionFactor(kDriveTrainEncoderMetersPerPulse);
    leftEncoder.setVelocityConversionFactor(kDriveTrainEncoderLinearMetersPerSecondPerRPM);
    rightEncoder.setVelocityConversionFactor(kDriveTrainEncoderLinearMetersPerSecondPerRPM);

    // rightMotor1.setInverted(true);
    rightMotor1.setSmartCurrentLimit(60);
    rightMotor1.burnFlash();
    // rightMotor2.setInverted(true);
    rightMotor2.setSmartCurrentLimit(60);
    rightMotor2.burnFlash();
    // rightMotor3.setInverted(true);
    rightMotor3.setSmartCurrentLimit(60);
    rightMotor3.burnFlash();
    // leftMotor1.setInverted(false);
    leftMotor1.setSmartCurrentLimit(60);
    leftMotor1.burnFlash();
    // leftMotor2.setInverted(false);
    leftMotor2.setSmartCurrentLimit(60);
    leftMotor2.burnFlash();
    // leftMotor3.setInverted(false);
    leftMotor3.setSmartCurrentLimit(60);
    leftMotor3.burnFlash();
  }

  /**
   * Arcade drive method for differential drive platform.
   *
   * @param speed    The robot's speed along the foward/reverse axis [-1.0..1.0].
   *                 Forward is positive.
   * @param rotation The robot's rotation rate around the Z/vertical axis
   *                 [-1.0..1.0]. Clockwise is
   *                 positive.
   */
  public void arcadeDrive(double speed, double rotation) {
    // We do not need to square inputs because we cube the inputs
    // with SmoothXboxController's getSmooth____() classes so the
    // the last argument to arcadeDrive is false

    dt.arcadeDrive(speed, rotation, false);
  }

  /**
   * Tank drive method for differential drive platform.
   *
   * @param leftSpeed  The robot's left side speed along the X axis [-1.0..1.0].
   *                   Forward is positive.
   * @param rightSpeed The robot's right side speed along the X axis [-1.0..1.0].
   *                   Forward is
   *                   positive.
   */
  public void tankDrive(double leftSpeed, double rightSpeed) {
    // We do not need to square inputs because we cube the inputs
    // with SmoothXboxController's getSmooth____() classes so the
    // the last argument to tankDrive is false
    
    dt.tankDrive(leftSpeed, rightSpeed, false);
  }
}

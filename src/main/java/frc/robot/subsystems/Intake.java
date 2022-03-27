package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

public class Intake extends SubsystemBase implements HardwareAdapter {
  public Intake() {
    intakeMotor1.setInverted(true);
    intakeMotor1.burnFlash();
    intakeMotor2.setInverted(false);
    intakeMotor2.burnFlash();
  }

  public void spinIn() {
    intakeMotors.set(0.5);
  }

  public void spinOff() {
    intakeMotors.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

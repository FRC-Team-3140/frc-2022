package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

public class Intake extends SubsystemBase implements HardwareAdapter {
  public Intake() {
  }

  public void spinIn() {
    intakeMotor.set(1);
  }

  public void spinOff() {
    intakeMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}


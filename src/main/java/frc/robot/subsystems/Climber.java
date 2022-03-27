package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

public class Climber extends SubsystemBase implements HardwareAdapter {
  public Climber() {
  }

  public void climberExtend() {
    // climberMotors.set(1);
  }

  public void climberRetract() {
    // climberMotors.set(-1);
  }

  public void climberOff() {
    // climberMotors.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.HardwareAdapter;

public class Pneumatics extends SubsystemBase  implements Constants, HardwareAdapter {
  public Pneumatics() {
  }

  public void setIntakeState(Value v) {
    intakeSolenoid.set(v);
  }

  public void setFingerState(Value v) {
    fingerSolenoid.set(v);
  }

  public void setClimberLockState(Value v) {
    climberLockSolenoid.set(v);
  }

  public void setClimberState(Value v) {
    climberSolenoid.set(v);
  }

  @Override
  public void periodic() {
  }
}

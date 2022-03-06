package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

public class Feeder extends SubsystemBase implements HardwareAdapter {
  public Feeder() {
  }

  public void feedShooter() {
    feedMotor.set(-1);
  }

  public void reverseFeeder() {
    feedMotor.set(1);
  }

  public void pushUpFeeder() {
    feedMotor.set(-0.5);
  }

  public void stopFeed() {
    feedMotor.set(0);
  }

  @Override
  public void periodic() {
  }
}
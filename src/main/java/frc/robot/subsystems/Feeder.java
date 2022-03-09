package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

public class Feeder extends SubsystemBase implements HardwareAdapter {
  public Feeder() {
  }

  public void feedForward() {
    feedMotor.set(ControlMode.PercentOutput, -1);
  }

  public void stopFeed() {
    feedMotor.set(ControlMode.PercentOutput, 0);

  }

  @Override
  public void periodic() {
  }
}
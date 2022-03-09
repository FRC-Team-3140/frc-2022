package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Intake extends SubsystemBase implements HardwareAdapter {
  public final MotorControllerGroup intakeMotors;
  public Intake() {
    intakeMotor1.setInverted(true);
    intakeMotor2.setInverted(false);
    intakeMotors = new MotorControllerGroup(intakeMotor1, intakeMotor2);
  }

  public void spinIn() {
    intakeMotors.set(1);
  }

  public void spinOff() {
    intakeMotors.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}


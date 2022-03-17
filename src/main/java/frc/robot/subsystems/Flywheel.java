/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Flywheel extends SubsystemBase implements HardwareAdapter {
  public final MotorControllerGroup flywheelMotors;
  public Flywheel() {
    flywheelMotor1.setInverted(true);
    flywheelMotor2.setInverted(false);
    flywheelMotors = new MotorControllerGroup(flywheelMotor1, flywheelMotor2);
  }
   
  public void shootOut() {
    flywheelMotors.set(RobotContainer.xbox.getLeftTriggerAxis());
  }

  public void shootOff() {
    flywheelMotors.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
// import com.ctre.phoenix.motorcontrol.ControlMode;


public class Flywheel extends SubsystemBase implements HardwareAdapter {
  public final MotorControllerGroup flywheelMotors;
  public Flywheel() {
    flywheelMotor1.setInverted(true);
    flywheelMotor1.setSmartCurrentLimit(60);
    flywheelMotor1.burnFlash();
    flywheelMotor2.setInverted(false);
    flywheelMotor2.setSmartCurrentLimit(60);
    flywheelMotor2.burnFlash();
    flywheelMotors = new MotorControllerGroup(flywheelMotor1, flywheelMotor2);
  }
   
  // public void shootOutPole(double modifier) {
  //   flywheelMotors.set(0.7 + modifier*.3);
  // }
  
  public void shootValue(double speed) {
    flywheelMotors.set(speed);
  }

  public void shootOff() {
    flywheelMotors.set(0);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;

  private final MotorController rightMotor1 = new CANSparkMax(6, MotorType.kBrushless);
  private final MotorController rightMotor2 = new CANSparkMax(5, MotorType.kBrushless);
  private final MotorController rightMotor3 = new CANSparkMax(4, MotorType.kBrushless);
  private final MotorControllerGroup rightSideMotors = new MotorControllerGroup(rightMotor1,rightMotor2,rightMotor3);

  private final MotorController leftMotor1 = new CANSparkMax(1, MotorType.kBrushless);
  private final MotorController leftMotor2 = new CANSparkMax(2, MotorType.kBrushless);
  private final MotorController leftMotor3 = new CANSparkMax(3, MotorType.kBrushless);
  private final MotorControllerGroup leftSideMotors = new MotorControllerGroup(leftMotor1,leftMotor2,leftMotor3);


  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    rightSideMotors.setInverted(true);

    m_myRobot = new DifferentialDrive(rightSideMotors, leftSideMotors);
    m_leftStick = new Joystick(0);
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(m_leftStick.getY(), -m_leftStick.getRawAxis(5));
  }
}

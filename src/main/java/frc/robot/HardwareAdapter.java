package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import com.kauailabs.navx.frc.AHRS;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.PowerDistribution;

public interface HardwareAdapter extends Constants.ElectricalPortConstants {
    // Other CAN
    public static final PowerDistribution pdp = new PowerDistribution();

    // Drivetrain
    public final MotorController rightMotor1 = new CANSparkMax(6, MotorType.kBrushless);
    public final MotorController rightMotor2 = new CANSparkMax(5, MotorType.kBrushless);
    public final MotorController rightMotor3 = new CANSparkMax(4, MotorType.kBrushless);
    public final MotorControllerGroup rightSideMotors = new MotorControllerGroup(rightMotor1,rightMotor2,rightMotor3);

    public final MotorController leftMotor1 = new CANSparkMax(1, MotorType.kBrushless);
    public final MotorController leftMotor2 = new CANSparkMax(2, MotorType.kBrushless);
    public final MotorController leftMotor3 = new CANSparkMax(3, MotorType.kBrushless);
    public final MotorControllerGroup leftSideMotors = new MotorControllerGroup(leftMotor1,leftMotor2,leftMotor3);

    // Intake
    public static CANSparkMax intakeMotor = new CANSparkMax(8, MotorType.kBrushed);

    // Shooter
    public static final MotorController flyWheelMotor1 = new CANSparkMax(9, MotorType.kBrushless);
    public static final MotorController flyWheelMotor2 = new CANSparkMax(10, MotorType.kBrushless);
    public final MotorControllerGroup flyWheelMotors = new MotorControllerGroup(flyWheelMotor1,flyWheelMotor2);

    // Feeders
    public static final MotorController ballFeeder = new CANSparkMax(11, MotorType.kBrushless);
    public static final WPI_VictorSPX shooterFeeder = new WPI_VictorSPX(12);

    // Climber
    public static final WPI_VictorSPX climberMotor1 = new WPI_VictorSPX(13);
    public static final WPI_VictorSPX climberMotor2 = new WPI_VictorSPX(14);
    public final MotorControllerGroup climberMotors = new MotorControllerGroup(climberMotor1,climberMotor2);
    

    // Shooter Rotary Components
    public static final TalonSRX hoodMotor = new TalonSRX(15);
    public static final TalonSRX turretMotor = new TalonSRX(16);

    // Pnuematics
    public static final Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    public static final DoubleSolenoid intakeSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    public static final DoubleSolenoid climberLockSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);

    // Encoders
    public static final RelativeEncoder leftEncoder =  ((CANSparkMax) leftMotor1).getEncoder();
    public static final RelativeEncoder rightEncoder =  ((CANSparkMax) rightMotor1).getEncoder();

    // Gyro
    public static final AHRS navx = new AHRS(SPI.Port.kMXP);
    
    // Analog Inputs
    // Relays
    // Limit Switches
    // Cameras
}

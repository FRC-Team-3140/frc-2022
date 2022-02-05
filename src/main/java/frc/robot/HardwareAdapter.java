package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import com.kauailabs.navx.frc.AHRS;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.PowerDistribution;

public interface HardwareAdapter extends Constants.ElectricalPortConstants {
    // Other CAN
    public static final PowerDistribution pdp = new PowerDistribution();
    // Drivetrain
    public static final CANSparkMax leftDriveMaster = new CANSparkMax(LEFT_DRIVE_MASTER, MotorType.kBrushless);
    public static final CANSparkMax rightDriveMaster = new CANSparkMax(RIGHT_DRIVE_MASTER, MotorType.kBrushless);
    public static final CANSparkMax leftDriveSlave1 = new CANSparkMax(LEFT_DRIVE_SLAVE1, MotorType.kBrushless);
    public static final CANSparkMax rightDriveSlave1 = new CANSparkMax(RIGHT_DRIVE_SLAVE1, MotorType.kBrushless);
    public static final CANSparkMax leftDriveSlave2 = new CANSparkMax(LEFT_DRIVE_SLAVE2, MotorType.kBrushless);
    public static final CANSparkMax rightDriveSlave2 = new CANSparkMax(RIGHT_DRIVE_SLAVE2, MotorType.kBrushless);

    // Intake
    public static CANSparkMax intakeMotor = new CANSparkMax(INTAKE_MOTOR, MotorType.kBrushed);

    // Shooter
    public static final CANSparkMax flyWheelMaster = new CANSparkMax(FLYWHEEL_MASTER, MotorType.kBrushless);
    public static final CANSparkMax flyWheelSlave1 = new CANSparkMax(FLYWHEEL_SLAVE, MotorType.kBrushless);

    // Feeders
    public static final CANSparkMax ballFeeder = new CANSparkMax(BALL_FEEDER, MotorType.kBrushless);
    public static final WPI_VictorSPX shooterFeeder = new WPI_VictorSPX(SHOOTER_FEEDER);

    // Climber
    public static final WPI_VictorSPX climberMaster = new WPI_VictorSPX(CLIMBER_MASTER);
    public static final WPI_VictorSPX climberSlave = new WPI_VictorSPX(CLIMBER_SLAVE);

    // Shooter Rotary Components
    public static final TalonSRX hoodMotor = new TalonSRX(HOOD_MOTOR);
   // public static final WPI_TalonSRX turretMotor = new WPI_TalonSRX(TURRET_MOTOR);

    // Pnuematics
    public static final Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    public static final DoubleSolenoid intakeSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, INTAKE_SOLENOID_EXT,
            INTAKE_SOLENOID_RET);
    public static final DoubleSolenoid climberLockSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, CLIMBER_LOCK_SOLENOID_EXT,
            CLIMBER_LOCK_SOLENOID_RET);

    // Encoders
    public static final RelativeEncoder leftEncoder =  leftDriveMaster.getEncoder();
    public static final RelativeEncoder rightEncoder =  rightDriveMaster.getEncoder();

    // Gyro
    public static final AHRS navx = new AHRS(SPI.Port.kMXP);
    
    // Analog Inputs
    // Relays
    // Limit Switches
    // Cameras
}

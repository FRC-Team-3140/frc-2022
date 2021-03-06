package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
// import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
// import frc.robot.subsystems.Pneumatics;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public interface HardwareAdapter extends Constants.ElectricalPortConstants {
    // Other CAN
    public static final PowerDistribution pdp = new PowerDistribution();
    public static final PneumaticsControlModule pcm = new PneumaticsControlModule();

    // Drivetrain
    public final CANSparkMax rightMotor1 = new CANSparkMax(6, MotorType.kBrushless);
    public final CANSparkMax rightMotor2 = new CANSparkMax(5, MotorType.kBrushless);
    public final CANSparkMax rightMotor3 = new CANSparkMax(4, MotorType.kBrushless);
    public final MotorControllerGroup rightSideMotors = new MotorControllerGroup(rightMotor1,rightMotor2,rightMotor3);

    public final CANSparkMax leftMotor1 = new CANSparkMax(1, MotorType.kBrushless);
    public final CANSparkMax leftMotor2 = new CANSparkMax(2, MotorType.kBrushless);
    public final CANSparkMax leftMotor3 = new CANSparkMax(3, MotorType.kBrushless);
    public final MotorControllerGroup leftSideMotors = new MotorControllerGroup(leftMotor1,leftMotor2,leftMotor3);

    //Flywheel
    public final CANSparkMax flywheelMotor1 = new CANSparkMax(7, MotorType.kBrushless);
    public final CANSparkMax flywheelMotor2 = new CANSparkMax(8, MotorType.kBrushless);

    //Intake
    public final CANSparkMax intakeMotor1 = new CANSparkMax(9, MotorType.kBrushless); 
    public final CANSparkMax intakeMotor2 = new CANSparkMax(10, MotorType.kBrushless);

    //Feed
    public final VictorSPX feedMotor = new VictorSPX(12);

    //Sushi Kicker
    public final CANSparkMax sushiMotor = new CANSparkMax(11, MotorType.kBrushless);

    // Pnuematics
    public static final Compressor compressor = new Compressor(1, PneumaticsModuleType.CTREPCM);
    public static final DoubleSolenoid intakeSolenoid = new DoubleSolenoid(1,PneumaticsModuleType.CTREPCM, 3, 2);
    public static final DoubleSolenoid climberLockSolenoid = new DoubleSolenoid(1,PneumaticsModuleType.CTREPCM, 4, 5);
    public static final DoubleSolenoid climberSolenoid = new DoubleSolenoid(1,PneumaticsModuleType.CTREPCM, 6, 7);
    public static final DoubleSolenoid fingerSolenoid = new DoubleSolenoid(1, PneumaticsModuleType.CTREPCM, 0, 1);

    // Encoders
    public static final RelativeEncoder leftEncoder =  ((CANSparkMax) leftMotor1).getEncoder();
    public static final RelativeEncoder rightEncoder =  ((CANSparkMax) rightMotor1).getEncoder();

    // Gyro
    public static final AHRS navx = new AHRS(SPI.Port.kMXP);
    
    // Analog Inputs
    // Relays
    // Limit Switches
    // Cameras
    public static final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

}

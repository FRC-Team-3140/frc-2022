package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

public class Sushi extends SubsystemBase implements HardwareAdapter {
    public Sushi() {
        sushiMotor.setInverted(true);
        sushiMotor.burnFlash();
    }

    public void sushiOn() {
        sushiMotor.set(0.5);
    }

    public void sushiOff() {
        sushiMotor.set(0);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}

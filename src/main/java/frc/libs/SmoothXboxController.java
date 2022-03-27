package frc.libs;

import edu.wpi.first.wpilibj.XboxController;

public final class SmoothXboxController extends XboxController {

	public SmoothXboxController(int port) {
		super(port);
	}
	
	public double getSmoothedMainX() {
		return Math.pow(super.getRawAxis(0), 3);
	}
	
	public double getSmoothedMainY() {
		return Math.pow(super.getRawAxis(1), 3);
	}
	
	public double getSmoothedAltX() {
		return Math.pow(super.getRawAxis(4), 3);
	}
	
	public double getSmoothedAltY() {
		return Math.pow(super.getRawAxis(5), 3);
	}
	
	// private double getDeadband(double d) {
	// 	if(Math.abs(d) > DEADBAND) return d;
	// 	else return 0;
	// }
}

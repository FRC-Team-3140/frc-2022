package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.HardwareAdapter;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Timer;

public class SmoothDriveDistance extends CommandBase implements HardwareAdapter {
    // Constants
    // Update for 2022 robot (Move to constants eventually)
    private final double wheelDiamater = 6.0; // In inches
    private final double gearRatio1 = 9.0 / 62.0; // Gear Teeth / Gear Teeth
    private final double gearRatio2 = 28.0 / 28.0;
    private final double gearRatio3 = 30.0 / 36.0;

    private final double wheelCircumference = Math.PI * wheelDiamater;
    private final double inches_per_neo_revolution = wheelCircumference * gearRatio1 * gearRatio2 * gearRatio3;

    // Parameters & Local Vars
    private double dist = 0;
    private double throttle = 0; 
    private double min_throttle = 0;
    private double dist_tolerance = 2;
    private double timeout = 8;

    private Timer timer = new Timer();
    private double current_position = 0;
    
    /** Drive a distance based on encoder 
     *    @param distance The distance you want to drive in Inches. Sign does not matter.
     *    @param max_throttle The power to deliver to motors at the fastest point of the motion [0-1]. Set negative to drive in reverse.
     *    @param min_throttle The minimum power to deliver to the motors at the slowet point of the motion [0-1]. Set negative to drive in reverse.
     *    @param distance_tolerance How picky you are about being "there." By default, if you are within 2 inches you are "there." Sign does not matter.
     *    @param timeout How long in seconds the command should keep trying to drive for if the bot never makes it to the destination. Defaults to 8 seconds.
   */
    // max_throttle and min_throttle must have the same sign!!!!
    public SmoothDriveDistance(double distance, double max_throttle, double min_throttle, double distance_tolerance, double timeout) {
      // Use Math.abs liberally whenever you know you will only use positive values, helps prevent human error later
      this.dist = Math.abs(distance);
      this.throttle = max_throttle;
      this.min_throttle = min_throttle;
      this.dist_tolerance = Math.abs(distance_tolerance);
      this.timeout = Math.abs(timeout);

      addRequirements(RobotContainer.dt);
  }

  @Override
  public void initialize() {
    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);
    timer.start();
  }

  @Override
  public void execute() {
    // average of two encoder values in motor rotations
    double current_neo_rotations = (Math.abs(leftEncoder.getPosition()) + Math.abs(rightEncoder.getPosition())) / 2; 

    current_position = inches_per_neo_revolution * current_neo_rotations;

    double power = Math.max((1 - Math.abs((dist/2 - current_position) / (dist/2))) * Math.abs(throttle), Math.abs(min_throttle)) * Math.signum(throttle);
    //The above should follow a power trajectory that looks like this:
    //     ▲
    // P   │              /\
    // O   │             /  \
    // W   │            /    \
    // E   │           /      \
    // R   │          /        \
    //     │         /          \     Destination
    //     │        /            \        :
    //     │       /              \       :
    //     │      /                \      :
    //     │     /                  \     :
    //     ├────/                    ─────┐
    //     │                              │
    //     │                              │
    //     │                              │
    //     │                              │
    //     │                              │
    //     └──────────────────────────────┴─────►
    //         Distance
    RobotContainer.dt.tankDrive(power, power);
  }

  @Override
  public void end(boolean interrupted) {
      RobotContainer.dt.tankDrive(0, 0);
      timer.stop();
      timer.reset();
  }

  @Override
  public boolean isFinished() {
    return Math.abs(current_position - dist) <= dist_tolerance || timer.get() > timeout;
  }
}

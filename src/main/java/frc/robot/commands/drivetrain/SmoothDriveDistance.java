package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.HardwareAdapter;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Timer;

public class SmoothDriveDistance extends CommandBase implements HardwareAdapter, Constants.GeneralConstants.SensorConstants {
    private double throttle = 0; 
    private double dist = 0;
    private double dist_tolerance = 2;
    private double min_throttle = .2;
    private double timeout = 8;
    private double current_position=0;
    private Timer timer = new Timer();
    
    /** Drive a distance based on encoder 
     *    @param distance The distance you want to drive in Inches. Sign does not matter
     *    @param max_throttle The power to deliver to motors at the fastest point of the motion [0-1]. Set negative to drive in reverse.
     *    @param distance_tolerance How picky you are about being "there." By default, if you are within 2 inches you are "there."
     *    @param timeout How long in seconds the command should keep trying to drive for if the bot never makes it to the destination. Defaults to 8 seconds
   */
    public SmoothDriveDistance(double distance, double max_throttle, double min_throttle, double distance_tolerance, double timeout) {
      this.dist = distance;
      this.throttle = max_throttle;
      this.min_throttle = min_throttle;
      this.dist_tolerance = distance_tolerance;
      this.timeout = timeout;
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
    double current_neo_rotations = (leftEncoder.getPosition()+rightEncoder.getPosition())/2; // average of two encoder values in motor rotations
    double inches_per_neo_revolution = 3.14159*6*(9.0/62.0*28.0/28.0*30.0/36.0); // straight math from gear ratios and wheel diameters
    //Note the about two 28 tooth gears have changed as of Tallahasse and need to be changed to whatever we currently have.
    this.current_position = inches_per_neo_revolution / current_neo_rotations;

    double power = Math.max((1-Math.abs((this.dist/2 - this.current_position)/(this.dist/2)))*this.throttle, this.min_throttle);
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
    return Math.abs(this.current_position-this.dist) <= this.dist_tolerance || timer.get() > this.timeout;
  }
}

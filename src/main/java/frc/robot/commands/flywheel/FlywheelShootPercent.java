package frc.robot.commands.flywheel;
// import frc.robot.HardwareAdapter;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class FlywheelShootPercent extends CommandBase {
  public int speed = 0;
    public FlywheelShootPercent(int speed) {
    speed = this.speed;
    addRequirements(RobotContainer.fw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.fw.shootPercent(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
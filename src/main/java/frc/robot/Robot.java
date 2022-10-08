package frc.robot;
import frc.robot.HardwareAdapter;
import frc.robot.commands.flywheel.flywheelAuto;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command autoCommand;  
  private RobotContainer robotContainer;
  private AddressableLED m_led;
  // private AddressableLED f_led;
  // private AddressableLEDBuffer f_ledBuffer;
  private AddressableLEDBuffer m_ledBuffer;
  private int m_rainbowFirstPixelHue = 0;
  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
    m_led = new AddressableLED(1);
    m_ledBuffer = new AddressableLEDBuffer(22);
    m_led.setLength(m_ledBuffer.getLength());
    m_led.setData(m_ledBuffer);
    m_led.start();
    

  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();

  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    autoCommand = robotContainer.getAutonomousCommand();
    if (autoCommand != null) {
      autoCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    if (autoCommand != null) {
      autoCommand.cancel();
    }
    
  }

  @Override
  public void teleopPeriodic() {
    rainbow();
    m_led.setData(m_ledBuffer);
    SmartDashboard.putNumber("Distance", 68.5/(Math.tan((27 + NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0.00)) * Math.PI/180)) + 12);
    // red();
    
  }

  private void red() {
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
      // Sets the specified LED to the RGB values for red
      m_ledBuffer.setRGB(i, 255, 0, 0);
   }      
  }

  private void rainbow() {
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
      int hue;
      if (i<55){
        hue = (m_rainbowFirstPixelHue + (i * 180 / m_ledBuffer.getLength())) % 180; 
        m_ledBuffer.setHSV(i, hue, 255, 128);
      }
      else
      {
        hue=0;
       if ((m_rainbowFirstPixelHue%20)<10)
       {
        m_ledBuffer.setHSV(i, hue, 255, 0);
       }
        else
        {
        m_ledBuffer.setHSV(i, hue, 255, 128);
        }

      }
    }
    m_rainbowFirstPixelHue += 3;
    m_rainbowFirstPixelHue %= 180;
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}

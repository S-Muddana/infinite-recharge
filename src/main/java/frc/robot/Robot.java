/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.OI;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Wheels;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.cscore.UsbCamera;
//import edu.wpi.first.wpilibj.I2C;
//import edu.wpi.first.wpilibj.util.*;
//import com.revrobotics.ColorSensorV3;
//import com.revrobotics.ColorMatchResult;

//import java.awt.Color;

//import com.revrobotics.ColorMatch;
//import edu.wpi.cscore.CvSink;
//import edu.wpi.cscore.CvSource;
//import org.opencv.core.Mat;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	public static DriveTrain drivetrain;
	public static PowerDistributionPanel pdp;
	public static OI oi;
	public static Timer timer;
	public static Arm armturn;
	public static Wheels wheelspin;
	public static UsbCamera camera1;
	public static UsbCamera camera2;
	public static Joystick driveStick = new Joystick (0);
	public static Boolean trigger = false;
	/**
   * Change the I2C port below to match the connection of your color sensor
   */
  
	/*private final I2C.Port i2cPort = I2C.Port.kOnboard;
	private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
	private final ColorMatch m_colorMatcher = new ColorMatch();
	private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  	private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  	private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
	private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113); */
	Command autonomousCommand;
	//SendableChooser chooser;
	
	public void robotInit() {
		//Class Initializations
		drivetrain = new DriveTrain();
		pdp = new PowerDistributionPanel(20);	
		oi = new OI();
		armturn = new Arm();
		wheelspin = new Wheels();
		/** */camera1 = CameraServer.getInstance().startAutomaticCapture(0);
		/** */camera2 = CameraServer.getInstance().startAutomaticCapture(1);
		/**m_colorMatcher.addColorMatch(kBlueTarget);
		m_colorMatcher.addColorMatch(kGreenTarget);
		m_colorMatcher.addColorMatch(kRedTarget);
		m_colorMatcher.addColorMatch(kYellowTarget); */
		/** Thread t = new Thread(() -> {
    		
    		boolean allowCam1 = false;
    		
    		UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(0);
            camera1.setResolution(320, 240);
            camera1.setFPS(30);
            UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(1);
            camera2.setResolution(320, 240);
            camera2.setFPS(30);
            
            CvSink cvSink1 = CameraServer.getInstance().getVideo(camera1);
            CvSink cvSink2 = CameraServer.getInstance().getVideo(camera2);
            CvSource outputStream = CameraServer.getInstance().putVideo("Switcher", 320, 240);
            
            Mat image = new Mat();
            
            while(!Thread.interrupted()) {
            	
            	if(oi.getDriveStick().getRawButton(14)) {
            		allowCam1 = !allowCam1;
            	}
            	
                if(allowCam1){
                  cvSink2.setEnabled(false);
                  cvSink1.setEnabled(true);
                  cvSink1.grabFrame(image);
                } else{
                  cvSink1.setEnabled(false);
                  cvSink2.setEnabled(true);
                  cvSink2.grabFrame(image);     
                }
                
                outputStream.putFrame(image);
            }
            
        });
		t.start(); 
		*/
		pdp.clearStickyFaults();

		//chooser = new SendableChooser();
		//SmartDashboard.putData("Auto mode", chooser);
		}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit(){
		
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to 
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) autonomousCommand.cancel();

		Scheduler.getInstance().removeAll();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		/**
    	 * The method GetColor() returns a normalized color value from the sensor and can be
     	* useful if outputting the color to an RGB LED or similar. To
     	* read the raw color, use GetRawColor().
     	*/
		//Color detectedColor = m_colorSensor.getColor();
		/**
  	    * The sensor returns a raw IR value of the infrared light detected.
     	*/
    	//double IR = m_colorSensor.getIR();
		log();
		// operatorControl();
		Scheduler.getInstance().run();
	}
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
	}

	public void log() {
		//Prints Speed of Left Side in Dashboard (Tab: Basic)
		SmartDashboard.putString("DB/String 0", "Speed (L): " + String.format( "%.2f", (drivetrain.getLeftSpeed() * 100)) + "%");
		//Prints Speed of Right Side in Dashboard (Tab: Basic)
		SmartDashboard.putString("DB/String 5", "Speed (R): " + String.format( "%.2f", (drivetrain.getRightSpeed() * 100)) + "%");
		/**SmartDashboard.putNumber("Red", detectedColor.red);
		SmartDashboard.putNumber("Green", detectedColor.green);
		SmartDashboard.putNumber("Blue", detectedColor.blue);
		SmartDashboard.putNumber("IR", IR);
	    int proximity = m_colorSensor.getProximity();
	    SmartDashboard.putNumber("Proximity", proximity); */
		Timer.delay(0.05);
	}
}
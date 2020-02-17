/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //Controllers
  public static Joystick driveStick = new Joystick(0); //New PS4 Controller
  public static Joystick secondaryStick = new Joystick(1); //New Xbox Controller
  
  /**Driver control buttons*/
  //public static JoystickButton driveLeft = new JoystickButton(driveStick, 1); //Left Joystick on PS4 controller
  //public static JoystickButton driveRight = new JoystickButton(driveStick, 5); //Right Joystick on PS4 controller
  public static JoystickButton compressor = new JoystickButton(driveStick, 1); //Square Button on PS4 controller
  /**Secondary control buttons*/
  //public static JoystickButton arm = new JoystickButton(secondaryStick, 5); //Right Joystick on Xbox controller
  //public static JoystickButton wheels = new JoystickButton(secondaryStick, 4); //Left Joystick on Xbox controller
  public static JoystickButton hatchIntake = new JoystickButton(secondaryStick, 3); //X button on Xbox controller

	
	public OI() { 
		/**Driver Controls */
    compressor.toggleWhenPressed(new compress());	//Compresser On/Off
    /**Secondary Controls */
    hatchIntake.toggleWhenPressed(new hatchIntake()); //Extends/Retracts piston for hatch
	}

  //Additional Driver Joystick Functions
	public Joystick getDriveStick() {
		return driveStick;
  }
    //Additional Secondary Joystick Functions
  public Joystick getSecondaryStick() {
		return secondaryStick;
  }
}


  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

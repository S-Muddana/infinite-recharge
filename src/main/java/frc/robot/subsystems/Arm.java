/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {
	public SpeedController arm;

	public Arm() {
		arm = new WPI_TalonSRX(14);
	}

	public void armTurn1(Joystick secondaryStick) {
		if (secondaryStick.getRawAxis(5) > 0.1) {
			arm.set(-secondaryStick.getRawAxis(5));
		}
		else if (secondaryStick.getRawAxis(5) < -0.1) {
			arm.set(-secondaryStick.getRawAxis(5));
		}
		else {
			arm.set(0.0);
		}
	}

	public double getArmSpeed() {
		return arm.get();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new armTurn());
	}	
}

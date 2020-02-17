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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Wheels extends Subsystem {
	public SpeedController wheelSpin;

	public Wheels() {
		wheelSpin = new WPI_TalonSRX(3);
	}

	public void wheelSpin1(Joystick secondaryStick) {
		if (secondaryStick.getRawAxis(1) > 0.3) {
			wheelSpin.set(-secondaryStick.getRawAxis(1));
		}
		else if (secondaryStick.getRawAxis(1) < -0.3) {
			wheelSpin.set(-secondaryStick.getRawAxis(1));
		}
		else {
			wheelSpin.set(0.0);
		}
		SmartDashboard.putNumber("Ball Intake Wheel Speed", (-secondaryStick.getRawAxis(1)*100));
	}

	public double getWheelSpeed() {
		return wheelSpin.get();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new wheelSpin());
	}	
}
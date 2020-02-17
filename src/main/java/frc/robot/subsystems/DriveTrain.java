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

public class DriveTrain extends Subsystem {
	private SpeedController left1, left2, right1, right2;

	public DriveTrain() {
		left1 = new WPI_TalonSRX(13);					//initialize left motors on port 12
		left2 = new WPI_TalonSRX(12);
		right1 = new WPI_TalonSRX(0);
		right2 = new WPI_TalonSRX(2);
	}

	public void tankDrive(Joystick driveStick) {
		left1.set(-driveStick.getRawAxis(1));
		left2.set(-driveStick.getRawAxis(1));
		right1.set(driveStick.getRawAxis(5));
		right2.set(driveStick.getRawAxis(5));
	}

	public double getLeftSpeed() {
		return left1.get();
	}

	public double getRightSpeed() {
		return right1.get();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveJoystick());
	}	
}
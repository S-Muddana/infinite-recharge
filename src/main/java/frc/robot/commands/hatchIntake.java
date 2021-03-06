package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.command.Subsystem;


public class hatchIntake extends Command {
	
  public DoubleSolenoid piston;

  public hatchIntake() {
    piston = new DoubleSolenoid(17, 0, 1);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    piston.set(DoubleSolenoid.Value.kForward);
    SmartDashboard.putBoolean("Hatch +Piston Out", false);
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    piston.set(DoubleSolenoid.Value.kReverse);
    SmartDashboard.putBoolean("Hatch Piston Out", true);
  }
}

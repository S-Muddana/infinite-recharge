package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Compressor;;
//import edu.wpi.first.wpilibj.command.Subsystem;


public class compress extends Command {
	
  public Compressor compressor;

  public compress() {
	compressor = new Compressor(17);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
	compressor.setClosedLoopControl(true);
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
	compressor.setClosedLoopControl(false);
  }
}

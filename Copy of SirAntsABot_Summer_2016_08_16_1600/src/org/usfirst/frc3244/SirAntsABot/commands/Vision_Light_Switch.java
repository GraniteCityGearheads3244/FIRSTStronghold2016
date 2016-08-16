package org.usfirst.frc3244.SirAntsABot.commands;

import org.usfirst.frc3244.SirAntsABot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Vision_Light_Switch extends Command {
	private boolean m_Switch;
    public Vision_Light_Switch(boolean _switch) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.vision);
    	m_Switch = _switch;
    	
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.vision.my_CameraLight_Toggle(m_Switch);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

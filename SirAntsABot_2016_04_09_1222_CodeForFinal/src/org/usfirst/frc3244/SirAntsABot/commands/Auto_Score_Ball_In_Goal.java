package org.usfirst.frc3244.SirAntsABot.commands;

import org.usfirst.frc3244.SirAntsABot.Robot;
import org.usfirst.frc3244.SirAntsABot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_Score_Ball_In_Goal extends Command {

    public Auto_Score_Ball_In_Goal() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.pinBall);
    	setTimeout(1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Integer goalChoice = (Integer) Robot.goalChooser.getSelected();
    	if (goalChoice == 0 ){
    		end();
    	}else{
    		new PinBall_Cycle();
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
}

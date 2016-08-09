package org.usfirst.frc3244.SirAntsABot.commands;

import org.usfirst.frc3244.SirAntsABot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class x_SeaLeg_Left_Return_TDC extends Command {
	private double m_SeaLeg_Left_Pos;
	private double delta_To_TDC;
    public x_SeaLeg_Left_Return_TDC() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.seaLegs);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	 m_SeaLeg_Left_Pos = Robot.seaLegs.my_Get_Left_Encoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	delta_To_TDC = m_SeaLeg_Left_Pos % 360;
    	if (delta_To_TDC>180){
    		Robot.seaLegs.my_SeaLegs_Jog_Left(true, delta_To_TDC*.2);
    	}else{
    		Robot.seaLegs.my_SeaLegs_Jog_Left(false, delta_To_TDC*.2);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.seaLegs.my_SeaLeg_Left_At_TDC() || Math.abs(delta_To_TDC)>10;
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

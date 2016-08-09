package org.usfirst.frc3244.SirAntsABot.commands;

import org.usfirst.frc3244.SirAntsABot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class x_SeaLegs_Left_Return_to_TDC extends Command {

    private double currentPOS;
	private double delta_to_TDC;

	public x_SeaLegs_Left_Return_to_TDC() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.seaLegs);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currentPOS = Robot.seaLegs.my_Get_Left_Encoder();
    	delta_to_TDC = currentPOS%360;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	currentPOS = Robot.seaLegs.my_Get_Left_Encoder();
    	delta_to_TDC = currentPOS%360;
    	SmartDashboard.putNumber("x", delta_to_TDC);
    	double kp = 0.1;
    	double power = Robot.seaLegs.target(delta_to_TDC*kp, 0, -0.5, 0.5);
    	
    	if (power<0){
    		Robot.seaLegs.my_SeaLegs_Jog_Left(true,power );
    		
    	}else{
    		Robot.seaLegs.my_SeaLegs_Jog_Left(true,-power );
    		
    	}
		
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return delta_to_TDC < 5 || Robot.seaLegs.my_SeaLeg_Left_At_TDC();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.seaLegs.my_SeaLegs_Jog_Left(true,0 );
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

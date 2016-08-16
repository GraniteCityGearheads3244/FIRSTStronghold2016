package org.usfirst.frc3244.SirAntsABot.commands;

import org.usfirst.frc3244.SirAntsABot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class x_Test_Lookup extends Command {
	Drive_Spin_In_Place_Fine c;
	x_Drive_Spin_In_Place_PID spinToTarget_Command ;
    public x_Test_Lookup() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	/**
    	double cX = Robot.vision.my_Get_Xcenter();
    	double spin = Robot.vision.my_SpinToTarget_Lookup(cX);
    	System.out.println("spin = " + spin);
    	c = new Drive_Spin_In_Place_Fine(spin*-1);
    	c.start();
    	*/
    	
    	double cX = Robot.vision.my_Get_Xcenter();
    	double spin = Robot.vision.my_SpinToTarget_Lookup(cX);
    	System.out.println("spin = " + spin);
    	spinToTarget_Command = new x_Drive_Spin_In_Place_PID(spin*-1,false);
    	spinToTarget_Command.start();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//double a = Robot.vision.my_Get_Xcenter();
    	//SmartDashboard.putNumber("ANGLE_TO_TARGET",Robot.vision.my_SpinToTarget_Lookup(a));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	spinToTarget_Command.end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

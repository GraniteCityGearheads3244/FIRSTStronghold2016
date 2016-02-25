// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3244.Stronghold_Advanced.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.LinkedList;
import org.usfirst.frc3244.Stronghold_Advanced.Robot;

/**
 *
 */
public class DriveRobotSpintoGyro extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_heading;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    
    //3244 start
    private LinkedList<Double> fifo = null;
    private double averagegyro = 0;
    private boolean sample_gyro = false;
    private double spinTarget = 0;
    //3244 stop
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveRobotSpintoGyro(double heading) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_heading = heading;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	sample_gyro = false;
    	fifo = new LinkedList<Double>();
    	fifo.clear();	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double gyroAngle = Robot.driveTrain.my_getGyro();
    	
    	//Skip to bottom if First in First Out is not full
    	if(fifo.size()>9){
    		double sum = 0;
    		for(int i =0;i<fifo.size();i++){
    			sum = sum + fifo.get(i);
    		}
    		averagegyro = sum/fifo.size();
    		fifo.removeFirst();
    		
    		if(!sample_gyro){
    			spinTarget = averagegyro + m_heading;
        		sample_gyro = true;
        		SmartDashboard.putNumber("Drive spinTarget", spinTarget);
        	}
    		
    		double kpSpeed = (spinTarget - averagegyro)/spinTarget;
    		SmartDashboard.putNumber("kpSpeed", kpSpeed);
    		double rotationSpeed = 1*kpSpeed;
    		//Limit Spin to +- .5
    		if (rotationSpeed<.5)rotationSpeed=.5;
    		if (rotationSpeed>.5)rotationSpeed=.5;
    		//If 
    		if(m_heading<0){
    			rotationSpeed = -rotationSpeed;
    		}
    		SmartDashboard.putNumber("Spin To Heading rotationSpeed = ", rotationSpeed);
    		Robot.driveTrain.my_Mecanum_Drive(0, 0,rotationSpeed, gyroAngle);
    	}
    	fifo.add(new Double(gyroAngle));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return sample_gyro && averagegyro > spinTarget-10 && averagegyro < spinTarget+10;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.my_Stop_Drive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}



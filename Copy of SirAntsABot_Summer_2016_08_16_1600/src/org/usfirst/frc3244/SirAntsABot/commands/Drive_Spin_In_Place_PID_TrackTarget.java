package org.usfirst.frc3244.SirAntsABot.commands;

import org.usfirst.frc3244.SirAntsABot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drive_Spin_In_Place_PID_TrackTarget extends PIDCommand {
	double m_setpoint;
	private double scancount;
	static int Drive_Spin_In_Place_PID_count = 0;
	
    public Drive_Spin_In_Place_PID_TrackTarget() {
    	
        super("Gyro_PID_Spin_"+Drive_Spin_In_Place_PID_count,.003, 0.00005, 0.0002, 0.02); 
        //.025, 0.0002, 0.001, 0.02); //0.00002, 0.000002, 0.02);//, 0.00005, 0.0002, 0.02);
        getPIDController().setContinuous(false);
        getPIDController().setAbsoluteTolerance(.5);
        getPIDController().setOutputRange(-0.5, 0.5);
      
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.driveTrain);
		//needs Robot.vision but so do others
		//requires(Robot.vision);
        Drive_Spin_In_Place_PID_count++;
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage
    	
        return Robot.driveTrain.my_Get_Gyro();      
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	if(timeSinceInitialized() > Robot.vision.light_Settle_Time){
    		Robot.driveTrain.my_Drive_Mecanum(0,0, output, 0);
    		//System.out.println("output = "+ output);
    	}
    	else{
    		Robot.driveTrain.my_Drive_Mecanum(0,0, 0, 0);
    	}
       
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.vision.my_CameraLight_Toggle(true);
    	System.out.println("initialize() Gyro_PID_Spin_" + getPIDController().toString());
    	//getPIDController().enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double cX = Robot.vision.my_Get_Xcenter();
    	double spin = Robot.vision.my_SpinToTarget_Lookup(cX);
    	m_setpoint = Robot.driveTrain.my_Get_Gyro() + (spin*-1);
    	//getPIDController().setSetpointRelative(spin*-1);
    	getPIDController().setSetpoint(m_setpoint);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	return false;//getPIDController().onTarget();
    	/**
    	double gyro = Robot.driveTrain.my_Get_Gyro();
    	
    	if(gyro>m_setpoint-.5 && gyro< m_setpoint +.5){
    		scancount = scancount+1;
    		if(scancount>10){
    			return true;
    		}else{
    			System.out.println("Scancount = "+scancount);
    			return false;
    		}
    	}else{
    		scancount = 0;
    		return false;
    	}*/
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.vision.my_CameraLight_Toggle(false);
    	Robot.driveTrain.my_Drive_Mecanum(0,0,0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

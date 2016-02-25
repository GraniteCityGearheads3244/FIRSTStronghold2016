// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3244.SirAntsABot2.subsystems;

import org.usfirst.frc3244.SirAntsABot2.RobotMap;
import org.usfirst.frc3244.SirAntsABot2.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; 
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class NordicSpeedController extends PIDSubsystem implements SpeedController {
    
    SpeedController motor;
    Encoder encoder; 
    final double MAX_RATE = 2520;
    static int count = 0;
    int myCount;
    // Initialize your subsystem here
    public NordicSpeedController(SpeedController mot, Encoder enc, double p, double i, double d) {
        super("NordicSpeedController" + count, p, i, d, 0.0, 0.001);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("NordicSpeedController" + count, "PIDSubsystem Controller", getPIDController());
        myCount = count;
        count++;
        motor = mot;
        encoder = enc;
        	
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
        setSetpoint(0);
        enable();
    }
    
    public NordicSpeedController(SpeedController mot, Encoder enc) {
    	this(mot, enc, 2.5, 0.01, 0.0);
    }
    
    public void initDefaultCommand() {
    
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

        double retVal = encoder.getRate() / MAX_RATE;
        //if(myCount==0)
        	//System.out.println(""+myCount+" : returning pidinput "+ retVal);
        //if(myCount==0 || myCount==1) {
        	//retVal=-retVal;
        //}
        return retVal;
        
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
       // if(myCount==0)
        	//System.out.println(""+myCount+" : using pidoutput "+ output);
        motor.pidWrite(output);
    }

	@Override
	public void pidWrite(double output) {
		set(output);
		
	}

	@Override
	public double get() {
		return getSetpoint();
	}

	@Override
	public void set(double speed, byte syncGroup) {
		set(speed);
		
	}

	@Override
	public void set(double speed) {
		if(speed == 0){ 
		    getPIDController().reset(); //ensures no I build up
		}
		setSetpoint(speed);
		enable();
       // if(myCount==0)
        	//System.out.println(""+myCount+" : setting speed "+ speed);
        
        
	}
	
	public void resetPID(double pvalue, double ivalue, double dvalue, double setpoint){
		disable();
		getPIDController().setPID(pvalue, ivalue, dvalue);
		setSetpoint(setpoint);
		getPIDController().reset();
		enable();
	}

	public void updateStatus() {
		
        SmartDashboard.putNumber("Rate" + myCount, returnPIDInput());
        SmartDashboard.putNumber("Distance" + myCount, encoder.getDistance());
        SmartDashboard.putNumber("Motor" +myCount, motor.get());
        SmartDashboard.putNumber("Setpoint" +myCount, getPIDController().getSetpoint());
        SmartDashboard.putNumber("P" +myCount, getPIDController().getP());
        SmartDashboard.putNumber("I" +myCount, getPIDController().getI());
        SmartDashboard.putNumber("D" +myCount, getPIDController().getD());
        
        //System.out.println("Distance" + myCount + " " + encoder.getDistance());
	}

	public void disablePIDs() {
		getPIDController().reset();
	}

	@Override
	public void setInverted(boolean isInverted) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getInverted() {
		// TODO Auto-generated method stub
		return false;
	}
}
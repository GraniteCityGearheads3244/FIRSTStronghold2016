// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3244.CMBA;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; 
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveSystemMotorRight;
    public static SpeedController driveSystemMotorLeft;
    public static RobotDrive driveSystemRobotDrive;
    public static AnalogGyro driveSystemGyro;
    public static Encoder driveSystemMotorLeftEncoder;
    public static Encoder driveSystemMotorRightEncoder;
    public static AnalogInput driveSystemUltraSonic;
    public static SpeedController liftMotor;
    public static AnalogPotentiometer liftPot;
    public static SpeedController forksMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    //Start*****************************************//
    //			I Added BuiltInAccelerometer        //
    //**********************************************//
    
    public static BuiltInAccelerometer driveSystemaccel;

    //End*******************************************//
    //			I Added BuiltInAccelerometer        //
    //**********************************************//
    
    //Get the PDP object
    
    public static PowerDistributionPanel pdp;
    
    //Set the Motor PDM Channels
    //public static int pdp_MotorLeft_Channel = 15;
    //public static int pdp_MotorRight_Channel = 14;
    //public static int pdp_MotorLift_Channel = 13;
    public static int pdp_MotorForks_Channel = 3;
    //Set the Motor Nominal Power No Load
    //public static double pdp_MotorLeft_NomCurrent = 1;
    //public static double pdp_MotorRight_NomCurrent = 1;
    //public static double pdp_MotorLift_NomCurrent = 1;
    public static double pdp_MotorForks_NomCurrent = 10;
    public static double transmition = .75;
    
    public static void init() {
    	SmartDashboard.putNumber("Transmition", RobotMap.transmition);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveSystemMotorRight = new Talon(1);
        LiveWindow.addActuator("Drive System", "Motor Right", (Talon) driveSystemMotorRight);
        
        driveSystemMotorLeft = new Talon(0);
        LiveWindow.addActuator("Drive System", "Motor Left", (Talon) driveSystemMotorLeft);
        
        driveSystemRobotDrive = new RobotDrive(driveSystemMotorLeft, driveSystemMotorRight);
        
        driveSystemRobotDrive.setSafetyEnabled(true);
        driveSystemRobotDrive.setExpiration(0.1);
        driveSystemRobotDrive.setSensitivity(0.5);
        driveSystemRobotDrive.setMaxOutput(1.0);
        

        driveSystemGyro = new AnalogGyro(0);
        LiveWindow.addSensor("Drive System", "Gyro", driveSystemGyro);
        driveSystemGyro.setSensitivity(0.007);
        driveSystemMotorLeftEncoder = new Encoder(0, 1, true, EncodingType.k4X);
        LiveWindow.addSensor("Drive System", "Motor Left Encoder", driveSystemMotorLeftEncoder);
        driveSystemMotorLeftEncoder.setDistancePerPulse(1.0);
        driveSystemMotorLeftEncoder.setPIDSourceType(PIDSourceType.kRate);
        driveSystemMotorRightEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Drive System", "Motor Right Encoder", driveSystemMotorRightEncoder);
        driveSystemMotorRightEncoder.setDistancePerPulse(1.0);
        driveSystemMotorRightEncoder.setPIDSourceType(PIDSourceType.kRate);
        driveSystemUltraSonic = new AnalogInput(3);
        LiveWindow.addSensor("Drive System", "UltraSonic", driveSystemUltraSonic);
        
        liftMotor = new Talon(2);
        LiveWindow.addActuator("Lift", "Motor", (Talon) liftMotor);
        
        liftPot = new AnalogPotentiometer(2, 1.0, 0.0);
        LiveWindow.addSensor("Lift", "Pot", liftPot);
        
        forksMotor = new Victor(4);
        LiveWindow.addActuator("Forks", "Motor", (Victor) forksMotor);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
      //Start*****************************************//
        //			I Added BuiltInAccelerometer        //
        //**********************************************//
        
        driveSystemaccel = new BuiltInAccelerometer();
        LiveWindow.addSensor("Drive System", "accel",  driveSystemaccel);
        
        //End*******************************************//
        //			I Added BuiltInAccelerometer        //
        //**********************************************//
        
        
          //Get the PDP object
          pdp = new PowerDistributionPanel();
          LiveWindow.addSensor("Robot", "PDP", pdp);
         
    }
}
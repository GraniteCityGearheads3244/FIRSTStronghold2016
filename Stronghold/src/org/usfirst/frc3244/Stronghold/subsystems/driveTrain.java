// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3244.Stronghold.subsystems;

import org.usfirst.frc3244.Stronghold.RobotMap;
import org.usfirst.frc3244.Stronghold.commands.*;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class driveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController motor_Left_Front = RobotMap.driveTrainMotor_Left_Front;
    private final SpeedController motor_Left_Rear = RobotMap.driveTrainMotor_Left_Rear;
    private final SpeedController motor_Right_Front = RobotMap.driveTrainMotor_Right_Front;
    private final SpeedController motor_Right_Rear = RobotMap.driveTrainMotor_Right_Rear;
    private final Encoder encoder_Left_Front = RobotMap.driveTrainEncoder_Left_Front;
    private final Encoder encoder_Left_Rear = RobotMap.driveTrainEncoder_Left_Rear;
    private final Encoder encoder_Right_Front = RobotMap.driveTrainEncoder_Right_Front;
    private final Encoder encoder_Right_Rear = RobotMap.driveTrainEncoder_Right_Rear;
    private final AnalogGyro robot_Gyro = RobotMap.driveTrainRobot_Gyro;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    private final NordicSpeedController nordic_Left_Rear = RobotMap.nordic_Left_Rear;
    private final NordicSpeedController nordic_Left_Front = RobotMap.nordic_Left_Front;
    private final NordicSpeedController nordic_Right_Rear = RobotMap.nordic_Right_Rear;
    private final NordicSpeedController nordic_Right_Front = RobotMap.nordic_Right_Front;
    
    private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void My_Mecanum_Drive(double x, double y, double rotation, double gyroAngle) {
    	robotDrive.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
    }
    
}


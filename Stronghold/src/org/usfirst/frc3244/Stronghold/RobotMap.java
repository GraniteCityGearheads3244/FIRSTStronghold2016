// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3244.Stronghold;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainFront_Left;
    public static SpeedController driveTrainFront_Right;
    public static SpeedController driveTrainRear_Left;
    public static SpeedController driveTrainRear_Right;
    public static RobotDrive driveTrainRobotDrive;
    public static Encoder driveTrainFront_Left_Encoder;
    public static Encoder driveTrainFront_Right_Encoder;
    public static Encoder driveTrainRear_Left_Encoder;
    public static Encoder driveTrainRear_Right_Encoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainFront_Left = new Talon(0);
        LiveWindow.addActuator("drive Train", "Front_Left", (Talon) driveTrainFront_Left);
        
        driveTrainFront_Right = new Talon(1);
        LiveWindow.addActuator("drive Train", "Front_Right", (Talon) driveTrainFront_Right);
        
        driveTrainRear_Left = new Talon(2);
        LiveWindow.addActuator("drive Train", "Rear_Left", (Talon) driveTrainRear_Left);
        
        driveTrainRear_Right = new Talon(3);
        LiveWindow.addActuator("drive Train", "Rear_Right", (Talon) driveTrainRear_Right);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainFront_Left, driveTrainRear_Left,
              driveTrainFront_Right, driveTrainRear_Right);
        
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);

        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        driveTrainFront_Left_Encoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("drive Train", "Front_Left_Encoder", driveTrainFront_Left_Encoder);
        driveTrainFront_Left_Encoder.setDistancePerPulse(1.0);
        driveTrainFront_Left_Encoder.setPIDSourceType(PIDSourceType.kRate);
        driveTrainFront_Right_Encoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("drive Train", "Front_Right_Encoder", driveTrainFront_Right_Encoder);
        driveTrainFront_Right_Encoder.setDistancePerPulse(1.0);
        driveTrainFront_Right_Encoder.setPIDSourceType(PIDSourceType.kRate);
        driveTrainRear_Left_Encoder = new Encoder(4, 5, false, EncodingType.k4X);
        LiveWindow.addSensor("drive Train", "Rear_Left_Encoder", driveTrainRear_Left_Encoder);
        driveTrainRear_Left_Encoder.setDistancePerPulse(1.0);
        driveTrainRear_Left_Encoder.setPIDSourceType(PIDSourceType.kRate);
        driveTrainRear_Right_Encoder = new Encoder(6, 7, false, EncodingType.k4X);
        LiveWindow.addSensor("drive Train", "Rear_Right_Encoder", driveTrainRear_Right_Encoder);
        driveTrainRear_Right_Encoder.setDistancePerPulse(1.0);
        driveTrainRear_Right_Encoder.setPIDSourceType(PIDSourceType.kRate);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3244.Stronghold_Advanced;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3244.Stronghold_Advanced.commands.*;
import org.usfirst.frc3244.Stronghold_Advanced.subsystems.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick xbox_1;
    public JoystickButton button1;
    public JoystickButton button2;
    public Joystick xbox_2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        xbox_2 = new Joystick(1);
        
        button2 = new JoystickButton(xbox_2, 1);
        button2.whileHeld(new Wrist_Jog_Down());
        button1 = new JoystickButton(xbox_2, 1);
        button1.whileHeld(new Wrist_Jog_Up());
        xbox_1 = new Joystick(0);
        


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Claw_Open: Open", new Claw_Open(22));
        SmartDashboard.putData("Claw_Close: Close", new Claw_Close(9.75));
        SmartDashboard.putData("Claw_Jog_Open", new Claw_Jog_Open());
        SmartDashboard.putData("Claw_Jog_Close", new Claw_Jog_Close());
        SmartDashboard.putData("Drive Robot Field Oriented Mecanum", new DriveRobotFieldOrientedMecanum());
        SmartDashboard.putData("Drive Robot Spin to Gyro: zero", new DriveRobotSpintoGyro(0));
        SmartDashboard.putData("Drive Robot Oriented Mecanum", new DriveRobotOrientedMecanum());
        SmartDashboard.putData("Pinball_Reset", new Pinball_Reset());
        SmartDashboard.putData("Pinball_Shoot", new Pinball_Shoot());
        SmartDashboard.putData("Scissor_Jog_up", new Scissor_Jog_up());
        SmartDashboard.putData("Scissor_Jog_Down", new Scissor_Jog_Down());
        SmartDashboard.putData("Wrist_to_Stow_Angle", new Wrist_to_Stow_Angle());
        SmartDashboard.putData("Wrist_to_Angle: Stow", new Wrist_to_Angle(90));
        SmartDashboard.putData("Wrist_to_Angle: Pick", new Wrist_to_Angle(0));
        SmartDashboard.putData("Wrist_Jog_Up", new Wrist_Jog_Up());
        SmartDashboard.putData("Wrist_Jog_Down", new Wrist_Jog_Down());
        SmartDashboard.putData("SeaLegs_Jog_Forward", new SeaLegs_Jog_Forward());
        SmartDashboard.putData("SeaLegs_Jog_Reverse", new SeaLegs_Jog_Reverse());
        SmartDashboard.putData("SeaLegs_To_Top", new SeaLegs_To_Top());
        SmartDashboard.putData("Pinball_Controled_Release", new Pinball_Controled_Release());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        SmartDashboard.putData("Wrist_to_Pick_Angle", new Wrist_to_Pick_Angle(45));
        SmartDashboard.putData("Scissor Reach To Capture", new ScissorReachToCapture(Robot.scissorPID.Reach_Above));
        SmartDashboard.putData("SeaLeg_Left_Drive", new SeaLeg_Left_Drive(true));
        SmartDashboard.putData("SeaLeg_Right_Drive", new SeaLeg_Right_Drive(true));
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getXbox_1() {
        return xbox_1;
    }

    public Joystick getXbox_2() {
        return xbox_2;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

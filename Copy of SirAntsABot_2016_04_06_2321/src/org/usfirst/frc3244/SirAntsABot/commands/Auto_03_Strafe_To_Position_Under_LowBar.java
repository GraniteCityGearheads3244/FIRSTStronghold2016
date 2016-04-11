package org.usfirst.frc3244.SirAntsABot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_03_Strafe_To_Position_Under_LowBar extends CommandGroup {
    
    public  Auto_03_Strafe_To_Position_Under_LowBar() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new Auto_Cycle_Secure_Ball());
    	addParallel(new Wrist_To_Setpoint(5));
    	addSequential(new Drive_Robot_Orianted_Distance_Strafe(-20));
    	addSequential(new Auto_Drive_UnderLowBar());
        
        
    }
}

package org.usfirst.frc3244.SirAntsABot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_SpinFromLowBarForShotReady extends CommandGroup {
    
    public  Auto_SpinFromLowBarForShotReady() {
    	
    	//to protect arm do this last//addParallel(new Auto_SetWrist_to_GoalChooser());
    	addSequential(new Drive_Spin_In_Place(-75));
    	addSequential(new Drive_Robot_Orianted_Distance_Strafe(145));
    	addSequential(new Auto_SetWrist_to_GoalChooser());
    	
    }
}

package org.usfirst.frc3244.SirAntsABot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_02_Straight_Under_LowBar extends CommandGroup {
    
    public  Auto_02_Straight_Under_LowBar() {
        
    	 addSequential(new Auto_Cycle_Secure_Ball());
    	 addSequential(new Auto_Drive_UnderLowBar());
    }
}

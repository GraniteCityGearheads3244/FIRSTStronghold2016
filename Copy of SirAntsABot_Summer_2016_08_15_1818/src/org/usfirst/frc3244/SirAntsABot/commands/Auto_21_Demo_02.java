package org.usfirst.frc3244.SirAntsABot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_21_Demo_02 extends CommandGroup {
    
    public  Auto_21_Demo_02() {
    	addSequential(new Auto_SetWrist_to_GoalChooser());
    	addSequential(new Auto_Score_Ball_In_Goal());
    }
}

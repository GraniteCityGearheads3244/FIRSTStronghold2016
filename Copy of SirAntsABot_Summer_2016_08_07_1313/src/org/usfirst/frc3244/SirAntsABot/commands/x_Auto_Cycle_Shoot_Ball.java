package org.usfirst.frc3244.SirAntsABot.commands;

import org.usfirst.frc3244.SirAntsABot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class x_Auto_Cycle_Shoot_Ball extends CommandGroup {
    
    public  x_Auto_Cycle_Shoot_Ball() {
    	Integer goalChoice = (Integer) Robot.goalChooser.getSelected();
    	System.out.println("goalChoice = " + goalChoice);
    	if (goalChoice>0){
       	 	addSequential(new PinBall_Cycle());
            addSequential(new PinBall_Reset());
       }
    }
}

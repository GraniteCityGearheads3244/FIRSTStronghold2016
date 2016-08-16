package org.usfirst.frc3244.SirAntsABot.commands;

import org.usfirst.frc3244.SirAntsABot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_Ready_Climb extends CommandGroup {
    
    public  Auto_Ready_Climb() {
       
    	addParallel(new Wrist_To_Setpoint(24),2);
    	//addSequential(new Wrist_To_Setpoint(24),2);
    	addSequential(new Scissor_To_Position(RobotMap.SCISSOR_CLIMB_REACH_BAR));
    	
    	
    }
}

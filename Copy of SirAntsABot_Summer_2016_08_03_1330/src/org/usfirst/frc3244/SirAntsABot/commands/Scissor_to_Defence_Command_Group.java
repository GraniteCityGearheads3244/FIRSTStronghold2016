package org.usfirst.frc3244.SirAntsABot.commands;

import org.usfirst.frc3244.SirAntsABot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Scissor_to_Defence_Command_Group extends CommandGroup {
    
    public  Scissor_to_Defence_Command_Group() {
       addParallel(new Wrist_To_Setpoint(24),2);
       addSequential(new Scissor_To_Position(RobotMap.SCISSOR_DEFENCE_POS));
    }
}

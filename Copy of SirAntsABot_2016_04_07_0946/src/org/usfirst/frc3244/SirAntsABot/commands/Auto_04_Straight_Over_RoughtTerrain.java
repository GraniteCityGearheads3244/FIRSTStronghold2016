package org.usfirst.frc3244.SirAntsABot.commands;

import org.usfirst.frc3244.SirAntsABot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_04_Straight_Over_RoughtTerrain extends CommandGroup {
    
    public  Auto_04_Straight_Over_RoughtTerrain() {
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
        addSequential(new Drive_Robot_Orianted_Distance(RobotMap.AUTO_DISTANCE_TO_OBSTICAL + 0.0)); //Up Ramp too
        addSequential(new Auto_Drive_OverObstical(20,.85));
        
    }
}

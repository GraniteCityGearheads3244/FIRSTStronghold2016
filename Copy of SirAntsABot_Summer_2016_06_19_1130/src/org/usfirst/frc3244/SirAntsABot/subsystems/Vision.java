package org.usfirst.frc3244.SirAntsABot.subsystems;

import org.usfirst.frc3244.SirAntsABot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
    
	 private final Relay camera_Light = RobotMap.cameraLight;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void my_CameraLight_Toggle(){
    	if (camera_Light.get()==Value.kOff){
    		camera_Light.set(Value.kForward);
    	}else{
    		camera_Light.set(Value.kOff);
    	}
    }
    
    /**
     * Control the Light On or off
     * @param Boolean true to turn light on, false to turn it off
     */
    public void my_CameraLight_Toggle(boolean on){
    	if(on){
    		camera_Light.set(Value.kForward);
    	}else{
    		camera_Light.set(Value.kOff);
    	}
    	
    }
    
}


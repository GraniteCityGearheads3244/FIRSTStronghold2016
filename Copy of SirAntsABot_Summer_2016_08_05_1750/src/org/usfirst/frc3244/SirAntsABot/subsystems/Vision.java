package org.usfirst.frc3244.SirAntsABot.subsystems;

import org.usfirst.frc3244.SirAntsABot.Robot;
import org.usfirst.frc3244.SirAntsABot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
    private int image_Width = RobotMap.CAMERA_IMAGE_WIDTH;
    private int image_Height = RobotMap.CAMERA_IMAGE_HEIGHT;
    public final double light_Settle_Time = 1;
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

    
    public double my_Get_Xcenter_PID(){
    	double[] x = Robot.grip.getNumberArray("myContoursReport/centerX", new double[0]);
    	//double[] y = Robot.grip.getNumberArray("myContoursReport/centerY", new double[0]);
    	//double[] area = Robot.grip.getNumberArray("myContoursReport/area", new double[0]);
    	double errorX;
    	//double errorY;
    	if(x.length>0){
    		//System.out.println("Yes");
    		double centerX = x[0];
    		//double centerY = y[0];
    		//double areaTarget = area[0];
    		errorX = (centerX-(image_Width/2));
    		//errorY = (centerY-(image_Height/2));
    		//errorTarget = areaTarget-image_targetArea;
    	}else{
    		//System.out.println("No");
    		double centerX = image_Width/2;
    		//double centerY = image_Width/2;
    		
    		errorX = (centerX-(image_Width/2));
    		//errorY = (centerY-(image_Height/2));
    	}
        return errorX;
    }
    
    public double my_Get_Ycenter_PID(){
    	//double[] x = Robot.grip.getNumberArray("myContoursReport/centerX", new double[0]);
    	double[] y = Robot.grip.getNumberArray("myContoursReport/centerY", new double[0]);
    	//double[] area = Robot.grip.getNumberArray("myContoursReport/area", new double[0]);
    	//double errorX;
    	double errorY;
    	if(y.length>0){
    		//System.out.println("Yes");
    		//double centerX = x[0];
    		double centerY = y[0];
    		//double areaTarget = area[0];
    		//errorX = (centerX-(image_Width/2));
    		errorY = (centerY-(image_Height/2));
    		//errorTarget = areaTarget-image_targetArea;
    	}else{
    		//System.out.println("No");
    		//double centerX = image_Width/2;
    		double centerY = image_Width/2;
    		
    		//errorX = (centerX-(image_Width/2));
    		errorY = (centerY-(image_Height/2));
    	}
    	
        return errorY;
    }
    
	public boolean my_Target_Found() {
		double[] y = Robot.grip.getNumberArray("myContoursReport/centerY", new double[0]);
    	if(y.length>0){
    		return true;
    	}else{
		return false;
    	}
	}

	public double my_GetFinalWristAngle(double w_setpoint) {
		double[] width = Robot.grip.getNumberArray("myContoursReport/width", new double[0]);
		if(width.length>0){
			if(width[0]>120){
				System.out.println("width >120");
				return 70;
			}else if (width[0]>100) {
				System.out.println("width >100");
				return 70;	
			}else if (width[0]>85) {
				System.out.println("width >85");
				return 70;
			}else{
				System.out.println("width >xxx Get Closer");
				return 0;	
			}
		}
		return 0;
	}
    
	
	public double my_Get_Xcenter_REAL_PID(){
    	double[] x = Robot.grip.getNumberArray("myContoursReport/centerX", new double[0]);
    	double errorX;
    	int i =0;
    	//double errorY;
    	if(x.length>0){
    		double[] y = Robot.grip.getNumberArray("myContoursReport/centerY", new double[0]);
    		//System.out.println(y.length);
    		if(y.length>0){//Find Target
    			
    			i = my_Find_Target(y);
    			System.out.println("i="+i);
    		}
    		//System.out.println("Yes");
    		double centerX = x[i];
    		errorX = ((image_Width/2)-centerX);
    	}else{
    		//System.out.println("No");
    		//double centerX = image_Width/2;
    		errorX = 0;//(centerX-(image_Width/2));
    	}
    	//Trap negative error
    	if(errorX<50){
    		errorX=errorX;
    	}
    	if(errorX>50){
    		errorX=errorX;
    	}
    	if(errorX<10&&errorX>-10){
    		errorX=0;
    	}
    	//System.out.println("errorX= "+errorX);
       
        return errorX;
    }
    
	 public double my_Get_Ycenter_REAL_PID(){
		 int i =0;
	    	double[] y = Robot.grip.getNumberArray("myContoursReport/centerY", new double[0]);
	    	
	    	double errorY;
	    	if(y.length>0){
	    		i = my_Find_Target(y);
	    		System.out.println("i="+i);
	   
	    		//System.out.println("Yes");
	    		double centerY = y[i];
	    		errorY = ((image_Height/2)-centerY);
	    	}else{
	    		//System.out.println("No");
	    		//double centerY = image_Width/2;
	    		errorY = 0;//(centerY-(image_Height/2));
	    	}
	    	//Trap negative error
	    	if(errorY<-20){
	    		errorY=-20;
	    	}
	    	if(errorY>15){
	    		errorY=15;
	    	}
	    	//System.out.println("errorY= "+errorY);
	        return errorY;
	    }
	 private int my_Find_Target(double[] t){
		 for (int counter = 0; counter < t.length; counter++) {
				if (t[counter]<150) {
					
					return counter;
				}
			}
		return 0;
	 }
}


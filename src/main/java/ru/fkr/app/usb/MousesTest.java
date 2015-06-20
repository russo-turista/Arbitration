package ru.fkr.app.usb;


import java.util.ArrayList;

import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;



public class MousesTest {
	private ArrayList<Controller> foundControllers = new ArrayList<>();
    

    public MousesTest() {
    	System.out.println("MousesTest load");
        searchForControllers();
        if(!foundControllers.isEmpty()){
        	int i = 0;
        	for (Controller currentCtr : foundControllers){
	        		MouseDevice mouseDevice = new MouseDevice();
	        		mouseDevice.setIdDevice(i++);
	        		mouseDevice.setController(currentCtr);
        	}
        }
    else {
    		System.out.println("Mouse device not found");
    	}
    }
        
    
    /**
     * Search (and save) for controllers of type Controller.Type.MOUSE.
     */
    private void searchForControllers() {
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        for(int i = 0; i < controllers.length; i++){
            Controller controller = controllers[i];
            
            if (controller.getType() == Controller.Type.MOUSE )
            {
                // Add new controller to the list of all controllers.
                foundControllers.add(controller);
                System.out.println("controller name " + controller.toString());
                System.out.println("controller PortNumber " + controller.getPortNumber());
                System.out.println("controller PortType " + controller.getPortType());
                System.out.println("controller EventQueue " + controller.getEventQueue().toString());
            }
        }
    }
   
}

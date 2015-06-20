package ru.fkr.app.usb;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.fkr.app.MainApp;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.Component.Identifier;
public class MouseDevice {
	private Controller controller;
	private int idDevice;
	private Thread deviceLoad;
	 private static final Logger log = LoggerFactory.getLogger(MouseDevice.class);
	public MouseDevice(){
		deviceLoad = new Thread(new DeviceRun());
		System.out.println("Thread number device " + deviceLoad.getId() + " load");
		log.debug("Thread number device " + deviceLoad.getId() + " load");
		deviceLoad.start();
	}
	private class DeviceRun implements Runnable{

		@Override
		public void run() {
			System.out.println("Thread device number " + deviceLoad.getId() + " run");
			log.debug("Thread device number " + deviceLoad.getId() + " run");
			Controller controller = getController();
			System.out.println("controller number: " + controller.getName() + " " + controller.hashCode());
			log.debug("controller number: " + controller.getName() + " " + controller.hashCode());
			if (controller !=null){
				 while(true)
			        {
					 if( !controller.poll() ){
			               System.out.println("Connetct is ded");
			                break;
			            }
					  Component[] components = controller.getComponents();
					  for(int i=0; i < components.length; i++)
			            {
			                Component component = components[i];
			                Identifier componentIdentifier = component.getIdentifier();
			                if(componentIdentifier.getName() == "Left" || componentIdentifier.getName() == "Right" ){
			                	boolean isItPressed = true;
			                    if(component.getPollData() == 0.0f){
			                        isItPressed = false;
			                    }
			                    String buttonIndex;
			                    buttonIndex = component.getIdentifier().toString();
			                    if (isItPressed == true){
				                    System.out.println("(Device number: " + getIdDevice() + ") ");
				                    System.out.println(buttonIndex);
				                    System.out.println("is Pressed: " + isItPressed);
				                    log.debug("(Device number: " + getIdDevice() + ") ");
				                    log.debug(buttonIndex);
				                    log.debug("is Pressed: " + isItPressed);
			                    }
			                }
			            } 
						  try {
								Thread.sleep(25);
					        } catch (InterruptedException ex) {
					            //Logger.getLogger(MouseDevice.class.getName()).log(Level.SEVERE, null, ex);
					            log.error("Tread is broken" + ex);
					        }
			        }
			}
		}
		
	}
	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	public int getIdDevice() {
		return idDevice;
	}
	public void setIdDevice(int idDevice) {
		this.idDevice = idDevice;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((controller == null) ? 0 : controller.hashCode());
		result = prime * result + idDevice;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MouseDevice other = (MouseDevice) obj;
		if (controller == null) {
			if (other.controller != null)
				return false;
		} else if (!controller.equals(other.controller))
			return false;
		if (idDevice != other.idDevice)
			return false;
		return true;
	}
	
}

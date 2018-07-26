package toy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Toy {
	// Define the logger object for this class
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	protected ToyFsm fsm = new ToyFsm("Toy FSM", this);

	public void trU2R() {
		log.info("Doing something upon transision from Unregistered to Registered");
	}
	public void trR2U() {
		log.info("Doing something upon transision from Registered to Unregistered");
	}
	
	public void trU2U() {
		log.info("Doing something upon transision from Unregistered to Unregistered");
		
	}
	public void trR2R() {
		log.info("Doing something upon transision from Registered to Registered");
		
	}

	public void register(boolean forcedSuccess) {
		// do register
		
		if (forcedSuccess) {
			fsm.process(ToyFsm.evRegSuccess);
		} else {
			fsm.process(ToyFsm.evRegFailure);
		}
		
	}
	
	public void deregister() {
		fsm.process(ToyFsm.evDereg);
		// do dregister
	}

}

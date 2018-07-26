package toy;

import fsm.Fsm;
import fsm.FsmEvent;

public class ToyFsm extends Fsm {

	//private toyData _toy;
	// the id must be unique
	// keep them contiguously starting from 0 would save a little
	// more importantly, help your thoughts organized
	public static FsmEvent evRegSuccess = new FsmEvent(0, "RegSuccess");
	public static FsmEvent evRegFailure = new FsmEvent(1, "RegFailure");
	public static FsmEvent evDereg      = new FsmEvent(2, "Dereg");
	
	public static String strUnregistered = "Unregistered";
	public static String strRegistered = "Registered";
	
	public ToyFsm(String name, Toy toy) {
		super(name);
		//_toy = toy;
		
		super.addTransition(strUnregistered, evRegSuccess, toy::trU2R, strRegistered);
		super.addTransition(strUnregistered, evRegFailure, toy::trU2U, strUnregistered);
		super.addTransition(strRegistered, evDereg, toy::trR2U, strUnregistered);
		
		init();		
	}
	
	public void init() {
		super.init(strUnregistered);
	}
	
	public boolean isRegistered() {
		return _cur.isNamed(strRegistered);
	}
}

package fsm;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LiangZhao
 *
 */
public class Fsm extends Object{
	String _name;
	protected FsmState _cur = null;
	private ArrayList<FsmState> _states = new ArrayList<FsmState>();

	// Define the logger object for this class
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public Fsm(String name) {
		_name = name;
	}
	
	public String process(FsmEvent ev) {
		FsmState next = _cur.process(ev);
		if (next != null) {
			// peg counters
			if (_cur.equals(next)) {
				_cur.incCntReenter();
				log.info(_cur.getName() + "->" + _cur.getName());
			} else {
				_cur.incCntExit();
				next.incCntEnter();
				//log.trace(_cur.getName() + "->" + next.getName());
				log.debug(_cur.getName() + "->" + next.getName());
			    _cur = next;
			}
		}
		return _cur.getName();
	}

	private FsmState addState(String name) {
		FsmState state = findState(name);
		if (null == state) {
			state = new FsmState(name);
			if (null != state) {
				_states.add(state);
			}
		}
		return state;
	}

	public FsmRet addTransition(String from, FsmEvent event, FsmAction action, String to) {
		FsmState stFrom = addState(from);
		FsmState stTo = addState(to);
		
		stFrom.addTransition(event, action, stTo);
		return FsmRet.OK;
	}

	private FsmRet init(FsmState state) {
		if (_cur != null) {
			return FsmRet.ATTEMPT_TO_REINIT;
		}
		if (!_states.contains(state)) {
			return FsmRet.UNKNOWN_STATE;
		}
		_cur = state;
		return FsmRet.OK;
	}
	
	public FsmState findState(String stateName) {
		for (FsmState state : _states) {
			if (state.isNamed(stateName)) {
				return state;
			}
		}
		return null;
	}
	
	// for external use
	public FsmRet init(String stateName) {
		FsmState state = findState(stateName);
		if (null != state) {
			return init(state);
		}
		return FsmRet.UNKNOWN_STATE;
	}
	
    public String getCurrentState() {
    	return _cur.getName();
    }
    
    @Override
	public String toString() {
		String ret = _name +"\n";
		for (FsmState state: _states) {
			ret += state.toString();
		}
		ret += " Current state: ["+ _cur.getName() +"]\n";
		return ret;
	}
	public void printBrief() {
		System.out.print(_name);
		System.out.printf(" Current state: [%s]\n", _cur.getName());
	}
}

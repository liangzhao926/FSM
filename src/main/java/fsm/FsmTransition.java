package fsm;
/**
 * 
 */

/**
 * @author LiangZhao
 *
 */
public class FsmTransition {
	private FsmEvent _event;
	private FsmAction _action;
	private FsmState _to;
	
	public FsmTransition(FsmEvent event, FsmAction action, FsmState to) {
		_event = event;
		_action = action;
		_to = to;
	}
	
	public FsmState process(FsmEvent ev) {
		if (ev.equals(_event)) {
			_action.act();
			return _to;
		}
		return null;
	}

	@Override
	public String toString() {
		return "  Upon event <"+_event.getName() +">"
				+" do " + _action.getClass().getName() 
				+ " -> [" + _to.getName() +"]\n";
	}
}

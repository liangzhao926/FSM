package fsm;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author LiangZhao
 *
 */
public class FsmState extends Object{
	private String _name;
	private ArrayList<FsmTransition> _transitions = new ArrayList<FsmTransition>();
	
	private int cntEnter;
	private int cntReenter;
	private int cntExit;

	public FsmState(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
	
	public boolean isNamed(String name) {
		return name.equals(this._name);
	}
	
	public FsmState process(FsmEvent ev) {
		for (FsmTransition tr : _transitions) {
			FsmState next = tr.process(ev);
			if (null != next) {
				return next;
			}
		}
		return null;
	}
	
	public FsmRet addTransition(FsmEvent event, FsmAction action, FsmState to) {
		_transitions.add(new FsmTransition(event, action, to));
		return FsmRet.OK;
	}
	
	public int getCntEnter() {
		return cntEnter;
	}
	public void setCntEnter(int cntEnter) {
		this.cntEnter = cntEnter;
	}
	public void incCntEnter() {
		this.cntEnter++;
	}

	public int getCntReenter() {
		return cntReenter;
	}
	public void setCntReenter(int cntReenter) {
		this.cntReenter = cntReenter;
	}
	public void incCntReenter() {
		this.cntReenter++;
	}

	public int getCntExit() {
		return cntExit;
	}
	public void setCntExit(int cntExit) {
		this.cntExit = cntExit;
	}
	public void incCntExit() {
		this.cntExit++;
	}

	@Override
	public String toString() {
		String ret = "State ["+ _name + "]\n";
		for (FsmTransition tr : _transitions) {
			ret += tr.toString();
		}
		return ret;
	}
}

package fsm;
/**
 * 
 */

/**
 * @author LiangZhao
 *
 */
public class FsmEvent {
	protected int    _id;
	protected String _name;
	
	public FsmEvent(int id, String name) {
		_id = id;
		_name = name;
	}
	
	public int getId() {
		return _id; 
	}
	public String getName() {
		return _name;
	}
	
	public boolean equals(FsmEvent ev) {
		return _name.equals(ev.getName());
	}
}

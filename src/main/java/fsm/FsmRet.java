package fsm;
/**
 * 
 */

/**
 * @author LiangZhao
 *
 */
public enum FsmRet {
	OK,
	FROM_STATE_INVALID,
	TO_STATE_INVALID,
	DUP_EVENT_IN_STATE,
	ATTEMPT_TO_REINIT,
	UNKNOWN_STATE,
	MALLOC_FAIL,
	
}

package fsm;
/**
 * @author LiangZhao
 *
 */
/**
 * Represents a function that accepts no argument and produces no result.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #act(Object)}.
 *
 *
 */
@FunctionalInterface
public interface FsmAction {
    /**
     * Applies this function to no argument.
     *
     * @return void
     */
	 void act( );
	
}

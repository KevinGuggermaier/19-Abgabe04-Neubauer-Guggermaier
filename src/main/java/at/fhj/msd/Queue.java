package at.fhj.msd;

import java.util.NoSuchElementException;

/**
 * <h1>Interface: Queue</h1>
 * <p>
 *  To implement the data structure queue. All necessary methods are implemented to work with this queue.
 * </p>
 *
 * @author Kevin Guggermaier
 * @author Dominik Neubauer
 * @version 1.0
 */

public interface Queue {

    /**
     *  Adds the element obj to the queue.
     *  If the addition is successful, the method returns true else false.
     * @param obj <br>Type:String <br> Value which is added to the queue
     * @return true or false
     */
    public abstract boolean offer(Object obj);

    /**
     *  Returns the head (first) element and also deletes it. That is, we cannot get it again.
     *  If no element exists (when queue is empty), the method returns null.
     * @param <T> Placeholder for return value, to use Interface for more then one data types (Integer, String)
     * @return <ul><li>first element when Queue is not empty</li><li>null when Queue is empty</li></ul>
     */
    public abstract <T> T poll();

    /**
     * It also returns and deletes the head element like poll(), but with a small difference.
     * This method throws NoSuchElementException if the queue is empty.
     * @param <T> Placeholder for return value, to use Interface for more then one data types (Integer, String)
     * @return first element from the Queue
     */
    public abstract <T> T remove() throws NoSuchElementException;

    /**
     * Returns the head element but it does not delete it. That is, we can get it again.
     * Returns null when the queue is empty.
     * @param <T> Placeholder for return value, to use Interface for more then one data types (Integer, String)
     * @return <ul><li>first element when Queue is not empty</li><li>null when Queue is empty</li></ul>
     */
    public abstract <T> T peek();

    /**
     *  It works similar to peek() but with a small difference (returns but does not delete the element).
     *  It throws NoSuchElementException when the queue is empty.
     * @param <T> Placeholder for return value, to use Interface for more then one data types (Integer, String)
     * @return first element from the Queue
     */
    public abstract <T> T element() throws NoSuchElementException;

    /**
     * To get the maximum size of the queue
     * @return the maximum size of the queue
     */
    public abstract int size();

    /**
     * To check the amount of elements which are already inserted in the queue
     * @return the amount of elements which are already inserted in the queue
     */
    public abstract int filling();
}

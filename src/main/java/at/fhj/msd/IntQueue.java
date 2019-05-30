package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * <h1>Class: IntQueue</h1>
 * <p>
 *  To implement the data structure queue. You can only insert data from
 *  data type Integer. All necessary methods are implemented to work with this queue.
 *  <br>Class IntQueue implements interface Queue.
 * </p>
 *
 * <h2>Class variables</h2>
 * <ul>
 *     <li><h3>element</h3>
 *      <ul>
 *          <li>Datatyp: List Integer</li>
 *          <li>Info: includes all the data from the queue</li>
 *      </ul>
 *     </li>
 *     <li><h3>maxSize</h3>
 *         <ul>
 *             <li>Datatyp: Integer</li>
 *             <li>Info: to set the size of the queue</li>
 *         </ul>
 *     </li>
 * </ul>
 * @author Kevin Guggermaier
 * @author Dominik Neubauer
 * @version 1.0
 */
public class IntQueue implements Queue {

    private List<Integer> elements = new ArrayList<Integer>();
    private int maxSize;

    public IntQueue(int maxSize){
        this.maxSize = maxSize;
    }

    @Override
    public boolean offer(Object obj) {
        if(elements.size()!= maxSize)
            elements.add(Integer.class.cast(obj));
        else
            return false;

        return true;
    }

    @Override
    public Integer poll() {
        Integer element = peek();

        if(elements.size() != 0){
            elements.remove(0);
        }
        return element;
    }

    @Override
    public Integer remove() {
        Integer element = poll();

        if(element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

    @Override
    public Integer peek() {
        Integer element;
        if(elements.size() > 0)
            element = elements.get(0);
        else
            element = null;

        return element;
    }

    @Override
    public Integer element() {
        Integer element = peek();
        if(element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

    @Override
    public int size() {
        return maxSize;
    }

    @Override
    public int filling() {
        return elements.size();
    }
}

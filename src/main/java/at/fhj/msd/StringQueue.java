package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * <h1>Class: StringQueue</h1>
 * <p>
 *  To implement the data structure queue. You can only insert data from
 *  data type String. All necessary methods are implemented to work with this queue.
 *  <br>Class StringQueue implements interface Queue.
 * </p>
 *
 * <h2>Class variables</h2>
 * <ul>
 *     <li><h3>element</h3>
 *      <ul>
 *          <li>Datatyp: List String</li>
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
public class StringQueue implements Queue{

    private List<String> elements = new ArrayList<String>();
    private int maxSize;

    /**
     * Constructor from class StringQueue with one transfer parameter
     * @param   maxSize to set the size from the queue
     */
    public StringQueue(int maxSize){
        this.maxSize = maxSize;
    }

    @Override
    public boolean offer(Object obj) {
        if(elements.size()!= maxSize)
            elements.add(String.class.cast(obj));
        else
            return false;

        return true;
    }

    @Override
    public String poll() {
        String element = peek();

        if(elements.size() != 0){
            elements.remove(0);
        }
        return element;
    }

    @Override
    public String remove() {
        String element = poll();

        if(element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

    @Override
    public String peek() {
        String element;
        if(elements.size() > 0)
            element = elements.get(0);
        else
            element = null;

        return element;
    }

    @Override
    public String element() {
        String element = peek();
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
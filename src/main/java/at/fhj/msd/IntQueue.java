package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * <h1>Class: IntQueue</h1>
 * <p>
 *  To implement the data structure queue. You can only insert data from
 *  data type Integer. All necessary methods are implemented to work with this queue.
 *  <br>Class IntQueue implements interface Queue.
 * </p>
 *
 * @author Kevin Guggermaier
 * @author Dominik Neubauer
 * @version 1.0
 * @see at.fhj.msd.Queue
 */
public class IntQueue implements Queue {

    private static final Logger logger = LogManager.getLogger(IntQueue.class);
    /**
     * Stores the Integer values of this queue
     */
    private List<Integer> elements = new ArrayList<Integer>();
    /**
     * Maximum size of the queue
     */
    private int maxSize;

    /**
     * Constructor from class IntQueue with one transfer parameter
     * @param   maxSize to set the size from the queue
     */
    public IntQueue(int maxSize){
        logger.info("[IntQueue] constructor with maxSize = " + maxSize);
        this.maxSize = maxSize;
    }

    @Override
    public boolean offer(Object obj) {
        logger.info("[offer] add new element to queue");
        if(elements.size()!= maxSize) {
            logger.info("new element has benn successfully added to the queue");
            elements.add(Integer.class.cast(obj));
        }
        else {
            logger.info("element has not been added to the queue");
            return false;
        }
        return true;
    }

    @Override
    public Integer poll() {
        logger.info("[poll] remove element head");
        Integer element = peek();
        logger.info("[poll]");
        if(elements.size() != 0){
            logger.info("element successful removed");
            elements.remove(0);
        }
        else
            logger.info("no such element in the queue");
        return element;
    }

    @Override
    public Integer remove() {
        logger.info("[remove] delete element head");
        Integer element = poll();
        logger.info("[remove]");
        if(element == null) {
            logger.error("throw NoSuchElementException");
            throw new NoSuchElementException("there's no element any more");
        }
        logger.info("element successful removed");
        return element;
    }

    @Override
    public Integer peek() {
        logger.info("[peek] return value from element head");
        Integer element;
        if(elements.size() > 0) {
            logger.info("element available");
            element = elements.get(0);
        }
        else {
            logger.info("queue is empty");
            element = null;
        }
        return element;
    }

    @Override
    public Integer element() {
        logger.info("[element] return value from element head");
        Integer element = peek();
        logger.info("[element]");
        if(element == null) {
            logger.error("throw NoSuchElementException");
            throw new NoSuchElementException("there's no element any more");
        }
        return element;
    }

    @Override
    public int size() {
        logger.info("[size] return the size from queue");
        return maxSize;
    }

    @Override
    public int filling() {
        logger.info("[filling] return the amount of elements in the queue");
        return elements.size();
    }
}

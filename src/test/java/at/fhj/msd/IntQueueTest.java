package at.fhj.msd;

import org.junit.*;

import java.util.NoSuchElementException;

/**
 * <h1>Class: IntQueueTest</h1>
 * <p>
 *  Includes test methods to test the methods from class IntQueue in different variants
 * </p>
 * <h2>Class variables</h2>
 *  <ul>
 *      <li><h3>intQueue</h3>
 *       <ul>
 *           <li>Datatyp: Queue</li>
 *           <li>Info: object from class Queue</li>
 *       </ul>
 *      </li>
 * </ul>
 * @author Kevin Guggermaier
 * @author Dominik Neubauer
 * @version 1.0
 */
public class IntQueueTest {

    private Queue intQueue;

    /**
     * Creates an object from class IntQueue to prepare the test
     */
    @Before
    public void setup() {
        intQueue = new IntQueue(7);
    }

    /**
     * To check if the queue have the same size like given in the constructor.
     */
    @Test
    public void sizeTest() {
        Assert.assertEquals(7,intQueue.size(),0.00001);
    }

    /**
     * Insert 5 elements into the Queue and check if there are 5 elements in it.
     */
    @Test
    public void fillingTest() {
        for(int i = 0; i < 5; i++) {
            intQueue.offer(15);
        }
        Assert.assertEquals(5,intQueue.filling(),0.00001);
    }

    /**
     * Insert one element to the empty queue
     */
    @Test
    public void offerTest1() {
        Assert.assertTrue(intQueue.offer(14));
    }

    /**
     * Insert 7 elements to the queue and then add one more element to the queue to check
     * if the method offer returns False
     */
    @Test
    public void offerTest2() {
        for(int i = 0; i < 7; i++) {
            intQueue.offer(13);
        }
        Assert.assertFalse(intQueue.offer(42));
    }

    /**
     * First insert 6 elements to the queue and then add one more element to the queue to check
     * if the method offer returns True
     */
    @Test
    public void offerTest3() {
        for(int i = 0; i < 6; i++) {
            intQueue.offer(7);
        }
        Assert.assertTrue(intQueue.offer(6));
    }

    /**
     * Add five elements to the queue and then check if all elements have been inserted in the right way
     */
    @Test
    public void pollTest1() {
        for(int i = 0; i < 5; i++) {
            if(i == 0)
                intQueue.offer(1);
            else
                intQueue.offer(100);
        }
        Assert.assertTrue(intQueue.poll().equals(1));
    }

    /**
     * Remove an element from an empty queue
     */
    @Test
    public void pollTest2() {
        Assert.assertTrue(intQueue.poll() == null);
    }

    /**
     * Add five elements to the queue, remove two elements and the check if there is the right amount of
     * elements in the queue
     */
    @Test
    public void fillingTest3() {
        for(int i = 0; i < 5; i++) {
                intQueue.offer(3);
        }
        intQueue.poll();
        intQueue.poll();
        Assert.assertEquals(3,intQueue.filling(),0.000001);
    }

    /**
     * Remove an element from an empty queue
     */
    @Test(expected = NoSuchElementException.class)
    public void removeTest1() {
        intQueue.remove();
    }

    /**
     * Add two elements to the queue and then remove one element
     */
    @Test
    public void removeTest2() {
        intQueue.offer(1);
        intQueue.offer(2);
        intQueue.remove();
        Assert.assertTrue(intQueue.remove().equals(2));
    }

    /**
     * Add three element to the queue and check if the first element is the same like the first which has been inserted
     * first
     */
    @Test
    public void peekTest1() {
        intQueue.offer(1);
        intQueue.offer(3);
        intQueue.offer(4);
        Assert.assertTrue(intQueue.peek().equals(1));
    }

    /**
     * Add three elements to the queue and then remove three elements from the queue
     */
    @Test
    public void peekTest2() {
        intQueue.offer(1);
        intQueue.offer(2);
        intQueue.offer(3);
        intQueue.remove();
        intQueue.remove();
        intQueue.remove();
        Assert.assertTrue(intQueue.peek() == null);
    }

    /**
     * Add three elements to the queue and then check if there are three elements in it
     */
    @Test
    public void peekTest3() {
        intQueue.offer(1);
        intQueue.offer(3);
        intQueue.offer(4);
        Assert.assertEquals(3,intQueue.filling(),0.00001);
    }

    /**
     * Add three elements to the queue and then check if the first element have the same value like the element
     * which have been inserted first
     */
    @Test
    public void elementTest1() {
        intQueue.offer(1);
        intQueue.offer(2);
        intQueue.offer(10);
        Assert.assertTrue(intQueue.element().equals(1));
    }

    /**
     * Add three elements to the queue then remove three elements.
     * After that get the head element
     */
    @Test(expected = NoSuchElementException.class)
    public void elementTest2() {
        intQueue.offer(1);
        intQueue.offer(2);
        intQueue.offer(3);
        intQueue.remove();
        intQueue.remove();
        intQueue.remove();
        intQueue.element();
    }
}
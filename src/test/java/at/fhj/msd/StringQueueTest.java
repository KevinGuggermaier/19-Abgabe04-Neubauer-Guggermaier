package at.fhj.msd;

import org.junit.*;

import java.util.NoSuchElementException;

public class StringQueueTest {

    private Queue stringQueue;

    @Before
    public void setup() {
        stringQueue = new StringQueue(10);
    }

    /**
     * To check if the queue have the same size like given in the constructor.
     */
    @Test
    public void sizeTest() {
        Assert.assertEquals(10,stringQueue.size(),0.00001);
    }

    /**
     * Insert 10 elements into the Queue and check if there are 10 elements in it.
     */
    @Test
    public void fillingTest1() {
        for(int i = 0; i < 10; i++) {
            stringQueue.offer("placeholder");
        }
        Assert.assertEquals(10,stringQueue.filling(),0.000001);
    }

    /**
     * Insert 7 elements into the Queue and check if there are 7 elements in it.
     */
    @Test
    public void fillingTest2() {
        for(int i = 0; i < 7; i++) {
            stringQueue.offer("placeholder");
        }
        Assert.assertEquals(7,stringQueue.filling(),0.000001);
    }

    /**
     * Insert one element to the empty queue
     */
    @Test
    public void offerTest1() {
        Assert.assertTrue(stringQueue.offer("offerTest1"));
    }

    /**
     * Insert 10 elements to the queue and then add one more element to the queue to check
     * if the method offer returns False
     */
    @Test
    public void offerTest2() {
        for(int i = 0; i < 10; i++) {
            stringQueue.offer("placeholder");
        }
        Assert.assertFalse(stringQueue.offer("offerTest2"));
    }

    /**
     * First insert 9 elements to the queue and then add one more element to the queue to check
     * if the method offer returns True
     */
    @Test
    public void offerTest3() {
        for(int i = 0; i < 9; i++) {
            stringQueue.offer("placeholder");
        }
        Assert.assertTrue(stringQueue.offer("offerTest1"));
    }

    /**
     * Add seven elements to the queue and then check if all elements have been inserted in the right way
     */
    @Test
    public void pollTest1() {
        for(int i = 0; i < 7; i++) {
            if(i == 0)
                stringQueue.offer("I'm the head");
            else
                stringQueue.offer("placeholder");
        }
        Assert.assertTrue(stringQueue.poll().equals("I'm the head"));
    }

    /**
     * Add seven elements to the queue, remove two elements and the check if there is the right amount of
     * elements in the queue
     */
    @Test
    public void fillingTest3() {
        for(int i = 0; i < 7; i++) {
            if(i == 0)
                stringQueue.offer("I'm the head");
            else
                stringQueue.offer("placeholder");
        }
        stringQueue.poll();
        stringQueue.poll();
        Assert.assertEquals(5,stringQueue.filling(),0.000001);

    }

    /**
     * Remove an element from an empty queue
     */
    @Test(expected = NoSuchElementException.class)
    public void removeTest1() {
        stringQueue.remove();
    }

    /**
     * Add two elements to the queue and then remove one element
     */
    @Test
    public void removeTest2() {
        stringQueue.offer("head");
        stringQueue.offer("placeholder");
        stringQueue.remove();
        Assert.assertTrue(stringQueue.remove().equals("placeholder"));
    }

    /**
     * Add three element to the queue and check if the first element is the same like the first which has been inserted
     * first
     */
    @Test
    public void peekTest1() {
        stringQueue.offer("head");
        stringQueue.offer("placeholder");
        stringQueue.offer("placeholder");
        Assert.assertTrue(stringQueue.peek().equals("head"));
    }

    /**
     * Add three elements to the queue and then remove three elements from the queue
     */
    @Test
    public void peekTest2() {
        stringQueue.offer("head");
        stringQueue.offer("placeholder");
        stringQueue.offer("placeholder");
        stringQueue.remove();
        stringQueue.remove();
        stringQueue.remove();
        Assert.assertTrue(stringQueue.peek() == null);
    }

    /**
     * Add three elements to the queue and then check if the first element have the same value like the element
     * which have been inserted first
     */
    @Test
    public void elementTest1() {
        stringQueue.offer("head");
        stringQueue.offer("placeholder");
        stringQueue.offer("placeholder");
        Assert.assertTrue(stringQueue.element().equals("head"));
    }

    /**
     * Add three elements to the queue then remove three elements.
     * After that get the head element
     */
    @Test(expected = NoSuchElementException.class)
    public void elementTest2() {
        stringQueue.offer("head");
        stringQueue.offer("placeholder");
        stringQueue.offer("placeholder");
        stringQueue.remove();
        stringQueue.remove();
        stringQueue.remove();
        stringQueue.element();
    }
}

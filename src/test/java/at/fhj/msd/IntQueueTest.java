package at.fhj.msd;

import org.junit.*;

import java.util.NoSuchElementException;

public class IntQueueTest {

    private Queue intQueue;

    @Before
    public void setup() {
        intQueue = new IntQueue(7);
    }

    @Test
    public void sizeTest() {
        Assert.assertEquals(7,intQueue.size(),0.00001);
    }

    @Test
    public void fillingTest() {
        for(int i = 0; i < 5; i++) {
            intQueue.offer(15);
        }
        Assert.assertEquals(5,intQueue.filling(),0.00001);
    }
    @Test
    public void offerTest1() {
        Assert.assertTrue(intQueue.offer(14));
    }

    @Test
    public void offerTest2() {
        //! adds ten placeholders to the string queue in order to fill it full
        for(int i = 0; i < 7; i++) {
            intQueue.offer(13);
        }
        Assert.assertFalse(intQueue.offer(42));
    }

    @Test
    public void offerTest3() {
        //! adds nine placeholders to the string queue
        for(int i = 0; i < 6; i++) {
            intQueue.offer(7);
        }
        Assert.assertTrue(intQueue.offer(6));
    }

    @Test
    public void pollTest1() {
        //! adds seven placeholders to the string queue
        for(int i = 0; i < 5; i++) {
            if(i == 0)
                intQueue.offer(1);
            else
                intQueue.offer(100);
        }
        Assert.assertTrue(intQueue.poll().equals(1));
    }

    @Test
    public void pollTest2() {
        //! adds seven placeholders to the string queue
        Assert.assertTrue(intQueue.poll() == null);
    }

    @Test
    public void fillingTest3() {
        //! adds seven placeholders to the string queue
        for(int i = 0; i < 5; i++) {
                intQueue.offer(3);
        }
        intQueue.poll();
        intQueue.poll();
        Assert.assertEquals(3,intQueue.filling(),0.000001);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeTest1() {
        intQueue.remove();
    }

    @Test
    public void removeTest2() {
        intQueue.offer(1);
        intQueue.offer(2);
        intQueue.remove();
        Assert.assertTrue(intQueue.remove().equals(2));
    }

    @Test
    public void peekTest1() {
        intQueue.offer(1);
        intQueue.offer(3);
        intQueue.offer(4);
        Assert.assertTrue(intQueue.peek().equals(1));
    }

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

    @Test
    public void peekTest3() {
        intQueue.offer(1);
        intQueue.offer(3);
        intQueue.offer(4);
        Assert.assertEquals(3,intQueue.filling(),0.00001);
    }

    @Test
    public void elementTest1() {
        intQueue.offer(1);
        intQueue.offer(2);
        intQueue.offer(10);
        Assert.assertTrue(intQueue.element().equals(1));
    }

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
package at.fhj.msd;

import org.junit.*;

import java.util.NoSuchElementException;

public class StringQueueTest {

    private Queue stringQueue;

    @Before
    public void setup() {
        stringQueue = new StringQueue(10);
    }

    @Test
    public void sizeTest() {
        Assert.assertEquals(10,stringQueue.size(),0.00001);
    }

    @Test
    public void fillingTest1() {
        //! adds ten placeholders to the string queue
        for(int i = 0; i < 10; i++) {
            stringQueue.offer("placeholder");
        }
        Assert.assertEquals(10,stringQueue.filling(),0.000001);
    }

    @Test
    public void fillingTest2() {
        //! adds seven placeholders to the string queue
        for(int i = 0; i < 7; i++) {
            stringQueue.offer("placeholder");
        }
        Assert.assertEquals(7,stringQueue.filling(),0.000001);
    }

    @Test
    public void offerTest1() {
        Assert.assertTrue(stringQueue.offer("offerTest1"));
    }

    @Test
    public void offerTest2() {
        //! adds ten placeholders to the string queue in order to fill it full
        for(int i = 0; i < 10; i++) {
            stringQueue.offer("placeholder");
        }
        Assert.assertFalse(stringQueue.offer("offerTest2"));
    }

    @Test
    public void offerTest3() {
        //! adds nine placeholders to the string queue
        for(int i = 0; i < 9; i++) {
            stringQueue.offer("placeholder");
        }
        Assert.assertTrue(stringQueue.offer("offerTest1"));
    }

    @Test
    public void pollTest1() {
        //! adds seven placeholders to the string queue
        for(int i = 0; i < 7; i++) {
            if(i == 0)
                stringQueue.offer("I'm the head");
            else
                stringQueue.offer("placeholder");
        }
        Assert.assertTrue(stringQueue.poll().equals("I'm the head"));
    }


    @Test
    public void fillingTest3() {
        //! adds seven placeholders to the string queue
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

    @Test(expected = NoSuchElementException.class)
    public void removeTest1() {
        stringQueue.remove();
    }

    @Test
    public void removeTest2() {
        stringQueue.offer("head");
        stringQueue.offer("placeholder");
        stringQueue.remove();
        Assert.assertTrue(stringQueue.remove().equals("placeholder"));
    }

    @Test
    public void peekTest1() {
        stringQueue.offer("head");
        stringQueue.offer("placeholder");
        stringQueue.offer("placeholder");
        Assert.assertTrue(stringQueue.peek().equals("head"));
    }

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

    @Test
    public void elementTest1() {
        stringQueue.offer("head");
        stringQueue.offer("placeholder");
        stringQueue.offer("placeholder");
        Assert.assertTrue(stringQueue.element().equals("head"));
    }

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

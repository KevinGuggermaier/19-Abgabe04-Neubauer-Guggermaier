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
<<<<<<< HEAD
=======
    }

    @Test(expected = NoSuchElementException.class)
    public static void xyz() {
>>>>>>> 1308107edc0aa11a11358d4ddbb60c26170935f8

    }
}

package at.fhj.msd;

import org.junit.*;

public class StringQueueTest {

    private Queue stringQueue;

    @Before
    public void setup() throws Exception {
        stringQueue = new StringQueue(10);
    }

    @Test
    public void sizeTest() throws Exception {
        Assert.assertEquals(10,stringQueue.size(),0.00001);
    }

    @Test
    public void fillingTest1() throws Exception {
        //! adds ten placeholders to the string queue
        for(int i = 0; i < 10; i++) {
            stringQueue.offer("placeholder");
        }
        Assert.assertEquals(10,stringQueue.filling(),0.000001);
    }

    @Test
    public void fillingTest2() throws Exception {
        //! adds seven placeholders to the string queue
        for(int i = 0; i < 7; i++) {
            stringQueue.offer("placeholder");
        }
        Assert.assertEquals(7,stringQueue.filling(),0.000001);
    }

    @Test
    public void offerTest1() throws Exception {
        Assert.assertTrue(stringQueue.offer("offerTest1"));
    }

    @Test
    public void offerTest2() throws Exception {
        //! adds ten placeholders to the string queue in order to fill it full
        for(int i = 0; i < 10; i++) {
            stringQueue.offer("placeholder");
        }
        Assert.assertFalse(stringQueue.offer("offerTest2"));
    }

    @Test
    public void offerTest3() throws Exception {
        //! adds nine placeholders to the string queue
        for(int i = 0; i < 9; i++) {
            stringQueue.offer("placeholder");
        }
        Assert.assertTrue(stringQueue.offer("offerTest1"));
    }

    @Test
    public void pollTest1() throws Exception {
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
    public void fillingTest3() throws Exception {
        //! adds seven placeholders to the string queue
        for(int i = 0; i < 7; i++) {
            if(i == 0)
                stringQueue.offer("I'm the head");
            else
                stringQueue.offer("placeholder");
        }
        stringQueue.poll();
        stringQueue.poll();
        Assert.assertEquals(5,stringQueue.size(),0.000001);

    }
}

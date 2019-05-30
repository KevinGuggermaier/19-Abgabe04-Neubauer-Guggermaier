package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

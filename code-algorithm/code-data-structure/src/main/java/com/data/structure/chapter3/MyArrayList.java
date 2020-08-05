package com.data.structure.chapter3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * 表的数组实现
 * @author：jinsheng
 * @date：2020/03/19 23:00
 */
public class MyArrayList<T> implements Iterable<T>{

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private T[] theItems;

    public MyArrayList(){
        clear();
    }

    public void clear(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpaty(){
        return size() == 0;
    }

    public void trimTosize(){
        ensureCapacity(size());
    }

    public T get(int idx){
        if(idx < 0 || idx >= size()){
            throw  new ArrayIndexOutOfBoundsException();
        }
        return  theItems[idx];
    }

    public T set(int idx,T newVal){
        if(idx <0 || idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }

        T oldVal = theItems[idx];
        theItems[idx] = newVal;
        return oldVal;
    }

    public boolean add(T val){
        add(size(), val);
        return true;
    }

    public void add(int idx, T val){
        if(theItems.length == size()){
            ensureCapacity(size() * 2 + 1);
        }
        for(int i = theSize; i > idx; i--){
            theItems[i] = theItems[i-1];
        }

        theItems[idx] = val;
        theSize ++;
    }

    public T remove(int idx){
        T removeItem = theItems[idx];
        for(int i = idx; i < size() - 1; i++){
            theItems[i] = theItems[i + 1];
        }

        theSize--;
        return removeItem;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    public void ensureCapacity(int newCapacity){
        if(newCapacity < theSize)
            return;

        T[] old = theItems;
        theItems = (T[])new Object[newCapacity];
        for(int i = 0 ; i < size(); i++){
            theItems[i] = old[i];
        }
    }

    private class  MyArrayListIterator implements Iterator<T>{
        private int current = 0;

        public boolean hasNext(){
            return  current < size();
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }

    }
}

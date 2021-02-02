package com.learning.androidlearning.movemarker.javalearning;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public class GenericClass<E> extends AbstractList<E>
     implements List<E>, RandomAccess, Cloneable, Serializable

    {
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    transient Object[] data;
    int DEFAULT_CAPACITY = 10;
    int size;

    public GenericClass(int capacity)
    {
        if (capacity < 0)
            throw new IllegalArgumentException();
             data = (E[]) new Object[capacity];
    }

    @Override
    public E get(int index)
      {
      return (E) data[index];
      }

        @Override
        public Object set(int index, Object element) {
            return null;
        }

        @Override
        public int size() {
        return 0;
    }

        @Override
        public boolean add(Object o) {
            return false;
        }

        public void add(int index, Object e)
        {
        if(size==data.length)
        {
            ensureCapacity(size + 1);
        }
        if(index!=size)
        {
            System.arraycopy(data, index, data, index + 1,
                    size - index);
        }
        data[index] = e;
        size++;

    }
    private void ensureCapacity(int minCapacity)
    {
        int current = data.length;
            if (minCapacity > current)
              {
            E[] newData = (E[]) new Object[Math.max(current * 2, minCapacity)];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
           }

    }


}

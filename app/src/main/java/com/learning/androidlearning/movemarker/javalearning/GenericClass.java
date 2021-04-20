package com.learning.androidlearning.movemarker.javalearning;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public class GenericClass<E> extends AbstractList<E>
     implements List<E>, RandomAccess, Cloneable, Serializable

    {
    private transient E[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private String TAG=GenericClass.class.getSimpleName();

    public GenericClass(int capacity)
    {
        data = (E[]) new Object[capacity];
    }
    public GenericClass()
    {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public E get(int index)
      {
      return data[index];
      }
      @Override
      public int size() {
        return size;
    }

        @Override
        public boolean add(Object o) {
            return false;
        }

        public void add(int index, E e)
        {
            Log.d(TAG, "size: "+size);
            Log.d(TAG, "data.length: "+data.length);
            Log.d(TAG, "add:--- ");
            Log.d(TAG, "add:------ ");

            ensureCapacity(size + 1);

            Log.d(TAG, "data: "+data);
            Log.d(TAG, "index: "+index);

            System.arraycopy(data, index, data, index + 1,
                    size - index);

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

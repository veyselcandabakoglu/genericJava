package src;

import java.util.Arrays;

public class MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public MyList() {
        this(DEFAULT_CAPACITY);
    }

    public MyList(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public int getCapacity() {
        return this.array.length;
    }

    public void add(T data) {
        ensureCapacity();
        array[size++] = data;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if(index < 0 || index >= this.size) {
            return null;
        }
        return (T) array[index];
    }

    public T remove(int index) {
        if(index < 0 || index >= this.size) {
            return null;
        }

        @SuppressWarnings("unchecked")
        T removedItem = (T) array[index];

        for(int i = index ; i < size - 1 ; i++) {
            array[i] = array[i+1];
            System.out.println("burada");
        }

        array[--size] = null;

        return removedItem;
    }

    public T set(int index , T data) {
        if(index < 0 || index >= 0) {
            return null;
        }

        @SuppressWarnings("unchecked")
        T previousData = (T) array[index];
        array[index] = data;

        return previousData;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) java.util.Arrays.copyOf(array, size, array.getClass());
    }

    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || finish >= size || start > finish) {
            return null;
        }
        MyList<T> subList = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            subList.add(get(i));
        }
        return subList;
    }
    
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }
}

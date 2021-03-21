package datastructures.list;

import java.util.Arrays;

public class KListTest<E> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public KListTest() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    public void remove(int index) {
        rangeCheck(index);

        int numMoved = size - index - 1;

        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);

            elements[--size] = null;
        }
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        rangeCheck(index);

        return (E) elements[index];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void ensureCapacity() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }

}

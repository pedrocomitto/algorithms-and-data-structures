package datastructures.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private int size = 0;
    private Object[] elements;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        Object result = elements[--size];

        elements[size] = null;

        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}

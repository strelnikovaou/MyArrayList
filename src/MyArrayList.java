import java.util.AbstractList;
import java.util.List;

/**
 * Resizable-array implementation of the List interface.
 * Permits all elements, including null. This class provides methods
 * to manipulate the size of the array that is used internally to store the list.
 * Note that this implementation is not synchronized.
 *
 * @param <E> – the type of elements in this list
 */
public class MyArrayList<E> extends AbstractList<E> implements List<E> {
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * The array into which the elements of the MyArrayList are stored.
     * The capacity of the MyArrayList is the length of this array.
     * When empty MyArrayList is initialized, this array is assigned
     * a capacity = DEFAULT_CAPACITY.
     */
    private E[] array;
    /**
     * The size of the MyArrayList (the number of elements it contains).
     */
    private int size = 0;
    /**
     * Actual array capacity, same as a call array.length
     */
    private int capacity = 0;

    /**
     * Class constructor specifying number of objects to create
     *
     * @param capacity – the initial capacity of the list
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(final int capacity) {
        this.capacity = capacity;
        array = (E[]) new Object[capacity];
    }

    /**
     * Class constructor
     */
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Shows the number of elements in the list.
     *
     * @return the number of elements in the list.
     */
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void growCapacity() {
        if (capacity == size) {
            final int s = size;
            capacity = s + (s >> 1);
            E[] newArray = (E[]) new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, s);
            array = newArray;
        }
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return true
     */
    @Override
    public boolean add(E element) {
        growCapacity();
        array[size++] = element;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this
     * list.
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public void add(int index, E element) {
        indexCheck(index);
        growCapacity();

        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index – index of the element to replace element – element to be stored at the specified position
     * @return element value
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public E set(int index, E element) {
        indexCheck(index);
        array[index] = element;
        return element;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public E get(int index) {
        indexCheck(index);
        return (E) array[index];
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     */
    @Override
    public E remove(int index) {
        indexCheck(index);
        final int nextIndex = index + 1;
        final int rightLength = size - index;
        E value = (E) array[index];
        if (rightLength > 0) {
            System.arraycopy(array, nextIndex, array, index, rightLength);
        }
        array[--size] = null;

        return value;
    }

    /**
     * Removes all elements from this list.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * This method checks that the index is in the range 0 < index < array size
     *
     * @param index - the index of the element
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    private void indexCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Array size: " + this.size);
        }
    }

}

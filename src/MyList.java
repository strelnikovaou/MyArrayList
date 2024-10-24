/**
 * The MyList interface provides methods for positional (indexed) access to list elements,
 * updating list elements, adding elements, removing elements and clearing this list.
 *
 * @param <E> – the type of elements in this list
 */
public interface MyList<E> {
    int size();

    boolean add(E e);

    void add(int index, E element);

    E set(int index, E element);

    E get(int index);

    E remove(int index);

    void clear();
}

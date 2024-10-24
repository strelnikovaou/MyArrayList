import java.util.*;

/**
 * Quicksort implementation that takes n*log(n) time on average.
 * This sort is stable and runs O(n*n) times in the worst case.
 * This implementation also supports null values and handles them correctly.
 *
 * @param <E> – the type of elements in this list
 */

public class QuickSort<E extends Comparable<? super E>> {

    /**
     * Sorts the specified range (from startIndex to endIndex) of the specified list
     * of objects by the natural methods compareTo.
     * All elements in the range must be mutually comparable
     * by the specified comparator (that is, c.compare(e1, e2) must not throw a ClassCastException
     * for any elements e1 and e2 in the range
     *
     * @param array      - sorted list
     * @param startIndex - start index of sorted list
     * @param endIndex   - end index of sorted list
     */
    void quickSort(List<E> array, int startIndex, int endIndex) {
        this.quickSort(array, startIndex, endIndex, new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return o1.compareTo(o2);
            }
        });

    }

    /**
     * Sorts the specified range (from startIndex to endIndex) of the specified list of
     * objects by the method implemented in the parameter comparator
     *
     * @param array      - sorted list
     * @param startIndex - start index of sorted list
     * @param endIndex   - end index of sorted list
     * @param comparator
     */
    public void quickSort(List<E> array, int startIndex, int endIndex, Comparator<? super E> comparator) {
        if (startIndex < endIndex) {
            int pivotIndex = partition(array, startIndex, endIndex, comparator);
            quickSort(array, startIndex, pivotIndex);
            quickSort(array, pivotIndex + 1, endIndex);

        }
    }

    private int partition(List<E> array, int startIndex, int endIndex, Comparator<? super E> comparator) {
        int pivotIndex = (startIndex + endIndex) / 2;
        E pivotValue = array.get(pivotIndex);

        startIndex--;
        endIndex++;

        while (true) {

            do startIndex++;
            while (comparator.compare(array.get(startIndex), pivotValue) < 0);

            do endIndex--;
            while (comparator.compare(array.get(endIndex), pivotValue) > 0);

            if (startIndex >= endIndex)

                return endIndex;

            E temp = array.get(startIndex);
            array.set(startIndex, array.get(endIndex));
            array.set(endIndex, temp);
        }
    }


}

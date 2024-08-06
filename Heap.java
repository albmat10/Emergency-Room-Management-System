import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T> {
    private final ArrayList<T> items;
    private final Comparator<T> comparator;

    public Heap(Comparator<T> comparator) {
        this.items = new ArrayList<>();
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void insert(T item) {
        items.add(item);
        int currentIndex = items.size() - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (comparator.compare(items.get(currentIndex), items.get(parentIndex)) < 0) {
                swap(items, currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    public T remove() {
        if (items.isEmpty()) {
            return null;
        }
        T removedItem = items.get(0);
        items.set(0, items.get(items.size() - 1));
        items.remove(items.size() - 1);
        heapifyDown();
        return removedItem;
    }

    private void swap(ArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && comparator.compare(getRightChild(index), getLeftChild(index)) < 0) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (comparator.compare(items.get(index), items.get(smallerChildIndex)) < 0) {
                break;
            } else {
                swap(items, index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < items.size();
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < items.size();
    }

    private T getLeftChild(int index) {
        return items.get(getLeftChildIndex(index));
    }

    private T getRightChild(int index) {
        return items.get(getRightChildIndex(index));
    }
}
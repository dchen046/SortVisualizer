package algorithms;

import ui.ArrayPanel;

/**
 * Class for quick sort
 */
public class QuickSort extends Thread{
    private final ArrayPanel ap;
    private final int delay;

    public QuickSort(ArrayPanel ap) {
        this(ap,50);
    }

    public QuickSort(ArrayPanel ap, int delay) {
        this.ap = ap;
        this.delay = delay;
    }

    /**
     * runs quicksort
     */
    public void run() {
        ap.enableButtons(false);
        int[] array = ap.getArray();
        quicksort(array, 0, array.length - 1);
        ap.enableButtons(true);
    }

    /**
     * quicksort
     * @param array integer array
     * @param start left
     * @param end right
     */
    private void quicksort(int[] array, int start, int end) {
        if (start >= end)
            return;
        int pivot = partition(array, start, end);
        quicksort(array, start, pivot - 1);
        quicksort(array, pivot + 1, end);
    }

    /**
     * Uses the last index as the pivot for quick sort
     * @param array integer array
     * @param start start of array
     * @param end end of array
     * @return returns the new pivot
     */
    public int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
                try {
                    ap.repaint();
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        i++;
        swap(array, i, end);
        ap.repaint();
        return i;
    }

    /**
     * swap value of index a with b
     * @param values integer array
     * @param a first index
     * @param b second index
     */
    private void swap(int[] values, int a, int b) {
        int temp = values[a];
        values[a] = values[b];
        values[b] = temp;
    }
}

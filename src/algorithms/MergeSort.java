package algorithms;

import ui.ArrayPanel;

/**
 * Class for Merge sort
 */
public class MergeSort extends Thread {
    private final ArrayPanel ap;
    private final int delay;

    public MergeSort(ArrayPanel ap) {
        this(ap,50);
    }

    public MergeSort(ArrayPanel ap, int delay) {
        this.ap = ap;
        this.delay = delay;
    }

    /**
     * runs mergesort
     */
    public void run() {
        ap.enableButtons(false);
        int[] array = ap.getArray();
        mergeSort(array,0,array.length - 1);
        ap.enableButtons(true);
    }

    /**
     * sorts an array using mergesort in place
     * @param array integer array
     * @param start start of array
     * @param end end of array
     */
    private void mergeSort(int[] array, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        // sort halves
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        // merge them back in order
        merge(array, start, end);
    }

    /**
     * Merges two sorted halfs of an array
     * @param array integer array
     * @param start start of array
     * @param end end of array
     */
    public void merge(int[] array, int start, int end) {
        int mid = (start + end) / 2;
        int start2 = mid + 1;

        // array is already sorted
        if (array[mid] <= array[start2]) {
            return;
        }
        // pointer for each half
        while (start <= mid && start2 <= end) {
            if (array[start] > array[start2]) {
                int value = array[start2];
                // shift elements
                for (int i = start2; i != start; i--) {
                    array[i] = array[i - 1];
                }
                array[start] = value;
                mid++;
                start2++;
                try {
                    ap.repaint();
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            start++;
        }
    }
}

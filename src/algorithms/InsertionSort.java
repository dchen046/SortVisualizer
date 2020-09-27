package algorithms;

import ui.ArrayPanel;

/**
 * Class for insertion sort
 */
public class InsertionSort extends Thread {
    private final ArrayPanel ap;
    private final int delay;

    public InsertionSort(ArrayPanel ap) {
        this(ap,5);
    }

    public InsertionSort(ArrayPanel ap, int delay) {
        this.ap = ap;
        this.delay = delay;
    }

    /**
     * runs insertion sort
     */
    public void run() {
        ap.enableButtons(false);
        int[] array = ap.getArray();
        insertionSort(array);
        ap.enableButtons(true);
    }

    /**
     * sorts an array using insertion sort
     * @param array integer array
     */
    private void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] < array[j])
                    break;
                swap(array,j,j-1);
                try {
                    ap.repaint();
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
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

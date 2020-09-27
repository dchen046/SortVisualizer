package algorithms;

import ui.ArrayPanel;

/**
 * Class for bubble sort
 */
public class BubbleSort extends Thread {
    private final ArrayPanel ap;
    private final int delay;

    public BubbleSort(ArrayPanel ap) {
        this(ap,5);
    }

    public BubbleSort(ArrayPanel ap, int delay) {
        this.ap = ap;
        this.delay = delay;
    }

    /**
     * runs bubblesort
     */
    public void run() {
        ap.enableButtons(false);
        int[] array = ap.getArray();
        bubbleSort(array);
        ap.enableButtons(true);
    }

    /**
     * sorts an array using buuble sort
     * @param array integer array
     */
    private void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    try {
                        ap.repaint();
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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

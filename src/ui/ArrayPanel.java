package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * A JPanel to draw the bars representing values in an array
 */
public class ArrayPanel extends JPanel {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final int ARRAY_SIZE = 100;
    private final int BAR_SIZE = WIDTH / ARRAY_SIZE;
    private final int[] array;
    private final JButton[] sortButtons;

    public ArrayPanel(JButton[] sortButtons) {
        this.sortButtons = sortButtons;
        array = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = i;
        }
        shuffle();
    }

    /**
     * shuffles an array
     */
    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int randIndex = rand.nextInt(array.length);
            int temp = array[randIndex];
            array[randIndex] = array[i];
            array[i] = temp;
        }
    }

    /**
     * sets buttons to enable or not
     * @param enable true or false
     */
    public void enableButtons(boolean enable) {
        for (JButton b : sortButtons) {
            b.setEnabled(enable);
        }
    }

    /**
     * Draws bars on the panel
     * @param g graphics object
     */
    public void paintComponent(Graphics g) {
        Graphics2D gPanel = (Graphics2D) g;
        super.paintComponent(gPanel);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int h = array[i] * 5;
            int x = i + (BAR_SIZE - 1) * i;
            int y = HEIGHT - h;
            gPanel.fillRect(x,y,BAR_SIZE,h);
        }
    }

    /**
     * gets the array of integers
     * @return an array of integers
     */
    public int[] getArray() { return array; }
}

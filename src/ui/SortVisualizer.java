package ui;

import algorithms.BubbleSort;
import algorithms.InsertionSort;
import algorithms.MergeSort;
import algorithms.QuickSort;

import javax.swing.*;
import java.awt.*;

/**
 * Main class for the application
 */
public class SortVisualizer {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 640;
    private JFrame window;
    private JPanel base;
    private ArrayPanel arrayPanel;
    private JToolBar toolbar;
    private JButton bubbleBtn;
    private JButton insertBtn;
    private JButton mergeBtn;
    private JButton quickBtn;
    private JButton shuffleBtn;
    private JButton exitBtn;

    public SortVisualizer() {
        initialize();
        setToolbar();
        setWindow();
        setButtonHandlers();
    }

    /**
     * shows the application
     */
    public void show() {
        window.setVisible(true);
    }

    /**
     * initializes the variables
     */
    private void initialize() {
        window = new JFrame();
        base = new JPanel();
        toolbar = new JToolBar();
        bubbleBtn = new JButton("Bubble Sort");
        insertBtn = new JButton("Insertion Sort");
        mergeBtn = new JButton("Merge Sort");
        quickBtn = new JButton("Quick Sort");
        shuffleBtn = new JButton("Shuffle Values");
        exitBtn = new JButton("Exit");
        JButton[] sortButtons = {bubbleBtn, insertBtn, mergeBtn, quickBtn, shuffleBtn};
        arrayPanel = new ArrayPanel(sortButtons);
    }

    /**
     * adds buttons to a tool bar
     */
    private void setToolbar() {
        toolbar.add(shuffleBtn);
        toolbar.addSeparator();
        toolbar.add(bubbleBtn);
        toolbar.addSeparator();
        toolbar.add(insertBtn);
        toolbar.addSeparator();
        toolbar.add(quickBtn);
        toolbar.addSeparator();
        toolbar.add(mergeBtn);
        toolbar.addSeparator();
        toolbar.add(exitBtn);

        toolbar.setFloatable(false);
    }

    /**
     * sets up the application window
     */
    private void setWindow() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setSize(WIDTH,HEIGHT);
        window.getContentPane().setPreferredSize(new Dimension(WIDTH,HEIGHT));
        window.pack();
        window.setTitle("Sort Visualizer");

        base.setLayout(new BoxLayout(base,BoxLayout.Y_AXIS));
        base.add(toolbar);
        base.add(arrayPanel);
        window.add(base);
    }

    /**
     * sets the actions for the buttons
     */
    private void setButtonHandlers() {
        bubbleBtn.addActionListener(e -> new BubbleSort(arrayPanel).start());
        insertBtn.addActionListener(e -> new InsertionSort(arrayPanel).start());
        mergeBtn.addActionListener(e -> new MergeSort(arrayPanel).start());
        quickBtn.addActionListener(e -> new QuickSort(arrayPanel).start());
        exitBtn.addActionListener(e -> System.exit(0));

        shuffleBtn.addActionListener(e -> {
            arrayPanel.shuffle();
            arrayPanel.repaint();
        });
    }

    public static void main(String[] args) {
        new SortVisualizer().show();
    }
}

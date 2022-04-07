package com.company;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    private JButton startButton;
    private JButton stopButton;
    private JPanel mainPanel;
    private JLabel farmingStatusLabel;
    private Clicker clicker;
    private final SwingWorker worker = new SwingWorker() {
        @Override
        protected Object doInBackground() throws Exception {
            farmingStatusLabel.setText("Farming Status: WORKING");
            clicker.start();
            return null;
        }

        @Override
        protected void done() {
            farmingStatusLabel.setText("Farming Status: STOPPED");
        }
    };

    public MainForm(String title) throws HeadlessException {
        super(title);
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(600, 280);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.farmingStatusLabel.setText("Farming Status: STOPPED");

        startButton.addActionListener(actionEvent -> {
            try {
                startFarming();
            } catch (AWTException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        stopButton.addActionListener(actionEvent -> stopFarming());
    }

    void startFarming() throws AWTException, InterruptedException {
        int wKeyCode = 87;
        int delay = 2800;
        this.clicker = new Clicker(delay, wKeyCode);
        worker.execute();
    }

    void stopFarming() {
        worker.cancel(true);
        farmingStatusLabel.setText("Farming Status: STOPPED");
    }
}

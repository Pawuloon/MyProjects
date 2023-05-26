package Task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextProblem extends JFrame
{
    private JTextArea textArea1, textArea2;
    private JButton button1, button2;
    private Thread thread1, thread2;
    private boolean isThread1Running, isThread2Running;

    public TextProblem()
    {
        setTitle("Threaded Text Area");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        textArea1.setEditable(false);
        textArea2.setEditable(false);

        button1 = new JButton("SUSP");
        button2 = new JButton("SUSP");

        button1.addActionListener(e -> toggleThread(thread1, button1));
        button2.addActionListener(e -> toggleThread(thread2, button2));

        JPanel textAreaPanel = new JPanel(new GridLayout(1, 2));
        textAreaPanel.add(new JScrollPane(textArea1));
        textAreaPanel.add(new JScrollPane(textArea2));

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        add(textAreaPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        TextProblem.this,
                        "Are you sure?",
                        "Confirmation",
                        JOptionPane.OK_CANCEL_OPTION
                );
                if (option == JOptionPane.OK_OPTION) {
                    dispose();
                    System.exit(0);
                }
            }
        });

        setVisible(true);
        startThreads();
    }

    private void startThreads() {
        thread1 = new Thread(() -> {
            isThread1Running = true;
            while (isThread1Running) {
                try {
                    SwingUtilities.invokeLater(() -> {
                        textArea1.append(getCurrentTime() + "\n");
                        textArea1.setCaretPosition(textArea1.getDocument().getLength());
                    });
                    Thread.sleep(getRandomTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread2 = new Thread(() -> {
            isThread2Running = true;
            while (isThread2Running) {
                try {
                    SwingUtilities.invokeLater(() -> {
                        textArea2.append(getCurrentTime() + "\n");
                        textArea2.setCaretPosition(textArea2.getDocument().getLength());
                    });
                    Thread.sleep(getRandomTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    private String getCurrentTime() {
        return String.valueOf(System.currentTimeMillis());
    }

    private int getRandomTime() {
        return (int) (Math.random() * 1000) + 500;
    }

    private void toggleThread(Thread thread, JButton button) {
        if (thread.isAlive()) {
            button.setText("GO");
            if (thread == thread1) {
                isThread1Running = false;
            } else if (thread == thread2) {
                isThread2Running = false;
            }
        } else {
            button.setText("SUSP");
            if (thread == thread1) {
                isThread1Running = true;
            } else if (thread == thread2) {
                isThread2Running = true;
            }
        }
    }

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {
    private JFrame frame;
    private JButton[] buttons;
    private JButton resetButton;
    private JLabel textField;
    private boolean isPlayersTurn;

    public static void main(String[] args) {
        TicTacToe tictactoe = new TicTacToe();
    }

    TicTacToe() {
        frame = new JFrame("Tic Tac Toe");
        frame.setPreferredSize(new Dimension(800, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());

        resetButton = createResetButton();
        frame.add(resetButton, BorderLayout.SOUTH);

        isPlayersTurn = true;

        textField = new JLabel();
        textField.setBackground(new Color(33, 158, 189));
        textField.setForeground(new Color(38, 184, 220));
        textField.setFont(new Font("Times New Roman", Font.BOLD, 80));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("X Turn");

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);
        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));
        frame.add(buttonPanel);

        buttons = new JButton[10];
        for (int i = 1; i < 10; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Times New Roman", Font.BOLD, 100));
            buttons[i].addActionListener(this);
        }

        frame.pack();
        frame.setVisible(true);
    }

    private JButton createResetButton() {
        JButton button = new JButton("Reset");
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            resetGame();
        } else {
            for (int x = 1; x < 10; x++) {
                if (e.getSource() == buttons[x]) {
                    if (buttons[x].getText().equals("")) {
                        if (isPlayersTurn) {
                            buttons[x].setText("X");
                            textField.setText("O Turn");
                        } else {
                            buttons[x].setText("O");
                            textField.setText("X Turn");
                        }
                        buttons[x].setEnabled(false);
                        check();
                        isPlayersTurn = !isPlayersTurn;
                    }
                }
            }
        }
    }

    public void check() {
        // X win conditions
        if (buttons[1].getText().equals("X") && buttons[2].getText().equals("X") && buttons[3].getText().equals("X")) {
            textField.setText("X win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(1, 2, 3);
        } else if (buttons[4].getText().equals("X") && buttons[5].getText().equals("X") && buttons[6].getText().equals("X")) {
            textField.setText("X win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(4, 5, 6);
        } else if (buttons[7].getText().equals("X") && buttons[8].getText().equals("X") && buttons[9].getText().equals("X")) {
            textField.setText("X win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(7, 8, 9);
        } else if (buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")) {
            textField.setText("X win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(1, 4, 7);
        } else if (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")) {
            textField.setText("X win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(2, 5, 8);
        } else if (buttons[3].getText().equals("X") && buttons[6].getText().equals("X") && buttons[9].getText().equals("X")) {
            textField.setText("X win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(3, 6, 9);
        } else if (buttons[1].getText().equals("X") && buttons[5].getText().equals("X") && buttons[9].getText().equals("X")) {
            textField.setText("X win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(1, 5, 9);
        } else if (buttons[3].getText().equals("X") && buttons[5].getText().equals("X") && buttons[7].getText().equals("X")) {
            textField.setText("X win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(3, 5, 7);
        }
        // O win conditions
        else if (buttons[1].getText().equals("O") && buttons[2].getText().equals("O") && buttons[3].getText().equals("O")) {
            textField.setText("O win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(1, 2, 3);
        } else if (buttons[4].getText().equals("O") && buttons[5].getText().equals("O") && buttons[6].getText().equals("O")) {
            textField.setText("O win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(4, 5, 6);
        } else if (buttons[7].getText().equals("O") && buttons[8].getText().equals("O") && buttons[9].getText().equals("O")) {
            textField.setText("O win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(7, 8, 9);
        } else if (buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")) {
            textField.setText("O win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(1, 4, 7);
        } else if (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")) {
            textField.setText("O win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(2, 5, 8);
        } else if (buttons[3].getText().equals("O") && buttons[6].getText().equals("O") && buttons[9].getText().equals("O")) {
            textField.setText("O win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(3, 6, 9);
        } else if (buttons[1].getText().equals("O") && buttons[5].getText().equals("O") && buttons[9].getText().equals("O")) {
            textField.setText("O win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(1, 5, 9);
        } else if (buttons[3].getText().equals("O") && buttons[5].getText().equals("O") && buttons[7].getText().equals("O")) {
            textField.setText("O win");
            textField.setForeground(new Color(0, 255, 0));
            highlightWinningButtons(3, 5, 7);
        }
        // Draw condition
        else if (!buttons[1].getText().equals("") && !buttons[2].getText().equals("") && !buttons[3].getText().equals("")
                && !buttons[4].getText().equals("") && !buttons[5].getText().equals("") && !buttons[6].getText().equals("")
                && !buttons[7].getText().equals("") && !buttons[8].getText().equals("") && !buttons[9].getText().equals("")) {
            textField.setText("Draw");
            textField.setForeground(new Color(255, 0, 0));
        }
    }

    public void highlightWinningButtons(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
    }

    public void resetGame() {
        for (int i = 1; i < 10; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
            buttons[i].setBackground(null);
        }
        textField.setText("X Turn");
        textField.setForeground(new Color(38, 184, 220));
        isPlayersTurn = true;
    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

        public class SudokuGUI extends JFrame {

            private JTextField[][] cells = new JTextField[9][9];

            private int[][] board = {
                    {5,3,4,6,7,8,9,1,2},
                    {6,7,2,1,9,5,3,4,8},
                    {1,9,8,3,4,2,5,6,7},
                    {8,5,9,7,6,1,4,2,3},
                    {4,2,6,8,5,3,7,9,1},
                    {7,1,3,9,2,4,8,5,6},
                    {9,6,1,5,3,7,2,8,4},
                    {2,8,7,4,1,9,6,3,5},
                    {3,4,5,2,8,6,1,7,9}
            };

            public SudokuGUI() {
                setTitle("Sudoku");
                setSize(500, 500);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(new BorderLayout());

                JPanel gridPanel = new JPanel();
                gridPanel.setLayout(new GridLayout(9, 9));

                // Criar células do tabuleiro
                for (int row = 0; row < 9; row++) {
                    for (int col = 0; col < 9; col++) {
                        JTextField cell = new JTextField();
                        cell.setHorizontalAlignment(JTextField.CENTER);
                        cell.setFont(new Font("Arial", Font.BOLD, 20));
                        if (board[row][col] != 0) {
                            cell.setText(String.valueOf(board[row][col]));
                            cell.setEditable(false);
                            cell.setBackground(Color.LIGHT_GRAY);
                        }
                        cells[row][col] = cell;
                        gridPanel.add(cell);
                    }
                }

                JButton checkButton = new JButton("Verificar");
                checkButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (isBoardValid()) {
                            JOptionPane.showMessageDialog(null, "Parabéns! Sudoku correto!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Existem erros no Sudoku!");
                        }
                    }
                });

                add(gridPanel, BorderLayout.CENTER);
                add(checkButton, BorderLayout.SOUTH);
                setVisible(true);
            }

            // Verifica se o Sudoku está correto
            private boolean isBoardValid() {
                int[][] tempBoard = new int[9][9];
                try {
                    for (int row = 0; row < 9; row++) {
                        for (int col = 0; col < 9; col++) {
                            tempBoard[row][col] = Integer.parseInt(cells[row][col].getText());
                        }
                    }
                } catch (NumberFormatException e) {
                    return false; // algum campo não é número
                }

                // Verifica linhas, colunas e quadrantes 3x3
                for (int i = 0; i < 9; i++) {
                    boolean[] rowCheck = new boolean[10];
                    boolean[] colCheck = new boolean[10];
                    for (int j = 0; j < 9; j++) {
                        int rowNum = tempBoard[i][j];
                        int colNum = tempBoard[j][i];
                        if (rowNum < 1 || rowNum > 9 || rowCheck[rowNum]) return false;
                        if (colNum < 1 || colNum > 9 || colCheck[colNum]) return false;
                        rowCheck[rowNum] = true;
                        colCheck[colNum] = true;
                    }
                }

                // Verifica blocos 3x3
                for (int row = 0; row < 9; row += 3) {
                    for (int col = 0; col < 9; col += 3) {
                        boolean[] blockCheck = new boolean[10];
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                int num = tempBoard[row + i][col + j];
                                if (num < 1 || num > 9 || blockCheck[num]) return false;
                                blockCheck[num] = true;
                            }
                        }
                    }
                }

                return true;
            }

            public static void main(String[] args) {
                SwingUtilities.invokeLater(SudokuGUI::new);
            }
        }

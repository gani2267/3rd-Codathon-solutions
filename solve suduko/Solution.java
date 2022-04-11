// This function checks if the number is safe to put on the board at row, col
    private static boolean isSafe(List> board, int row, int col, int num) {

        // Check in the row, if the number is already present
        for (int i = 0; i < 9; i++) {
            if (board.get(row).get(i) == num) {
                return false;
            }
        }

        // Check in the column, if the number is already present
        for (int i = 0; i < 9; i++) {
            if (board.get(i).get(col) == num) {
                return false;
            }
        }

        // Check in the corresponding 3 x 3 box, if the number is already present
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;

        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (board.get(i).get(j) == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Utility function to solve the sudoku board
    private static boolean solveSudokuUtil(List> board) {

        // Check for next empty space
        int row = 0;
        int col = 0;
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 0 signifies the empty cell
                if (board.get(i).get(j) == 0) {
                    row = i;
                    col = j;

                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // no empty space left, a solution is found
        if (isEmpty) {
            return true;
        }

        // Loop through 1 to 9 and check which number is feasible to be placed in the found empty cell
        for (int num = 1; num <= 9; num++) {


            if (isSafe(board, row, col, num)) {
                board.get(row).set(col, num);

                // If a number is found to be safe, recurse to fill the next empty cell
                if (solveSudokuUtil(board)) {
                    return true;

                } else {
                    // If this number does not lead to a solution, try next number in the loop or backtrack to the previous element.
                    board.get(row).set(col, 0);
                }
            }
        }
        return false;
    }

    // Function to print the board
    private static void print(List> board) {
        for (int r = 0; r < 9; r++) {
            for (int d = 0; d < 9; d++) {
                System.out.print(board.get(r).get(d));
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static List> sudokuSolver(List> board) {

        solveSudokuUtil(board);
        return board;
    }



package tictactoe;

import java.util.Scanner;

public class Main {
    static char[][] array = {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'},
    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scan.nextLine();
        insertIntoFields(input);
        printGameGrid();
        testGame();
    }

    private static void insertIntoFields(String input) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                array[row][column] = input.charAt(row * 3 + column);
            }
        }
    }

    private static void printGameGrid() {
        System.out.println("---------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int column = 0; column < 3; column++) {
                char c = array[row][column];
                System.out.print(c + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }


    private static boolean checkThreeInRow(char character) {
        for (int row = 0; row < 3; row++) {
            if (array[row][0] == character && array[row][1] == character && array[row][2] == character) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkThreeInColumn(char character) {
        for (int column = 0; column < 3; column++) {
            if (array[0][column] == character && array[1][column] == character && array[2][column] == character) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkThreeDiagonal(char character) {
        if (array[0][0] == character && array[1][1] == character && array[2][2] == character) {
            return true;
        }
        if (array[2][0] == character && array[1][1] == character && array[0][2] == character) {
            return true;
        }
        return false;
    }
    private static boolean checkEmptySpace() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (array[row][column] == '_') {
                    return true;
                }
            }
        }
        return false;

    }
    private static int countNumberOfCharacters(char character) {
        int counter = 0;
        for (int row = 0; row < 3; row ++) {
            for (int column = 0; column < 3; column ++) {
                if (array[row][column] == character) {
                    counter++;
                }
            }
        }

        return counter;
    }

    private static void testGame() {
        if((checkThreeInRow('X') && checkThreeInRow('O')) ||
                (checkThreeInColumn('X')) && checkThreeInColumn('O') ||
                (((Math.abs(countNumberOfCharacters('X') - countNumberOfCharacters('O'))) > 1))){
            System.out.println("Impossible");
        } else if (checkThreeInRow('X') || checkThreeInColumn('X') || checkThreeDiagonal('X')) {
            System.out.println("X wins");
        } else if (checkThreeInRow('O') || checkThreeInColumn('O') || checkThreeDiagonal('O')) {
            System.out.println("O wins");
        } else if (checkEmptySpace()){
            System.out.println("Game not finished");
        }else if (!checkEmptySpace()){
            System.out.println("Draw");
        }

    }
}

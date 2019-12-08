import java.util.*;

/**
 *  Author: Muhammad Salman Khan
 *
 *  This program plays Tic Tac Toe game with user
 */
public class TicTacToe {

    private static char[] board = new char[9];
    private static ArrayList<Integer> empSpots = new ArrayList<>(9);
    private static Scanner kbd = new Scanner(System.in);
    private static char comp;
    private static char player;

    /**
     * Main method gets user's choice of mark, gives array representing boards and ArrayList representing empty spots
     * initial values and keeps calling playerTurn and ComputerTurn methods along with checkWin and checkDraw methods
     * until either there is a winner or game draws
     * @param args is not used
     */
    public static void main(String[] args) {

        System.out.println("TIC TAC TOE");

        boolean isValid = false;
        String rawResp;
        do {
            System.out.println("\nChoose a mark:\n1 - x\n2 - o");
            rawResp = kbd.nextLine();
                if (rawResp.equals("1")) {
                    player = 'x';
                    comp = 'o';
                    isValid = true;
                } else if (rawResp.equals("2")) {
                    player = 'o';
                    comp = 'x';
                    isValid = true;
                } else {
                    System.out.println("\nInvalid Entry");
                }
        } while(!isValid);

        System.out.printf("\nYour Mark: %c\nComputer's Mark: %c\n", player, comp);

        for (int i = 0; i < board.length; i++) {
            board[i] = Character.forDigit(i, 10);
            empSpots.add(i);
        }

        System.out.print("\n");
        showBoard();

        while(true){
            playerTurn();
            showBoard();
            if(checkWin(player)) {
                System.out.println("\nYOU WIN!");
                kbd.close();
                break;
            }
            compTurn();
            showBoard();
            if(checkWin(comp)) {
                System.out.println("\nCOMPUTER WINS");
                kbd.close();
                break;
            }
            if(empSpots.size() == 1)
                checkDraw();
        }

    }

    /**
     * This method displays array representing board
     */
    private static void showBoard() {

        int ind = 0;
        for (int i = 0; i <= 2; i++){
            for (int j = 0; j <= 2; j++){
                System.out.print(board[ind] + " ");
                ind++;
            }
            System.out.print("\n");
        }

    }

    /**
     * This method asks user for his/her choice of next mark and validates it
     */
    private static void playerTurn() {

        boolean isValid = false;
        String rawResp;
        int resp = -1;
        do {
            System.out.print("\nChoose an available integer to replace with '" + player + "': ");
            rawResp = kbd.nextLine();
            if (rawResp.length() == 1) {
                rawResp = String.valueOf(rawResp.charAt(0));
                if (Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8").contains(rawResp)) {
                    resp = Integer.parseInt(rawResp);
                    if (empSpots.contains(resp)) {
                        isValid = true;
                        removeSpot(resp);
                    } else {
                        System.out.println("\nInvalid Entry");
                    }
                } else {
                    System.out.println("\nInvalid Entry");
                }
            } else {
                System.out.println("\nInvalid Entry");
            }
        } while(!isValid);
        board[resp] = player;
        System.out.print("\n");

    }

    /**
     * This method analyses board representing array and places computer's mark appropriately
     */
    private static void compTurn() {

        Random rand = new Random();
        int choice;
        System.out.println("\nComputer's Turn:\n");
        if ((board[0] == player && board[2] == player || board[0] == comp && board[2] == comp) &&
                empSpots.contains(1)) {
            board[1] = comp;
            removeSpot(1);
        } else if ((board[3] == player && board[5] == player || board[3] == comp && board[5] == comp) &&
                empSpots.contains(4)) {
            board[4] = comp;
            removeSpot(4);
        } else if ((board[6] == player && board[8] == player || board[6] == comp && board[8] == comp) &&
                empSpots.contains(7)) {
            board[7] = comp;
            removeSpot(7);
        } else if ((board[0] == player && board[6] == player || board[0] == comp && board[6] == comp) &&
                empSpots.contains(3)) {
            board[3] = comp;
            removeSpot(3);
        } else if ((board[1] == player && board[7] == player || board[1] == comp && board[7] == comp) &&
                empSpots.contains(4)) {
            board[4] = comp;
            removeSpot(4);
        } else if ((board[2] == player && board[8] == player || board[2] == comp && board[8] == comp) &&
                empSpots.contains(5)) {
            board[5] = comp;
            removeSpot(5);
        } else if ((board[0] == player && board[8] == player || board[0] == comp && board[8] == comp) &&
                empSpots.contains(4)) {
            board[4] = comp;
            removeSpot(4);
        } else if ((board[2] == player && board[6] == player || board[2] == comp && board[6] == comp) &&
                empSpots.contains(4)) {
            board[4] = comp;
            removeSpot(4);
        } else if ((board[0] == player && board[1] == player || board[0] == comp && board[1] == comp) &&
                empSpots.contains(2)) {
            board[2] = comp;
            removeSpot(2);
        } else if ((board[3] == player && board[4] == player || board[3] == comp && board[4] == comp) &&
                empSpots.contains(5)) {
            board[5] = comp;
            removeSpot(5);
        } else if ((board[6] == player && board[7] == player || board[6] == comp && board[7] == comp) &&
                empSpots.contains(8)) {
            board[8] = comp;
            removeSpot(8);
        } else if ((board[0] == player && board[3] == player || board[0] == comp && board[3] == comp) &&
                empSpots.contains(6)) {
            board[6] = comp;
            removeSpot(6);
        } else if ((board[1] == player && board[4] == player || board[1] == comp && board[4] == comp) &&
                empSpots.contains(7)) {
            board[7] = comp;
            removeSpot(7);
        } else if ((board[2] == player && board[5] == player || board[2] == comp && board[5] == comp) &&
                empSpots.contains(8)) {
            board[8] = comp;
            removeSpot(8);
        } else if ((board[1] == player && board[2] == player || board[1] == comp && board[2] == comp) &&
                empSpots.contains(0)) {
            board[0] = comp;
            removeSpot(0);
        } else if ((board[4] == player && board[5] == player || board[4] == comp && board[5] == comp) &&
                empSpots.contains(3)) {
            board[3] = comp;
            removeSpot(3);
        } else if ((board[7] == player && board[8] == player || board[7] == comp && board[8] == comp) &&
                empSpots.contains(6)) {
            board[6] = comp;
            removeSpot(6);
        } else if ((board[3] == player && board[6] == player || board[3] == comp && board[6] == comp) &&
                empSpots.contains(0)) {
            board[0] = comp;
            removeSpot(0);
        } else if ((board[4] == player && board[7] == player || board[4] == comp && board[7] == comp) &&
                empSpots.contains(1)) {
            board[1] = comp;
            removeSpot(1);
        } else if ((board[5] == player && board[8] == player || board[5] == comp && board[8] == comp) &&
                empSpots.contains(2)) {
            board[2] = comp;
            removeSpot(2);
        } else if ((board[0] == player && board[4] == player || board[0] == comp && board[4] == comp) &&
                empSpots.contains(8)) {
            board[8] = comp;
            removeSpot(8);
        } else if ((board[4] == player && board[8] == player || board[4] == comp && board[8] == comp) &&
                empSpots.contains(0)) {
            board[0] = comp;
            removeSpot(0);
        } else if ((board[6] == player && board[4] == player || board[6] == comp && board[4] == comp) &&
                empSpots.contains(2)) {
            board[2] = comp;
            removeSpot(2);
        } else if ((board[2] == player && board[4] == player || board[2] == comp && board[4] == comp) &&
                empSpots.contains(6)) {
            board[6] = comp;
            removeSpot(6);
        } else {
            choice = rand.nextInt(empSpots.size());
            board[empSpots.get(choice)] = comp;
            empSpots.remove(choice);
        }

    }

    /**
     * Checks whether a player has won
     * @param sign receives 'x' or 'o'
     * @return true if player with the sign received in parameter has won, false otherwise
     */
    private static boolean checkWin(char sign) {

        return (board[0] == sign && board[1] == sign && board[2] == sign || board[3] == sign && board[4] == sign &&
                board[5] == sign || board[6] == sign && board[7] == sign && board[8] == sign || board[0] == sign
                && board[3] == sign && board[6] == sign || board[1] == sign && board[4] == sign && board[7] == sign
                || board[2] == sign && board[5] == sign && board[8] == sign || board[0] == sign && board[4] == sign
                && board[8] == sign || board[2] == sign && board[4] == sign && board[6] == sign);

    }

    /**
     * Checks whether game is draw or not
     */
    private static void checkDraw() {

        if(checkWin(player)){
            System.out.println("\nYOU WIN!");
        } else if (checkWin(comp)){
            System.out.println("\nCOMPUTER WINS");
        } else {
            System.out.println("\nIT'S A DRAW");
        }
        kbd.close();
        System.exit(0);

    }

    /**
     * Removes received spot from ArrayList containing empty spots
     * @param spot receives number of the spot to be removed
     */
    private static void removeSpot(int spot) {

        for (int i = 0; i < empSpots.size(); i++){
            if (empSpots.get(i) == spot) {
                empSpots.remove(i);
                break;
            }
        }

    }

}

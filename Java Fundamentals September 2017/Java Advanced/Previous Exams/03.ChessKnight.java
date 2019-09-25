import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        HashMap<List<Integer>, String> pieces = new HashMap<>();
        String[][] board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            board[i] = scanner.readLine().split("\\|");
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!" ".equals(board[i][j])) {
                    List<Integer> whereabouts = new LinkedList<>();
                    whereabouts.add(i);
                    whereabouts.add(j);
                    pieces.put(whereabouts, board[i][j]);
                }
            }
        }
        ArrayList<String> piecesGot = new ArrayList<>();
        int outsideBoardCnt = 0;
        int invalidMovesCnt = 0;
        String initialPosition = scanner.readLine();
        int currentRow = Integer.parseInt(initialPosition.substring(0, 1));
        int currentColumn = Integer.parseInt(initialPosition.substring(1, 2));
        while(true){
            String[] moves = scanner.readLine().split(" -> ");
            if ("END".equals(moves[0])) {
                break;
            }
            int row = Integer.parseInt(moves[0].substring(0, 1));
            int column = Integer.parseInt(moves[0].substring(1, 2));
            int nextRow = Integer.parseInt(moves[1].substring(0, 1));
            int nextColumn = Integer.parseInt(moves[1].substring(1, 2));
            if ((nextRow == row - 2 && nextColumn == column - 1) ||
                    (nextRow == row - 2 && nextColumn == column + 1) || (nextRow == row - 1 && nextColumn == column - 2) || (nextRow == row - 1 && nextColumn == column + 2) ||
                    (nextRow == row + 2 && nextColumn == column + 1) || (nextRow == row + 2 && nextColumn == column - 1) ||
                    (nextRow == row + 1 && nextColumn == column + 2) || (nextRow == row + 1 && nextColumn == column - 2)) {
                if (nextRow < 8 && nextColumn < 8) {

                    for (List<Integer> key : pieces.keySet()) {
                        if (key.get(0) == nextRow && key.get(1) == nextColumn) {
                            piecesGot.add(pieces.get(key));
                        }
                    }
                    currentColumn = nextColumn;
                    currentRow = nextRow;
                }
                else {
                    outsideBoardCnt++;
                }
            }
            else {
                invalidMovesCnt++;
            }
        }
        System.out.println("Pieces take: " + Arrays.toString(piecesGot.toArray()).replaceAll("[\\[\\]]", ""));
        System.out.println("Invalid moves: " + invalidMovesCnt);
        System.out.println("Board out moves: " + outsideBoardCnt);
    }
}
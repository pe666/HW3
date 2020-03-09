public class ChessBoard {
    int x;
    int y;

    public ChessBoard(int x, int y) {
        if (x > 7 || x < 0 || y > 7 || y < 0) throw new IllegalArgumentException("Value is incorrect");
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        String xCord = "abcdefgh";
        String yCord = "12345678";
        char[] x = xCord.toCharArray();
        char[] y = yCord.toCharArray();
        return x[this.x] + "" + y[this.y];
    }

    public static ChessBoard toChessBoard(String chessPos) {
        String xCord = "abcdefgh";
        String yCord = "12345678";
        char[] xPos = xCord.toCharArray();
        char[] yPos = yCord.toCharArray();
        char[] strChess = chessPos.toCharArray();
        int x = 0;
        int y = 0;
        for (int i = 0; i < xPos.length; i++) {
            if (xPos[i]==strChess[0]) x = i;
        }
        for (int i = 0; i < yPos.length; i++) {
            if (yPos[i]==strChess[1]) y = i;
        }
        return new ChessBoard(x,y);
    }

    public static boolean isCorrectMove(ChessBoard cb1, ChessBoard cb2){
        return ((cb1.x+1 == cb2.x) && ((cb2.y == cb1.y + 2) || (cb2.y == cb1.y - 2))) ||
                ((cb1.x-1 == cb2.x) && ((cb2.y == cb1.y + 2) || (cb2.y == cb1.y - 2))) ||
                ((cb1.x+2 == cb2.x) && ((cb2.y == cb1.y + 1) || (cb2.y == cb1.y - 1)))||
                ((cb1.x-2 == cb2.x) && ((cb2.y == cb1.y + 1) || (cb2.y == cb1.y - 1)));
    }

    public static String chessKnightMove(String[] moves) throws IllegalMoveException {
        for (int i = 0; i < moves.length-1; i++) {
            if (!isCorrectMove(toChessBoard(moves[i]), toChessBoard(moves[i+1]))) {
                throw new IllegalMoveException("Конь так не ходит " + moves[i] + "->" + moves[i+1]);
            }
        }
        return "OK";
    }
}

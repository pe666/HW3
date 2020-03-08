public class chessBoard {
    int x;
    int y;

    chessBoard(int x, int y) {
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

    public static boolean isCorrectMove(chessBoard cb1, chessBoard cb2){
        return ((cb1.x+1 == cb2.x) && ((cb2.y == cb1.y + 2) || (cb2.y == cb1.y - 2))) ||
                ((cb1.x-1 == cb2.x) && ((cb2.y == cb1.y + 2) || (cb2.y == cb1.y - 2))) ||
                ((cb1.x+2 == cb2.x) && ((cb2.y == cb1.y + 1) || (cb2.y == cb1.y - 1)))||
                ((cb1.x-2 == cb2.x) && ((cb2.y == cb1.y + 1) || (cb2.y == cb1.y - 1)));
    }

    public static String chessKnightMove(chessBoard[] moves) throws IllegalMoveException {
        for (int i = 0; i < moves.length-1; i++) {
            if (!isCorrectMove(moves[i], moves[i+1])) {
                throw new IllegalMoveException("Конь так не ходит " + moves[i] + "->" + moves[i+1]);
            }
        }
        return "OK";
    }
}

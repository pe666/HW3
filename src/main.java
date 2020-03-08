public class main {
    public static void main(String[] args) throws IllegalMoveException {
        chessBoard cB1 = new chessBoard(6, 7);
        chessBoard cB2 = new chessBoard(4, 6);
        chessBoard cB3 = new chessBoard(4, 5);
        chessBoard[] chBo = new chessBoard[] {cB1, cB2, cB3};
        System.out.println(chessBoard.chessKnightMove(chBo));

    }
}

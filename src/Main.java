public class Main {
    public static void main(String[] args) throws IllegalMoveException {
        String cB1 = new ChessBoard(6, 7).toString();
        String cB2 = new ChessBoard(4, 6).toString();
        String cB3 = new ChessBoard(4, 5).toString();
        String[] chBo = new String[] {cB1, cB2, cB3};
        System.out.println(ChessBoard.chessKnightMove(chBo));

    }
}

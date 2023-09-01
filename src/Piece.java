//public static class Piece?
public class Piece {
    public static final int None = 0;
    public static final int King = 1;
    public static final int Pawn = 2;
    public static final int Knight = 3;
    public static final int Bishop = 4;
    public static final int Rook = 5;
    public static final int Queen = 6;


    public static final int White = 8;
    public static final int Black = 16;



    //define integer constants for code clarity
    public static final int WHITE_KING = King | White;
    public static final int WHITE_QUEEN = Queen | White;
    public static final int WHITE_ROOK = Rook | White;
    public static final int WHITE_BISHOP = Bishop | White;
    public static final int WHITE_KNIGHT = Knight | White;
    public static final int WHITE_PAWN = Pawn | White;


    public static final int BLACK_KING = King | Black;
    public static final int BLACK_QUEEN = Queen | Black;
    public static final int BLACK_ROOK = Rook | Black;
    public static final int BLACK_BISHOP = Bishop | Black;
    public static final int BLACK_KNIGHT = Knight | Black;
    public static final int BLACK_PAWN = Pawn | Black;

}

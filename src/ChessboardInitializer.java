import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import javafx.scene.input.*;
import java.awt.*;

public class ChessboardInitializer {
    private String fenString;
    //private variable to hold the FENstring
    private int[][] chessboard;
    //private variable that represents the chessboard as a 2d array
    private Button[][] chessBoardButtons;
    //private variable that holds the 2d array of buttons


    //declaring the constructor and its parameters
    public ChessboardInitializer(String fenString, Button[][] chessBoardButtons){
        this.fenString = fenString;
        this.chessboard = new int[8][8];
        this.chessBoardButtons = chessBoardButtons;
    }
    //declaring a new method called initializeChessboard
    public void initializeChessboard() {
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                chessBoardButtons[row][col] = new Button();
                Button button = chessBoardButtons[row][col];
            }
        }
        //split the fen string into an array of sections (step 6)
        String[] fenRows = fenString.split("/");

        //for loop to iterate each col and row
        for(int row = 0; row < 8; row++){
            String fenRow = fenRows[row];
            //loop body
            int col = 0;
            //nested for loop, connects sections to char array and assigns fenchar variable
            for (char fenChar : fenRow.toCharArray()) {
                int piece = Piece.None;
                //if fenChar is number, current position + numeric value
                if(Character.isDigit(fenChar)){
                    int numEmptySquares = Character.getNumericValue(fenChar);
                    col += numEmptySquares;
                    col = Math.min(col, 7);
                    //else squares with pieces
                } else {
                    //switch case which piece
                    switch(fenChar){
                        case 'K':
                            piece = Piece.WHITE_KING;
                            break;
                        case 'Q':
                            piece = Piece.WHITE_QUEEN;
                            break;
                        case 'R':
                            piece = Piece.WHITE_ROOK;
                            break;
                        case 'B':
                            piece = Piece.WHITE_BISHOP;
                            break;
                        case 'N':
                            piece = Piece.WHITE_KNIGHT;
                            break;
                        case 'P':
                            piece = Piece.WHITE_PAWN;
                            break;
                        case 'k':
                            piece = Piece.BLACK_KING;
                            break;
                        case 'q':
                            piece = Piece.BLACK_QUEEN;
                            break;
                        case 'r':
                            piece = Piece.BLACK_ROOK;
                            break;
                        case 'b':
                            piece = Piece.BLACK_BISHOP;
                            break;
                        case 'n':
                            piece = Piece.BLACK_KNIGHT;
                            break;
                        case 'p':
                            piece = Piece.BLACK_PAWN;
                    }
                    chessboard[row][col] = piece;
                    col++;

                    //step 8 next
                }
            }
        }


        updateChessboardButtons();
    }
    private void updateChessboardButtons() {
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                //retrieves the button at current position
                Button button = chessBoardButtons[row][col];
                //retrieves the piece value at current position
                int piece = chessboard[row][col];

                ImageView pieceImageView = createPieceImageView(piece);
                button.setGraphic(pieceImageView);
                DragAndDropHandler dragAndDropHandler = new DragAndDropHandler(pieceImageView, chessBoardButtons);

                switch(piece){
                    case Piece.WHITE_KING:
                        button.setGraphic(new KingPiece(Color.WHITE, 84));
                        break;
                    case Piece.WHITE_QUEEN:
                        button.setGraphic(new QueenPiece(Color.WHITE, 84));
                        break;
                    case Piece.WHITE_ROOK:
                        button.setGraphic(new RookPiece(Color.WHITE, 84));
                        break;
                    case Piece.WHITE_BISHOP:
                        button.setGraphic(new BishopPiece(Color.WHITE, 84));
                        break;
                    case Piece.WHITE_KNIGHT:
                        button.setGraphic(new KnightPiece(Color.WHITE, 84));
                        break;
                    case Piece.WHITE_PAWN:
                        button.setGraphic(new PawnPiece(Color.WHITE, 84));
                        break;
                    case Piece.BLACK_KING:
                        button.setGraphic(new KingPiece(Color.BLACK, 84));
                        break;
                    case Piece.BLACK_QUEEN:
                        button.setGraphic(new QueenPiece(Color.BLACK, 84));
                        break;
                    case Piece.BLACK_ROOK:
                        button.setGraphic(new RookPiece(Color.BLACK, 84));
                        break;
                    case Piece.BLACK_BISHOP:
                        button.setGraphic(new BishopPiece(Color.BLACK, 84));
                        break;
                    case Piece.BLACK_KNIGHT:
                        button.setGraphic(new KnightPiece(Color.BLACK, 84));
                        break;
                    case Piece.BLACK_PAWN:
                        button.setGraphic(new PawnPiece(Color.BLACK, 84));
                        break;
                    case Piece.None:
                        button.setGraphic(new NoPiece(Color.WHITE, 84));
                        break;
                    default:
                        break;
                }
            }
        }
    }
    private ImageView createPieceImageView(int piece){
        ImageView imageView = new ImageView();
        switch(piece){
            case Piece.WHITE_KING:
                imageView.setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\White\\whiteKing.png"));
                break;
            case Piece.WHITE_QUEEN:
                imageView.setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\White\\whiteQueen.png"));
                break;
            case Piece.WHITE_ROOK:
                imageView.setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\White\\whiteRook.png"));
                break;
            case Piece.WHITE_BISHOP:
                imageView.setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\White\\whiteBishop.png"));
                break;
            case Piece.WHITE_KNIGHT:
                imageView.setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\White\\whiteHorse.png"));
                break;
            case Piece.WHITE_PAWN:
                imageView.setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\White\\whitePawn.png"));
                break;
            case Piece.BLACK_KING:
                imageView.setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\Black\\blackKing.png"));
                break;
            case Piece.BLACK_QUEEN:
                imageView.setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\Black\\blackQueen.png"));
                break;
            case Piece.BLACK_ROOK:
                imageView.setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\Black\\blackRook.png"));
                break;
            case Piece.BLACK_BISHOP:
                imageView.setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\Black\\blackBishop.png"));
                break;
            case Piece.BLACK_KNIGHT:
                imageView.setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\Black\\blackHorse.png"));
                break;
            case Piece.BLACK_PAWN:
                imageView.setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\Black\\blackPawn.png"));
                break;
            default:
                imageView.setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\White\\noPiece.png"));
                break;
        }
        imageView.setFitWidth(84);
        imageView.setFitHeight(84);

        return imageView;
    }
}
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import javafx.scene.input.*;
import java.awt.*;

public class ChessboardInitializer {
    final private String fenString;
    private int[][] chessboard;
    private Button[][] chessBoardButtons;


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

                button.setGraphic(switch (piece) {
                    case Piece.WHITE_KING -> new KingPiece(Color.WHITE, 84);
                    case Piece.WHITE_QUEEN -> new QueenPiece(Color.WHITE, 84);
                    case Piece.WHITE_ROOK -> new RookPiece(Color.WHITE, 84);
                    case Piece.WHITE_BISHOP -> new BishopPiece(Color.WHITE, 84);
                    case Piece.WHITE_KNIGHT -> new KnightPiece(Color.WHITE, 84);
                    case Piece.WHITE_PAWN -> new PawnPiece(Color.WHITE, 84);
                    case Piece.BLACK_KING -> new KingPiece(Color.BLACK, 84);
                    case Piece.BLACK_QUEEN -> new QueenPiece(Color.BLACK, 84);
                    case Piece.BLACK_ROOK -> new RookPiece(Color.BLACK, 84);
                    case Piece.BLACK_BISHOP -> new BishopPiece(Color.BLACK, 84);
                    case Piece.BLACK_KNIGHT -> new KnightPiece(Color.BLACK, 84);
                    case Piece.BLACK_PAWN -> new PawnPiece(Color.BLACK, 84);
                    case Piece.None -> new NoPiece(Color.WHITE, 84);
                    default -> null;
                });
            }
        }
    }
    private ImageView createPieceImageView(int piece) {
        ImageView imageView = new ImageView();
        String basePath = "/ChessSprites/";
        String imagePath = switch(piece) {
            case Piece.WHITE_KING -> basePath + "White/whiteKing.png";
            case Piece.WHITE_QUEEN -> basePath + "White/whiteQueen.png";
            case Piece.WHITE_ROOK -> basePath + "White/whiteRook.png";
            case Piece.WHITE_BISHOP -> basePath + "White/whiteBishop.png";
            case Piece.WHITE_KNIGHT -> basePath + "White/whiteHorse.png";
            case Piece.WHITE_PAWN -> basePath + "White/whitePawn.png";
            case Piece.BLACK_KING -> basePath + "Black/blackKing.png";
            case Piece.BLACK_QUEEN -> basePath + "Black/blackQueen.png";
            case Piece.BLACK_ROOK -> basePath + "Black/blackRook.png";
            case Piece.BLACK_BISHOP -> basePath + "Black/blackBishop.png";
            case Piece.BLACK_KNIGHT -> basePath + "Black/blackHorse.png";
            case Piece.BLACK_PAWN -> basePath + "Black/blackPawn.png";
            default -> basePath + "White/noPiece.png";
        };

        imageView.setImage(new Image(imagePath));
        imageView.setFitWidth(84);
        imageView.setFitHeight(84);

        return imageView;
    }
}
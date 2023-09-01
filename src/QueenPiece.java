import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class QueenPiece extends ImageView{
    private Color color;



    public QueenPiece(Color color, double size){
        this.color = color;

        if (color == Color.WHITE) {
            setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\White\\whiteQueen.png"));
        } else if (color == Color.BLACK) {
            setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\Black\\blackQueen.png"));
        }
        setFitWidth(size);
        setFitHeight(size);
    }
    //methods and behaviors of queen here
}

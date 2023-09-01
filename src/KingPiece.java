import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.*;

public class KingPiece extends ImageView{
    private Color color;

    public KingPiece(Color color, double size) {
        this.color = color;

        if (color == Color.WHITE) {
            setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\White\\whiteKing.png"));
        } else if (color == Color.BLACK){
            setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\Black\\blackKing.png"));
        }
setFitWidth(size);
        setFitHeight(size);
    }
    //put methods and behaviors of this piece here
}




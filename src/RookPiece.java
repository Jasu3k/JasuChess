import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.*;

public class RookPiece extends ImageView{
    private Color color;

    public RookPiece(Color color, double size){
        this.color = color;

        if(color == Color.WHITE){
            setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\White\\whiteRook.png"));
        } else if(color == Color.BLACK){
            setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\Black\\blackRook.png"));
        }
        setFitWidth(size);
        setFitHeight(size);
    }
    //behavior methods here
}


import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;

        import java.awt.*;

public class NoPiece extends ImageView {
    private Color color;

    public NoPiece(Color color, double size) {
        this.color = color;

        if (color == Color.WHITE) {
            setImage(new javafx.scene.image.Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\White\\noPiece.png"));
        } else if (color == Color.BLACK){
            setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\White\\noPiece.png"));
        }
        setFitWidth(size);
        setFitHeight(size);
    }
    //put methods and behaviors of this piece here
}


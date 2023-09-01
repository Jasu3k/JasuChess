import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class KnightPiece extends ImageView {

    private Color color;

    public KnightPiece(Color color, double size) {
        this.color = color;

        if (color == Color.WHITE) {
            setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\White\\whiteHorse.png"));
        } else if (color == Color.BLACK) {
            setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\Black\\blackHorse.png"));
        }
        setFitWidth(size);
        setFitHeight(size);
    }
    //set behavior methods here
}

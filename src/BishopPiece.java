import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class BishopPiece extends ImageView {
    private Color color;

    public BishopPiece(Color color, double size) {
        this.color = color;

        if(color == Color.WHITE){
            setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\White\\whiteBishop.png"));
        } else if(color == Color.BLACK){
            setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\Black\\blackBishop.png"));
        }
        setFitWidth(size);
        setFitHeight(size);
    }
}

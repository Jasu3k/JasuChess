import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

import java.io.InputStream;

public class KingPiece extends ImageView{
    private Color color;

    public KingPiece(Color color, double size) {
        if (color == Color.WHITE) {
            // Define the relative path to the white pawn image
            String relativePath = "assets/White/whiteKing.png";

            // Load the image using a class loader
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(relativePath);
            if (inputStream != null) {
                Image image = new Image(inputStream);
                setImage(image);
            } else {
                // Handle the case where the resource could not be found
                System.err.println("Image not found: " + relativePath);
            }
        } else if (color == Color.BLACK) {
            // Define the relative path to the black pawn image
            String relativePath = "assets/Black/blackKing.png";

            // Load the image using a class loader
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(relativePath);
            if (inputStream != null) {
                Image image = new Image(inputStream);
                setImage(image);
            } else {
                // Handle the case where the resource could not be found
                System.err.println("Image not found: " + relativePath);
            }
        }
setFitWidth(size);
        setFitHeight(size);
    }
    //put methods and behaviors of this piece here
}




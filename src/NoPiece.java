import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.*;
import java.io.InputStream;

public class NoPiece extends ImageView {
    private Color color;

    public NoPiece(Color color, double size) {
            // Define the relative path to the white pawn image
            String relativePath = "assets/White/noPiece.png";

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(relativePath);
            if (inputStream != null) {
                Image image = new Image(inputStream);
                setImage(image);
            } else {
                // Handle the case where the resource could not be found
                System.err.println("Image not found: " + relativePath);
            }

        setFitWidth(size);
        setFitHeight(size);
    }
    //put methods and behaviors of this piece here
}


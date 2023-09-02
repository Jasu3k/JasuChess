import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.*;

public class PawnPiece extends ImageView{
    private Color color;

    public PawnPiece(Color color, double size){

        if (color == Color.WHITE) {
            // Define the relative path to the white pawn image
            String relativePath = "assets/White/whitePawn.png";

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
            String relativePath = "assets/Black/blackPawn.png";

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
        /*this.color = color;
        String projectRoot = "JasuChess\\";

        if(color == Color.WHITE) {
            Path relativePath = Paths.get(projectRoot, "src", "assets", "White", "whitePawn.png");
            System.out.println(relativePath);
            setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\White\\whitePawn.png"));
        } else if(color == Color.BLACK){
            setImage(new Image("C:\\Users\\jassa\\OneDrive\\Desktop\\Jasu\\JasuProjects\\JavaChess\\ChessSprites\\Black\\blackPawn.png"));
        }*/
        setFitWidth(size);
        setFitHeight(size);
    }
    //behavior methods here
}

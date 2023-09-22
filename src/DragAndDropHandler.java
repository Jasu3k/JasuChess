import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;

import java.awt.*;

public class DragAndDropHandler {
    private ImageView piece;
    private Button[][] chessBoardButtons;
    private int initialRow;
    public void handleDragDetected(MouseEvent event) {
        Dragboard dragboard = piece.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();

        Image originalImage = piece.getImage();

        // Create a new image with the desired dimensions
        Image resizedImage = new Image("C:\\Users\\jassa\\OneDrive\\Documents\\GitHub\\JasuChess\\src\\assets\\White\\whitePawn.png", 84, 84, true, true);

        ImageView imageView = new ImageView(resizedImage);

        content.putImage(imageView.getImage());
        dragboard.setContent(content);

        event.consume();
    }


    private int initialCol;
    public DragAndDropHandler(ImageView piece, Button[][] chessBoardButtons) {
        this.piece = piece;
        this.chessBoardButtons = chessBoardButtons;
    }

    public void handleDragOver(DragEvent event) {
        if (event.getGestureSource() != piece && event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.MOVE);
        }

        event.consume();
    }

    public void handleDragEntered(DragEvent event) {
        if (event.getGestureSource() != piece && event.getDragboard().hasImage()) {
            Button targetButton = (Button) event.getSource();
            targetButton.setStyle("-fx-background-color: purple;");
        }

        event.consume();
    }

    public void handleDragExited(DragEvent event) {
        if (event.getGestureSource() != piece && event.getDragboard().hasImage()) {
            // Remove visual feedback from the target location
            // For example, restore the original background color of the target button
            Button targetButton = (Button) event.getSource();
            int targetRow = GridPane.getRowIndex(targetButton);
            int targetCol = GridPane.getColumnIndex(targetButton);

            if ((targetRow + targetCol) % 2 == 0) {
                targetButton.setStyle("-fx-background-color: #EDBC8C;");
            } else {
                targetButton.setStyle("-fx-background-color: #70350B;");
            }
        }

        event.consume();
    }

    public void handleDragDropped(DragEvent event) {
        boolean success = false;
        Button clickedButton = (Button) event.getSource();
        clickedButton.setGraphic(new NoPiece(Color.WHITE, 84));

        event.setDropCompleted(success);
        event.consume();
    }

    public void handleDragDone(DragEvent event) {
        event.consume();
    }
}

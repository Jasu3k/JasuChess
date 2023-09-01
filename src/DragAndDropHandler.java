import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;

public class DragAndDropHandler {
    private ImageView piece;
    private Button[][] chessBoardButtons;
    private int initialRow;
    private int initialCol;

    public DragAndDropHandler(ImageView piece, Button[][] chessBoardButtons) {
        this.piece = piece;
        this.chessBoardButtons = chessBoardButtons;

        piece.setOnMousePressed(event -> {
            initialRow = GridPane.getRowIndex(piece);
            initialCol = GridPane.getColumnIndex(piece);

            Dragboard dragboard = piece.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putImage(piece.getImage());
            dragboard.setContent(content);

            event.consume();
        });
        piece.setOnDragDetected(event -> {

            Dragboard dragboard = piece.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putImage(piece.getImage());
            dragboard.setContent(content);

            event.consume();


        });

        piece.setOnDragDone(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.consume();
            }
        });
    }
    public void handleDragDetected(MouseEvent event) {
        Dragboard dragboard = piece.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        content.putImage(piece.getImage());
        dragboard.setContent(content);

        event.consume();
    }

    public void handleDragOver(DragEvent event) {
        if (event.getGestureSource() != piece && event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.MOVE);
        }

        event.consume();
    }

    public void handleDragEntered(DragEvent event) {
        if (event.getGestureSource() != piece && event.getDragboard().hasImage()) {
            // Apply visual feedback to indicate the target location
            // For example, change the background color of the target button
            Button targetButton = (Button) event.getSource();
            targetButton.setStyle("-fx-background-color: lightblue;");
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
        Dragboard dragboard = event.getDragboard();
        boolean success = false;

        if (dragboard.hasImage()) {
            Button targetButton = (Button) event.getSource();
            int targetRow = GridPane.getRowIndex(targetButton);
            int targetCol = GridPane.getColumnIndex(targetButton);

            // Implement your logic to handle the dropped piece at the target location
            // For example, update the chessboard data structure and move the piece visually
            // You can access the initial row and column from the instance variables

            success = true;
        }

        event.setDropCompleted(success);
        event.consume();
    }

    public void handleDragDone(DragEvent event) {
        // Perform any necessary cleanup or additional logic after the drag operation is done
        event.consume();
    }
}








        /*piece.setOnDragDone(event -> {
            event.consume();
        });
    }

}

/*  piece.setOnMousePressed(event -> {
            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();

            Dragboard dragboard = piece.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putImage(piece.getImage());
            dragboard.setContent(content);

            event.consume();
        }); */
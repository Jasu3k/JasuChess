//importing for javafx GUI
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.Node;

import java.awt.*;

//extends javafx application
public class Main extends Application {
    Scene scene, scene2;
    Button button;
    
    public static void main(String[] args) {

        launch(args);
    }

    //typed "start" to get the next 2 lines
    @Override
    public void start(Stage primaryStage) throws Exception {
        //title of entire stage
        primaryStage.setTitle("Chess! by Jas");

        //initiates the button
        button = new Button();
        //puts text on the button
        button.setText("Play Chess");

        //handle user click button
        button.setOnAction(e -> {
            //switch to scene2 with chessboard on it
            primaryStage.setScene(scene2);
        });



        BorderPane layout = new BorderPane();
        layout.setCenter(button);



        //creates a scene and how big it is
        Scene scene = new Scene(layout, 300, 250);
        //uses the scene for our main window
        primaryStage.setScene(scene);
        //shows the scene to the user
        primaryStage.show();



        Button[][] chessBoardButtons = new Button[8][8];
        ChessboardInitializer initializer = new ChessboardInitializer("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", chessBoardButtons);
        initializer.initializeChessboard();
        GridPane grid = new GridPane();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Button button = chessBoardButtons[row][col];
                button.setPrefSize(100, 100);
                if ((row + col) % 2 == 0) {
                    button.setStyle("-fx-background-color: #EDBC8C;");
                } else {
                    button.setStyle("-fx-background-color: #70350B");
                }
                grid.add(button, col, row);

                //Attach drag and drop handler to button?
                Node graphicNode = button.getGraphic();
                if (graphicNode instanceof ImageView pieceImageView) {
                    button.setGraphic(pieceImageView);
                    DragAndDropHandler dragAndDropHandler = new DragAndDropHandler(pieceImageView, chessBoardButtons);
                    button.setOnDragDetected(dragAndDropHandler:: handleDragDetected);
                    button.setOnDragOver(dragAndDropHandler::handleDragOver);
                    button.setOnDragEntered(dragAndDropHandler::handleDragEntered);
                    button.setOnDragExited(dragAndDropHandler::handleDragExited);
                    button.setOnDragDropped(dragAndDropHandler::handleDragDropped);
                    button.setOnDragDone(dragAndDropHandler::handleDragDone);
                }
                button.setOnDragDropped(event -> {
                    Dragboard dragboard = event.getDragboard();
                    boolean success = false;

                    if (dragboard.hasImage()) {
                        // Get the target button where the piece is being dropped
                        Button targetButton = (Button) event.getSource();

                        // Get the target row and column
                        int targetRow = GridPane.getRowIndex(targetButton);
                        int targetCol = GridPane.getColumnIndex(targetButton);

                        // Perform your logic to handle the dropped piece at the target location
                        // ...
                        ImageView pieceImageView = new ImageView(dragboard.getImage());
                        targetButton.setGraphic(pieceImageView);

                        success = true;
                    }

                    event.setDropCompleted(success);
                    event.consume();
                });


            }
        }

        grid.setAlignment(Pos.CENTER);

        BorderPane layout2 = new BorderPane();
        layout2.setCenter(grid);
        scene2 = new Scene(layout2, 800, 800);

    }
}

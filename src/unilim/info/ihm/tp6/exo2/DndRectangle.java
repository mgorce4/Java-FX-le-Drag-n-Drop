package unilim.info.ihm.tp6.exo2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import unilim.info.ihm.tp6.exo2.controller.DndRectangleController;

public class DndRectangle extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Création du groupe racine
        Group root = new Group();

        // Création des rectangles
        Rectangle rectangle1 = new Rectangle(150, 100, Color.BLUE);
        rectangle1.setX(50);
        rectangle1.setY(100);

        Rectangle rectangle2 = new Rectangle(150, 100, Color.GREEN);
        rectangle2.setX(300);
        rectangle2.setY(200);

        // Ajout des rectangles au groupe racine
        root.getChildren().addAll(rectangle1, rectangle2);

        // Configuration de la scène et de la fenêtre
        Scene scene = new Scene(root, 500, 350);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Drag and Drop avec Rectangles");
        primaryStage.show();

        // Gestion du Drag and Drop
        DndRectangleController.manageSourceDragAndDrop(rectangle1);
        DndRectangleController.manageSourceDragAndDrop(rectangle2);
        DndRectangleController.manageTargetDragAndDrop(rectangle1);
        DndRectangleController.manageTargetDragAndDrop(rectangle2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

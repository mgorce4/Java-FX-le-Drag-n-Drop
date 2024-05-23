package unilim.info.ihm.tp6.exo1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import unilim.info.ihm.tp6.exo1.controller.DndTextController;

public class DndTextRectangle extends Application {

    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception {
        // Création du groupe racine
        Group root = new Group();

        // Création des textes
        Text sourceText = new Text("DRAG ME");
        sourceText.setX(50);
        sourceText.setY(50);

        Text targetText = new Text("DROP HERE");
        targetText.setX(300);
        targetText.setY(50);

        // Ajout des textes au groupe racine
        root.getChildren().addAll(sourceText, targetText);

        // Configuration de la scène et de la fenêtre
        Scene scene = new Scene(root, 400, 100);
        scene.setFill(Color.LIGHTGREEN);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Etude du mécanisme de drag and drop");
        primaryStage.show();

        // Gestion du Drag and Drop
        DndTextController.manageSourceDragAndDrop(sourceText);
        DndTextController.manageTargetDragAndDrop(targetText);
    }

    public static void main(String[] args) {
        launch(args);
    }

	
}


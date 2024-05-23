package unilim.info.ihm.tp6.exo2.controller;

import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DndRectangleController {

    public static void manageSourceDragAndDrop(Rectangle source) {
        // Écouteur d'événement DRAG_DETECTED
        source.setOnDragDetected(event -> {
            // Création d'un objet ClipboardContent avec la couleur source
            ClipboardContent content = new ClipboardContent();
            content.putString(source.getFill().toString());
            Dragboard dragboard = source.startDragAndDrop(TransferMode.ANY);
            dragboard.setContent(content);
            event.consume();
        });

        // Écouteur d'événement DRAG_DONE (traité en dernier)
        source.setOnDragDone(event -> {
            // Vérification si un drop a eu lieu
            if (event.getTransferMode() == TransferMode.MOVE) {
                // Nettoyer la source si le déplacement a eu lieu
                source.setFill(Color.TRANSPARENT);
            }
            event.consume();
        });
    }

    public static void manageTargetDragAndDrop(Rectangle target) {
        // Écouteur d'événement DRAG_OVER
        target.setOnDragOver(event -> {
            if (event.getGestureSource() != target && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        // Écouteur d'événement DRAG_ENTERED
        target.setOnDragEntered(event -> {
            if (event.getGestureSource() != target && event.getDragboard().hasString()) {
                target.setOpacity(0.7);
            }
            event.consume();
        });

        // Écouteur d'événement DRAG_EXITED
        target.setOnDragExited(event -> {
            target.setOpacity(1.0);
            event.consume();
        });

        // Écouteur d'événement DRAG_DROPPED
        target.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            boolean success = false;
            if (dragboard.hasString()) {
                // Récupérer la couleur déposée
                Color droppedColor = Color.valueOf(dragboard.getString());
                // Sauvegarder la couleur actuelle de la cible
                Color targetColor = (Color) target.getFill();
                // Changer la couleur de la cible
                target.setFill(droppedColor);
                // Changer la couleur de la source
                ((Rectangle) event.getGestureSource()).setFill(targetColor);
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
        });
    }
}

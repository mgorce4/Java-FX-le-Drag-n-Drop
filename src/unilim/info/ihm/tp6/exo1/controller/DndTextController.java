package unilim.info.ihm.tp6.exo1.controller;

import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;

public class DndTextController {

    public static void manageSourceDragAndDrop(Text source) {
        // Écouteur d'événement DRAG_DETECTED
        source.setOnDragDetected(event -> {
            // Création d'un objet ClipboardContent avec le texte source
            ClipboardContent content = new ClipboardContent();
            content.putString(source.getText());
            Dragboard dragboard = source.startDragAndDrop(TransferMode.ANY);
            dragboard.setContent(content);
        });

        // Écouteur d'événement DRAG_DONE (traité en dernier)
        source.setOnDragDone(event -> {
            // Vérification si un drop a eu lieu
            if (event.getEventType() == DragEvent.DRAG_DROPPED) {
                // Récupération du texte déposé (correction)
                String droppedText = event.getDragboard().getString();

                // Mise à jour du texte source et du texte cible
                source.setText("");
                ((Text) event.getTarget()).setText(droppedText);
            }
        });
    }

    public static void manageTargetDragAndDrop(Text target) {
        // Écouteur d'événement DRAG_OVER
        target.setOnDragOver(event -> {
            // Autorisation du dépôt si le contenu est du texte
            if (event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.ANY);
            }
        });

        // Écouteur d'événement DRAG_ENTERED
        target.setOnDragEntered(event -> {
            // Changement de l'apparence de la cible pour indiquer le survol
            target.setStyle("-fx-background-color: #ccc");
        });

        // Écouteur d'événement DRAG_EXITED
        target.setOnDragExited(event -> {
            // Restauration de l'apparence par défaut de la cible
            target.setStyle("-fx-background-color: #fff");
        });

        // Écouteur d'événement DRAG_DROPPED
        target.setOnDragDropped(event -> {
            // Récupération du texte déposé (correction)
            String droppedText = event.getDragboard().getString();

            // Mise à jour du texte cible
            target.setText(droppedText);

            // Restauration de l'apparence par défaut de la cible
            target.setStyle("-fx-background-color: #fff");
        });
    }
}

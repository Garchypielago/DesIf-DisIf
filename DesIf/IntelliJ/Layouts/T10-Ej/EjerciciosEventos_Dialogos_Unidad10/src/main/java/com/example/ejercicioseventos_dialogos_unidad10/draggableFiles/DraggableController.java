package com.example.ejercicioseventos_dialogos_unidad10.draggableFiles;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;

import java.io.File;

public class DraggableController {
    @FXML private Label sourceLabel, destinationLabel;
    @FXML private Pane dropPane;

    public void initialize() {
        // 1. Arrastrar texto
        sourceLabel.setOnDragDetected(e -> {
            Dragboard db = sourceLabel.startDragAndDrop(TransferMode.COPY);
            ClipboardContent content = new ClipboardContent();
            content.putString(sourceLabel.getText());
            db.setContent(content);
            e.consume();
        });

        destinationLabel.setOnDragOver(e -> {
            if (e.getGestureSource() != destinationLabel && e.getDragboard().hasString()) {
                e.acceptTransferModes(TransferMode.COPY);
            }
            e.consume();
        });

        destinationLabel.setOnDragDropped(e -> {
            Dragboard db = e.getDragboard();
            boolean ok = false;
            if (db.hasString()) {
                destinationLabel.setText(db.getString());
                sourceLabel.setText("Operación drag terminada");
                ok = true;
            }
            e.setDropCompleted(ok);
            e.consume();

            sourceLabel.setOnDragDetected(null);
        });

        // 2. Arrastrar imagen desde el explorador
        dropPane.setOnDragOver(e -> {
            if (e.getGestureSource() != dropPane && e.getDragboard().hasFiles()) {
                e.acceptTransferModes(TransferMode.COPY);
            }
            e.consume();
        });

        dropPane.setOnDragDropped(e -> {
            Dragboard db = e.getDragboard();
            boolean ok = false;
            if (db.hasFiles()) {
                File f = db.getFiles().get(0);
                Image img = new Image(f.toURI().toString());
                ImageView iv = new ImageView(img);
                iv.setFitWidth(dropPane.getWidth());
                iv.setFitHeight(dropPane.getHeight());
                iv.setPreserveRatio(true);
                dropPane.getChildren().setAll(iv);
                ok = true;
            }
            e.setDropCompleted(ok);
            e.consume();
        });
    }
}
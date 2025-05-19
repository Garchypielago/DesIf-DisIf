package com.example.ejercicioseventos_dialogos_unidad10.pagination;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class PaginationController {
    @FXML private Pagination pagination;
    @FXML private ProgressBar progress;

    private final String[] items = {
            "Juan","María","Pedro","Ana","Luis",
            "Sofía","Miguel","Laura","Carlos","Elena",
            "Javier","Marta","David","Lucía","José",
            "Carmen","Alberto","Isabel"
    };

    public void initialize() {
        int total = items.length;
        int pages = (int) Math.ceil(total/5.0);
        pagination.setPageCount(pages);
        pagination.setPageFactory(this::createPage);
        pagination.currentPageIndexProperty().addListener((obs, old, idx) -> {
            progress.setProgress((idx.intValue()+1)/(double)pages);
        });
    }

    private VBox createPage(int pageIndex) {
        VBox box = new VBox(5);
        int start = pageIndex * 5;
        for (int i = 0; i < 5 && start + i < items.length; i++) {
            box.getChildren().add(new Label((start + i + 1) + ". " + items[start + i]));
        }
        return box;
    }
}
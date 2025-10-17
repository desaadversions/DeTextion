package com.detextion.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import com.detextion.services.DocumentService;

import java.io.File;

public class MainController {
    @FXML
    private Label labelStatus;

    @FXML
    private Button buttonUpload;

    private final DocumentService documentService = new DocumentService();

    @FXML
    public void initialize() {
        labelStatus.setText("Welcome to DeTextion!");
    }

    @FXML
    public void onUploadClicked() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select PDF to Extract Text");
        File file = chooser.showOpenDialog(null);
        if (file != null) {
            String extractedText = documentService.extractTextFromPDF(file);
            labelStatus.setText("Extracted " + extractedText.length() + " characters from PDF.");
        }
    }
}


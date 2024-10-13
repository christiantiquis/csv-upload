package com.example.csv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.csv.model.LogFile;
import com.example.csv.service.CSVService;

@Controller
public class CSVController {

    @Autowired
    private CSVService csvService;

    @GetMapping("/")
    public String redirectToUpload() {
        return "redirect:/upload"; // Redirect to the upload page
    }
    
    @GetMapping("/upload")
    public String showUploadForm() {
        return "uploadForm"; // This will render the Thymeleaf upload form
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        boolean isProcessed = csvService.processCSV(file);

        // Adding feedback for the user
        if (isProcessed) {
            model.addAttribute("message", "CSV data uploaded and processed successfully!");
        } else {
            model.addAttribute("message", "Failed to upload and process CSV data!");
        }

        return "uploadStatus"; // Redirect to status page
    }
    
    @GetMapping("/logs")
    public String listEntities(Model model) {
        List<LogFile> logFiles = csvService.findAllEntities(); // Fetch all entities from the database
        model.addAttribute("logs", logFiles); // Add the list to the model
        return "logs"; // Return the Thymeleaf template name
    }
}

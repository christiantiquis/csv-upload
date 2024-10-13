package com.example.csv.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.csv.model.LogFile;
import com.example.csv.repository.CSVRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class CSVService {

	@Autowired
    private CSVRepository repository;

    public boolean processCSV(MultipartFile file) {
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            String[] nextRecord;
            
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");


            while ((nextRecord = csvReader.readNext()) != null) {
                LogFile entity = new LogFile();
                entity.setEmployee_id(nextRecord[1]);
                entity.setName(nextRecord[2]);
                try {
                	entity.setDate(LocalDate.parse(nextRecord[3], dateFormatter));
                } catch (DateTimeParseException e) {
                	e.printStackTrace();
                }
                try {
                	entity.setTime(LocalTime.parse(nextRecord[4], timeFormatter));
                } catch (DateTimeParseException e) {
                	e.printStackTrace();
                }
                
//                entity.setTime(LocalTime.parse(nextRecord[4]));
                entity.setLocation(nextRecord[5]);

                repository.save(entity); // Save to H2 database
            }
            return true;
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<LogFile> findAllEntities() {
        return repository.findAll();
    }
}

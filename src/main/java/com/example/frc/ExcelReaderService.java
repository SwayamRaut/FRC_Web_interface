package com.example.frc;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelReaderService {
    public List<ExcelData> readTeamsFromExcelFile(String filePath) throws IOException {
        List<ExcelData> teams = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row headerRow = sheet.getRow(0);

        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
                ExcelData entity = new ExcelData();

                // Iterate over cells and set values in the entity object
                for (int cellIndex = 0; cellIndex < headerRow.getLastCellNum(); cellIndex++) {
                    Cell cell = row.getCell(cellIndex, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    if (cell != null) {
                        String header = headerRow.getCell(cellIndex).getStringCellValue();
                        switch (header) {
                            case "team_number":
                                entity.setTeam_number((int) cell.getNumericCellValue());
                                break;
                            case "autonomous_skills":
                                entity.setAutonomous_skills((byte) cell.getNumericCellValue());
                                break;
                            case "success_throws_speaker_r1":
                                entity.setSuccess_throws_speaker_r1((int) cell.getNumericCellValue());
                                break;
                            case "success_throws_amplifier_r1":
                                entity.setSuccess_throws_amplifier_r1((int) cell.getNumericCellValue());
                                break;
                            case "violence_level":
                                entity.setViolence_level((byte) cell.getNumericCellValue());
                                break;
                            case "overall_performance":
                                entity.setOverall_performance(cell.getStringCellValue());
                                break;
                            case "success_throws_speaker_r2":
                                entity.setSuccess_throws_speaker_r2((int) cell.getNumericCellValue());
                                break;
                            case "success_throws_amplifier_r2":
                                entity.setSuccess_throws_amplifier_r2((int) cell.getNumericCellValue());
                                break;
                            case "amp_counter":
                                entity.setAmp_counter((int) cell.getNumericCellValue());
                                break;
                            case "climbing_ability":
                                entity.setClimbing_ability((byte) cell.getNumericCellValue());
                                break;
                            case "success_throws_speaker_r3":
                                entity.setSuccess_throws_speaker_r3((int) cell.getNumericCellValue());
                                break;
                            case "harmonize_counter":
                                entity.setHarmonize_counter((int) cell.getNumericCellValue());
                                break;
                            case "total_success_humanthrows":
                                entity.setTotal_success_humanthrows((int) cell.getNumericCellValue());
                                break;
                        }
                    }
                }

                teams.add(entity);
            }
        }

        workbook.close();
        fileInputStream.close();

        return teams;
    }



}

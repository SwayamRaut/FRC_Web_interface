package com.example.frc;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MainController {
    //importing data from excel
    @Autowired
    private ExcelReaderService excelReaderService;
    @Autowired
    private TeamRepository teamRepository;
    @GetMapping("/upload")
    public String importDataFromExcel(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "No file uploaded";
        }
        try {
            Path tempFilePath = Files.createTempFile("uploaded_file", ".xlsx");
            Files.copy(file.getInputStream(), tempFilePath, StandardCopyOption.REPLACE_EXISTING);

            excelReaderService.readTeamsFromExcelFile(tempFilePath.toString());
            return "File sent for further processing.";

        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to receive uploaded file";
        }

    }

    //Restful endpoints for CRUD operations.
    @GetMapping("/teams")
    public List<ExcelData> getAllTeams() {
        return teamRepository.findAll();
    }

    //I have not used this endpoint
    @GetMapping("/teams/{team_number}")
    public Optional<ExcelData> getTeamByteam_number(@PathVariable int team_number) {
        return teamRepository.findById(team_number);
    }


    //I have not used this endpoint
    @PutMapping("/teams/{id}")
    public ExcelData updateTeam(@PathVariable int team_number, @RequestBody ExcelData updatedTeam) {
        return teamRepository.findById(team_number)
                .map(team -> {
                    team.setTeam_number(updatedTeam.getTeam_number());
                    team.setHarmonize_counter(updatedTeam.getHarmonize_counter());
                    team.setTotal_success_humanthrows(updatedTeam.getTotal_success_humanthrows());
                    team.setClimbing_ability(updatedTeam.getClimbing_ability());
                    team.setAmp_counter(updatedTeam.getAmp_counter());
                    team.setAutonomous_skills(updatedTeam.getAutonomous_skills());
                    team.setSuccess_throws_speaker_r3(updatedTeam.getSuccess_throws_speaker_r3());
                    team.setSuccess_throws_amplifier_r1(updatedTeam.getSuccess_throws_amplifier_r1());
                    team.setSuccess_throws_amplifier_r2(updatedTeam.getSuccess_throws_amplifier_r2());
                    team.setViolence_level(updatedTeam.getViolence_level());
                    team.setSuccess_throws_speaker_r2(updatedTeam.getSuccess_throws_speaker_r2());
                    team.setOverall_performance(updatedTeam.getOverall_performance());
                    team.setSuccess_throws_speaker_r1(updatedTeam.getSuccess_throws_speaker_r1());
                    return teamRepository.save(team);
                })
                .orElseGet(() -> {
                    updatedTeam.setTeam_number(team_number);
                    return teamRepository.save(updatedTeam);
                });
    }

    //Searching and sorting
    @GetMapping("/search")
    public List<ExcelData> searchByTeamNumberAndSort(
            @RequestParam int team_number,
            @RequestParam(required = false) String sortByAutonomous_skills,
            @RequestParam(required = false) String sortBySuccess_throws_speaker_r1,
            @RequestParam(required = false) String sortBySuccess_throws_speaker_r2,
            @RequestParam(required = false) String sortBySuccess_throws_speaker_r3) {

        Sort sort = Sort.unsorted();

        if(sortByAutonomous_skills != null) {
            sort = sort.and(Sort.by(sortByAutonomous_skills));
        }
        if(sortBySuccess_throws_speaker_r1 != null) {
            sort = sort.and(Sort.by(sortBySuccess_throws_speaker_r1));
        }
        if(sortBySuccess_throws_speaker_r2 != null) {
            sort = sort.and(Sort.by(sortBySuccess_throws_speaker_r2));
        }
        if(sortBySuccess_throws_speaker_r3 != null) {
            sort = sort.and(Sort.by(sortBySuccess_throws_speaker_r3));
        }

        return teamRepository.findByTeam_number(team_number, sort);


    }





}

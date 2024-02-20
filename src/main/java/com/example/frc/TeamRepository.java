package com.example.frc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.domain.Sort;

@Repository
public interface TeamRepository extends JpaRepository<ExcelData, Integer>{
    //additional custom query methods are defined here if needed
    List<ExcelData> findByTeam_number(int team_number, Sort sort);





}

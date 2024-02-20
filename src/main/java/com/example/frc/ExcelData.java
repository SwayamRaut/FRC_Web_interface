package com.example.frc;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ExcelData {
    @Id
    private int team_number;


    private byte autonomous_skills;
    private int success_throws_speaker_r1;
    private int success_throws_amplifier_r1;
    private byte violence_level;
    private String overall_performance;
    private int success_throws_speaker_r2;
    private int success_throws_amplifier_r2;
    private int amp_counter;
    private byte climbing_ability;
    private int success_throws_speaker_r3;
    private int harmonize_counter;
    private int total_success_humanthrows;

    public ExcelData(int team_number, byte autonomous_skills, int success_throws_speaker_r1, int success_throws_amplifier_r1, byte violence_level, String overall_performance, int success_throws_speaker_r2, int success_throws_amplifier_r2, int amp_counter, byte climbing_ability, int success_throws_speaker_r3, int harmonize_counter, int total_success_humanthrows) {
        this.team_number = team_number;
        this.autonomous_skills = autonomous_skills;
        this.success_throws_speaker_r1 = success_throws_speaker_r1;
        this.success_throws_amplifier_r1 = success_throws_amplifier_r1;
        this.violence_level = violence_level;
        this.overall_performance = overall_performance;
        this.success_throws_amplifier_r2 = success_throws_amplifier_r2;
        this.success_throws_speaker_r2 = success_throws_speaker_r2;
        this.amp_counter = amp_counter;
        this.climbing_ability = climbing_ability;
        this.harmonize_counter = harmonize_counter;
        this.success_throws_speaker_r3 = success_throws_speaker_r3;
        this.total_success_humanthrows = total_success_humanthrows;
    }

    //default constructor
    public ExcelData() {

    }
    //getters and setters
    public int getTeam_number() {
        return team_number;
    }

    public void setTeam_number(int team_number) {
        this.team_number = team_number;
    }

    public void setAutonomous_skills(byte autonomous_skills) {
        this.autonomous_skills = autonomous_skills;
    }
    public byte getAutonomous_skills() {
        return autonomous_skills;
    }
    public void setSuccess_throws_speaker_r1(int success_throws_speaker_r1) {
        this.success_throws_speaker_r1 = success_throws_speaker_r1;
    }

    public int getSuccess_throws_speaker_r1() {
        return success_throws_speaker_r1;
    }

    public int getSuccess_throws_amplifier_r1() {
        return success_throws_amplifier_r1;
    }

    public void setSuccess_throws_amplifier_r1(int success_throws_amplifier_r1) {
        this.success_throws_amplifier_r1 = success_throws_amplifier_r1;
    }

    public void setAmp_counter(int amp_counter) {
        this.amp_counter = amp_counter;
    }

    public int getAmp_counter() {
        return amp_counter;
    }

    public void setClimbing_ability(byte climbing_ability) {
        this.climbing_ability = climbing_ability;
    }

    public byte getClimbing_ability() {
        return climbing_ability;
    }

    public byte getViolence_level() {
        return violence_level;
    }

    public void setViolence_level(byte violence_level) {
        this.violence_level = violence_level;
    }

    public int getHarmonize_counter() {
        return harmonize_counter;
    }

    public void setHarmonize_counter(int harmonize_counter) {
        this.harmonize_counter = harmonize_counter;
    }

    public int getSuccess_throws_amplifier_r2() {
        return success_throws_amplifier_r2;
    }

    public void setSuccess_throws_amplifier_r2(int success_throws_amplifier_r2) {
        this.success_throws_amplifier_r2 = success_throws_amplifier_r2;
    }

    public int getSuccess_throws_speaker_r2() {
        return success_throws_speaker_r2;
    }

    public void setSuccess_throws_speaker_r2(int success_throws_speaker_r2) {
        this.success_throws_speaker_r2 = success_throws_speaker_r2;
    }

    public int getSuccess_throws_speaker_r3() {
        return success_throws_speaker_r3;
    }

    public void setSuccess_throws_speaker_r3(int success_throws_speaker_r3) {
        this.success_throws_speaker_r3 = success_throws_speaker_r3;
    }

    public int getTotal_success_humanthrows() {
        return total_success_humanthrows;
    }

    public void setTotal_success_humanthrows(int total_success_humanthrows) {
        this.total_success_humanthrows = total_success_humanthrows;
    }

    public String getOverall_performance() {
        return overall_performance;
    }

    public void setOverall_performance(String overall_performance) {
        this.overall_performance = overall_performance;
    }
















}

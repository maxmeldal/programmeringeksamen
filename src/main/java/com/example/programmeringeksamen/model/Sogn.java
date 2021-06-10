package com.example.programmeringeksamen.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Sogn {

    @Id
    private Long kode;

    private String navn;

    //OneToOne relationship
    @JsonManagedReference
    @OneToOne
    private Kommune kommune;

    private Double smittetryk;

    private LocalDate datoForNedlukning;

    public Sogn() {
    }

    public Sogn(Long kode, String navn, Double smittetryk, LocalDate datoForNedlukning) {
        this.kode = kode;
        this.navn = navn;
        this.smittetryk = smittetryk;
        this.datoForNedlukning = datoForNedlukning;
    }

    public Long getKode() {
        return kode;
    }

    public void setKode(Long kode) {
        this.kode = kode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Kommune getKommune() {
        return kommune;
    }

    public void setKommune(Kommune kommune) {
        this.kommune = kommune;
    }

    public Double getSmittetryk() {
        return smittetryk;
    }

    public void setSmittetryk(Double smittetryk) {
        this.smittetryk = smittetryk;
    }

    public LocalDate getDatoForNedlukning() {
        return datoForNedlukning;
    }

    public void setDatoForNedlukning(LocalDate datoForNedlukning) {
        this.datoForNedlukning = datoForNedlukning;
    }

    @Override
    public String toString() {
        return "Sogn{" +
                "Kode=" + kode +
                ", Navn='" + navn + '\'' +
                ", kommune=" + kommune +
                ", smittetryk=" + smittetryk +
                ", datoForNedlukning=" + datoForNedlukning +
                '}';
    }
}

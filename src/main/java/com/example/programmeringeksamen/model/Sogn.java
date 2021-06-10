package com.example.programmeringeksamen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Sogn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long kode;

    private String navn;

    //OneToOne relationship
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "kommune_id")
    private Kommune kommune;

    private Double positivProcent;

    //datetimeformatter makes so controller can retrieve html date format and create object
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datoForNedlukning;

    //constructor overload
    public Sogn() {
    }

    public Sogn(Long kode, String navn, Kommune kommune, Double positivProcent, LocalDate datoForNedlukning) {
        this.kode = kode;
        this.navn = navn;
        this.kommune = kommune;
        this.positivProcent = positivProcent;
        this.datoForNedlukning = datoForNedlukning;
    }

    //method to check if sogn currently is nedlukket
    public boolean getNedlukket(){
        return datoForNedlukning.isBefore(LocalDate.now());
    }

    //STANDARD GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Double getPositivProcent() {
        return positivProcent;
    }

    public void setPositivProcent(Double smittetryk) {
        this.positivProcent = smittetryk;
    }

    public LocalDate getDatoForNedlukning() {
        return datoForNedlukning;
    }

    public void setDatoForNedlukning(LocalDate datoForNedlukning) {
        this.datoForNedlukning = datoForNedlukning;
    }

    //STANDARD TOSTRING
    @Override
    public String toString() {
        return "Sogn{" +
                "id=" + id +
                ", kode=" + kode +
                ", navn='" + navn + '\'' +
                ", kommune=" + kommune +
                ", smittetryk=" + positivProcent +
                ", datoForNedlukning=" + datoForNedlukning +
                '}';
    }
}

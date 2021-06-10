package com.example.programmeringeksamen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Kommune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long kode;

    private String navn;

    //OneToOne relationship
    @JsonBackReference
    @OneToOne
    private Sogn sogn;

    public Kommune() {
    }

    public Kommune(Long kode, String navn, Sogn sogn) {
        this.kode = kode;
        this.navn = navn;
        this.sogn = sogn;
    }

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

    public Sogn getSogn() {
        return sogn;
    }

    public void setSogn(Sogn sogn) {
        this.sogn = sogn;
    }

    @Override
    public String toString() {
        return "Kommune{" +
                "id=" + id +
                ", kode=" + kode +
                ", navn='" + navn + '\'' +
                ", sogn=" + sogn +
                '}';
    }
}

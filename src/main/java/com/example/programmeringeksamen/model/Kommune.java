package com.example.programmeringeksamen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Kommune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long kode;

    private String navn;

    //OneToOne relationship
    @JsonManagedReference
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "kommune")
    private Set<Sogn> sogne;

    //constructor overload
    public Kommune() {
    }

    public Kommune(Long kode, String navn) {
        this.kode = kode;
        this.navn = navn;
    }

    //method returns average positivprocent of sogne
    public double getAveragePositivProcent(){
        double total=0;
        int count=0;
        for (Sogn sogn : sogne) {
            total += sogn.getPositivProcent();
            count++;
        }
        return total/count;
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

    public Set<Sogn> getSogne() {
        return sogne;
    }

    public void setSogne(Set<Sogn> sogns) {
        this.sogne = sogns;
    }

    //STANDARD TOSTRING
    @Override
    public String toString() {
        return "Kommune{" +
                "id=" + id +
                ", kode=" + kode +
                ", navn='" + navn + '\'' +
                ", sogns=" + sogne +
                '}';
    }
}

package com.example.programmeringeksamen.controller;

import com.example.programmeringeksamen.model.Kommune;
import com.example.programmeringeksamen.model.Sogn;
import com.example.programmeringeksamen.repository.KommuneRepository;
import com.example.programmeringeksamen.repository.SognRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class SognRestController {

    private SognRepository sognRepository;
    private KommuneRepository kommuneRepository;

    //Constructor injection
    public SognRestController(SognRepository sognRepository, KommuneRepository kommuneRepository) {
        this.sognRepository = sognRepository;
        this.kommuneRepository = kommuneRepository;
    }


    @GetMapping("/sogne")
    public ResponseEntity<Iterable<Sogn>> findAll(){
        //returns list of sogne and httpsstatus OK
        return ResponseEntity.status(HttpStatus.OK).body(sognRepository.findAll());
    }

    @GetMapping("/sogn/{kode}")
    public ResponseEntity<Optional<Sogn>> findBySogneKode(@PathVariable Long kode){

        //attempts to get sogn by idea and stores return value (sogn or nullobject) in optional
        Optional<Sogn> optionalSogn = sognRepository.findById(kode);

        //if object exists within optional, return said object with httpstatus OK
        if(optionalSogn.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalSogn);
        }
        //if object does not exist within optional, return null object with httpstatus not_found
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalSogn);
    }

    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @PostMapping(value = "/sogne", consumes = "application/json")
    public ResponseEntity<String> create (@RequestBody Sogn s){
        Sogn sogn = new Sogn(s.getKode(), s.getNavn(), s.getSmittetryk(), s.getDatoForNedlukning());
        sognRepository.save(sogn);

        Kommune kommune = s.getKommune();
        kommune.setSogn(sogn);
        kommuneRepository.save(kommune);

        sogn.setKommune(kommune);
        sognRepository.save(sogn);

        return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/sogn/" + sogn.getKode())
                .body("{'msg': 'Post Created'}");
    }

    @PutMapping("/sogn/{kode}")
    public ResponseEntity<String> update(@PathVariable("kode") Long kode, @RequestBody Sogn sogn){

        //get sogn to be updated
        Optional<Sogn> optionalSogn = sognRepository.findById(kode);

        //return not found if id doesn't exist
        if(!optionalSogn.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'sogn " + kode + " not found'");
        }

        //update sogn
        sognRepository.save(sogn);

        //return no content
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{'msg' : 'updated'}");
    }

    @DeleteMapping("/sogn/{kode}")
    public ResponseEntity<String> delete(@PathVariable("kode") Long kode){

        //get sogn
        Optional<Sogn> optionalSogn = sognRepository.findById(kode);

        //return not found if id doesn't exist
        if(!optionalSogn.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'sogn " + kode + " not found'");
        }

        //delete sogn
        sognRepository.deleteById(kode);

        //return status ok
        return ResponseEntity.status(HttpStatus.OK).body("{'msg' : 'deleted'}");
    }
}

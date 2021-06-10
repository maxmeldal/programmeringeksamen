package com.example.programmeringeksamen.service;

import com.example.programmeringeksamen.model.Kommune;
import com.example.programmeringeksamen.model.Sogn;
import com.example.programmeringeksamen.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KommuneService {

    @Autowired
    KommuneRepository kommuneRepository;

    //method returns kommuner in hashset instead of iterable
    public List<Kommune> findAll(){
        List<Kommune> kommuner = new ArrayList<>();
        for (Kommune kommune : kommuneRepository.findAll()) {
            kommuner.add(kommune);
        }
        return kommuner;
    }

    //method returns kommune object instead of optional
    public Kommune findById(Long id){
        Optional<Kommune> optionalKommune = kommuneRepository.findById(id);
        if (optionalKommune.isEmpty()){
            throw new RuntimeException("kommune " + id + " not found");
        }
        return optionalKommune.get();
    }

    public Kommune create(Kommune kommune){
        return kommuneRepository.save(kommune);
    }
}

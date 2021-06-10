package com.example.programmeringeksamen.service;

import com.example.programmeringeksamen.model.Sogn;
import com.example.programmeringeksamen.repository.SognRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SognService {

    @Autowired
    SognRepository sognRepository;

    //method returns sogne in hashset instead of iterable
    public List<Sogn> findAll(){
        List<Sogn> sogne = new ArrayList<>();
        for (Sogn sogn : sognRepository.findAll()) {
            sogne.add(sogn);
        }
        return sogne;
    }

    //method returns sogn object instead of optional
    public Sogn findById(Long id){
        Optional<Sogn> optionalSogn = sognRepository.findById(id);
        if (optionalSogn.isEmpty()){
            throw new RuntimeException("sogn " + id + " not found");
        }
        return optionalSogn.get();
    }

    public Sogn create(Sogn sogn){
        return sognRepository.save(sogn);
    }

    public Sogn update(Sogn sogn){
        //saves ids of all sogne in list
        List<Long> ids = new ArrayList<>();
        for (Sogn s:sognRepository.findAll()){
            ids.add(s.getId());
        }

        //if list of sogne ids does not contain the id of the updated sogn return exception
        if (!ids.contains(sogn.getId())){
            throw new RuntimeException("sogn " + sogn.getId() + " not found");
        }
        return sognRepository.save(sogn);
    }

    public void deleteById(Long id){
        sognRepository.deleteById(id);
    }
}

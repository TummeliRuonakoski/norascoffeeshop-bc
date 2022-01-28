package com.example.norascoffeeshop.service;

import java.util.List;

import com.example.norascoffeeshop.model.Maker;
import com.example.norascoffeeshop.repository.MakerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakerService {

    @Autowired
    private MakerRepository makerRepository;

    public List<Maker> listAll(){
        return makerRepository.findAll();
    }

    public Maker getEditor(Long id){
        return makerRepository.getById(id);
    }

    public void addMaker(String name, String url){
        Maker maker = new Maker();
        maker.setName(name);
        maker.setUrl(url);
        makerRepository.save(maker);
    }

    public void updateMaker(Long id, String name, String url){
        Maker maker = makerRepository.getById(id);
        maker.setName(name);
        maker.setUrl(url);
        makerRepository.save(maker);
    }
    public void deleteEditor(Long id){
        makerRepository.deleteById(id);
    }

    
}

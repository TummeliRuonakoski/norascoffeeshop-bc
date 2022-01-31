package com.example.norascoffeeshop.service;

import java.util.List;


import com.example.norascoffeeshop.model.Editor;
import com.example.norascoffeeshop.repository.EditorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorService {

    @Autowired
    private EditorRepository editorRepository;


    public List<Editor> listAll(){
        return editorRepository.findAll();
    }

    public Editor getEditor(Long id){
        return editorRepository.getById(id);
    }

    public void addEditor(String name, String contactperson, String contactpersonsEmail){
        Editor editor = new Editor();
        editor.setName(name);
        editor.setContactperson(contactperson);
        editor.getContactpersonsEmail();
        editorRepository.save(editor);
    }

    public void updateEditor(Long id, String name, String contactperson, String contactpersonsEmail){
        Editor editor = editorRepository.getById(id);
        editor.setName(name);
        editor.setContactperson(contactperson);
        editor.setContactpersonsEmail(contactpersonsEmail);
        editorRepository.save(editor);
    }
    public void deleteEditor(Long id){
        editorRepository.deleteById(id);
    }

    


}

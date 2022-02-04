package com.example.norascoffeeshop.controller;

import com.example.norascoffeeshop.service.EditorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditorController {

    @Autowired
    EditorService editorService;

    @GetMapping("admin/editor")
    public String getAllEditors(Model model){
        model.addAttribute("editors", this.editorService.listAll());
        return "admin";
    }

    @GetMapping("admin/editor/{id}")
    public String getEditor(@PathVariable Long id, Model model){
        model.addAttribute("editor", this.editorService.getEditor(id));
        return "editor";
    }

    @PostMapping("admin/editor")
    public String createEditor(@RequestParam String name, @RequestParam String contactperson, @RequestParam String contactpersonsEmail){
        this.editorService.addEditor(name, contactperson, contactpersonsEmail);
        return "redirect:/admin";
    }

    @PostMapping("admin/editor/{id}")
    public String updateEditor(@PathVariable Long id, @RequestParam String name, @RequestParam String contactperson, @RequestParam String contactpersonsEmail){
        this.editorService.updateEditor(id, name, contactperson, contactpersonsEmail);
        return "redirect:/editor";
    }

    @DeleteMapping("admin/editro/{id}")
    public String deleteEditor(@PathVariable Long id){
        this.editorService.deleteEditor(id);
        return "redirect:/admin";
    }


}

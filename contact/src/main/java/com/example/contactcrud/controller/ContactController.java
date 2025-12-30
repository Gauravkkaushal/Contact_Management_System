package com.example.contactcrud.controller;
import com.example.contactcrud.entity.Contact;
import com.example.contactcrud.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {
    private final ContactService service;
    public ContactController(ContactService service){this.service=service;}

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("contacts",service.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("contact",new Contact());
        return "add-contact";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Contact contact){
        service.save(contact);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        model.addAttribute("contact",service.findById(id));
        return "edit-contact";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/";
    }
}

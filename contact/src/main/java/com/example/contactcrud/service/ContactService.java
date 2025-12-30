package com.example.contactcrud.service;
import com.example.contactcrud.entity.Contact;
import com.example.contactcrud.repository.ContactRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactService {
    private final ContactRepository repo;
    public ContactService(ContactRepository repo){this.repo=repo;}
    public List<Contact> findAll(){return repo.findAll();}
    public void save(Contact c){repo.save(c);}
    public Contact findById(Long id){return repo.findById(id).orElseThrow();}
    public void delete(Long id){repo.deleteById(id);}
}

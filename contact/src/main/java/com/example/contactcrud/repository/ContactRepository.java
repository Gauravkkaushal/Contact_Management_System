package com.example.contactcrud.repository;
import com.example.contactcrud.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long>{}

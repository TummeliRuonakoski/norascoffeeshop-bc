package com.example.norascoffeeshop.service;

import java.util.List;


import com.example.norascoffeeshop.model.Supplier;
import com.example.norascoffeeshop.repository.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;


    public List<Supplier> listAll(){
        return supplierRepository.findAll();
    }

    public Supplier getSupplier(Long id){
        return supplierRepository.getById(id);
    }

    public void addSupplier(String name, String contactperson, String contactpersonsEmail){
        Supplier supplier = new Supplier();
        supplier.setName(name);
        supplier.setContactperson(contactperson);
        supplier.setContactpersonsEmail(contactpersonsEmail);
        supplierRepository.save(supplier);
    }

    public void updateSupplier(Long id, String name, String contactperson, String contactpersonsEmail){
        Supplier supplier = supplierRepository.getById(id);
        supplier.setName(name);
        supplier.setContactperson(contactperson);
        supplier.setContactpersonsEmail(contactpersonsEmail);
        supplierRepository.save(supplier);
    }
    public void deleteSupplier(Long id){
        supplierRepository.deleteById(id);
    }

}

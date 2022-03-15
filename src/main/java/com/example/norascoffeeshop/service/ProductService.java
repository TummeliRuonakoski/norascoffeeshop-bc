package com.example.norascoffeeshop.service;

import java.io.IOException;
import java.util.List;

import com.example.norascoffeeshop.model.Deparment;
import com.example.norascoffeeshop.model.Supplier;
import com.example.norascoffeeshop.model.Maker;
import com.example.norascoffeeshop.model.Product;
import com.example.norascoffeeshop.repository.DeparmentRepository;
import com.example.norascoffeeshop.repository.SupplierRepository;
import com.example.norascoffeeshop.repository.MakerRepository;
import com.example.norascoffeeshop.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired 
    private DeparmentRepository deparmentRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired 
    private MakerRepository makerRepository;


    public Page<Product> getAllProducts(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    public Page<Product> getProductPageable(int currentPage, int size) {
        PageRequest pageable = PageRequest.of(currentPage, size);
        return productRepository.findAll(pageable);
    }

    public List<Product> getByKeyword(String keyword){
        if(keyword != null){
            return productRepository.findByNameContainingIgnoreCase(keyword);
        }
        return productRepository.findAll();
    }

    public List<Product> getAllCoffeeMachines(List<Long> coffeemachines){
        List<Product> products = productRepository.findByDeparment_idIn(coffeemachines);
        return products;
    }

    public List<Product> getAllConsumeProducts(List<Long> consumerproducts){
        List<Product> products = productRepository.findByDeparment_idIn(consumerproducts);
        return products;
    }

    public List<Product> getAllCoffees(List<Long> coffees){
        List<Product> products = productRepository.findByDeparment_idIn(coffees);
        return products;
    }

    public List<Product> listAll(){
        return productRepository.findAll();
    }


    public Product getProduct(Long id){
        return productRepository.getById(id);
    }

    public void addProduct(String name, String description, Double price, Long deparmentId, Long supplierId, Long makerId, MultipartFile image) throws IOException {
        Deparment deparment = deparmentRepository.getById(deparmentId);
        Supplier supplier = supplierRepository.getById(supplierId);
        Maker maker = makerRepository.getById(makerId);
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setDeparment(deparment);
        product.setSupplier(supplier);
        product.setMaker(maker);
        product.setImage(image.getBytes());
        productRepository.save(product);
    }

    public void updateProduct(Long id, String name, String description, Double price,  Long deparmentId, Long supplierId, Long makerId, MultipartFile image) throws IOException {
        Product product = productRepository.getById(id);
        Deparment deparment = deparmentRepository.getById(deparmentId);
        Supplier supplier = supplierRepository.getById(supplierId);
        Maker maker = makerRepository.getById(makerId);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setDeparment(deparment);
        product.setSupplier(supplier);
        product.setMaker(maker);
        product.setImage(image.getBytes());
        productRepository.save(product);
    }
    
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
    
}

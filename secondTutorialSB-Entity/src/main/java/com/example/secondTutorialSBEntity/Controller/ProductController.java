package com.example.secondTutorialSBEntity.Controller;

import com.example.secondTutorialSBEntity.Model.Product;
import com.example.secondTutorialSBEntity.Repository.IproductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/**
 * 3
 *
 * This example is CRUD operations with Rest Api (just basic explaination)
 */
@RestController
@RequestMapping(name = "api/products")
public class ProductController {

    private Logger log = LoggerFactory.getLogger(ProductController.class);


    private IproductRepository iproductRepository;

    @Autowired
    public void IproductRepository(IproductRepository iproductRepository) {
        this.iproductRepository = iproductRepository;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Optional<Product> getProductById(@PathVariable(name = "id") Integer id) {
        return iproductRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product saveProduct(@RequestBody Product productsToSave) {
        return iproductRepository.save(productsToSave);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@RequestBody Product productToUpdate, @PathVariable(name = "id") Integer id)

    {
        //after that if nullpointer Exception comes  it will handle for ProductAdvicer
        Optional<Product> findProduct = iproductRepository.findById(id);
            findProduct.get().setCategory(productToUpdate.getCategory());
            findProduct.get().setDescription(productToUpdate.getDescription());
            findProduct.get().setPrice(productToUpdate.getPrice());
            findProduct.get().setName(productToUpdate.getName());
            return iproductRepository.save(findProduct.get());
    }

    @RequestMapping(path = "id", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(name = "id") Integer id) {

        iproductRepository.delete(iproductRepository.findById(id).get());
    }


}

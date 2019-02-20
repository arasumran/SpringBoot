package com.example.secondTutorialSBEntity.Repository;

import com.example.secondTutorialSBEntity.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**

  2

 */

@Repository
public interface IproductRepository extends JpaRepository<Product,Integer> {

     Product findByCategory(String category);
     Optional<Product> findById(Integer id);

     //you can add more custom CRUD operaitons as much as deleteByPrice , getByCategoryAndName etc.

}

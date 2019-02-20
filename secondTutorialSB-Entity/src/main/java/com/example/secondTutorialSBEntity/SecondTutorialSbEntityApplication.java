package com.example.secondTutorialSBEntity;

import com.example.secondTutorialSBEntity.Model.Product;
import com.example.secondTutorialSBEntity.Repository.IproductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SecondTutorialSbEntityApplication implements CommandLineRunner {

	private IproductRepository iproductRepository;
	private Logger log = LoggerFactory.getLogger(SecondTutorialSbEntityApplication.class);

	@Autowired
	public void setIproductRepository(IproductRepository iproductRepository) {
		this.iproductRepository = iproductRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SecondTutorialSbEntityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//  save new product to db
		Product p1 = new Product();
		p1.setName("Test 1 Product Name");
		p1.setDescription("This is Test DEsc for Product");
		p1.setCategory("CUSTOM");
		p1.setPrice(0.1);
		iproductRepository.save(p1);
		Product p2 = new Product();
		p2.setName("Test 2 Product");
		p2.setDescription("Test 2 Desc Product");
		p2.setCategory("GENERAL");
		p2.setPrice(0.3);
		iproductRepository.save(p2);


		// find any product by spesific column

		List<Product> products = (List<Product>) iproductRepository.findAll();

		products.forEach(p ->log.info(p.toString()));


		//this is custom type pf CRUD Repository
		Product px = iproductRepository.findByCategory("GENERAL");
		log.info(px.toString());


		// as you can see below log show all products
		/*
		Hibernate: select product0_.id as id1_0_, product0_.category as category2_0_, product0_.description as descript3_0_, product0_.name as name4_0_, product0_.price as price5_0_ from product product0_
		2019-02-20 17:21:22.823  INFO 16642 --- [           main] c.e.s.SecondTutorialSbEntityApplication  : Product{id=1, name='Test 1 Product Name', category='CUSTOM', description='This is Test DEsc for Product', price=0.1}
		2019-02-20 17:21:22.824  INFO 16642 --- [           main] c.e.s.SecondTutorialSbEntityApplication  : Product{id=2, name='Test 2 Product', category='GENERAL', description='Test 2 Desc Product', price=0.3}
		*/



	}
}

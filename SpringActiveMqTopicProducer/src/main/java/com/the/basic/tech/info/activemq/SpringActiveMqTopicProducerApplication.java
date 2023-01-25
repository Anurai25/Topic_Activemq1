package com.the.basic.tech.info.activemq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.the.basic.tech.info.activemq.jms.JmsPublisher;
import com.the.basic.tech.info.activemq.models.Company;
import com.the.basic.tech.info.activemq.models.Product;

@SpringBootApplication
public class SpringActiveMqTopicProducerApplication implements CommandLineRunner {

	@Autowired
	JmsPublisher publisher;

	public static void main(String[] args) {
		SpringApplication.run(SpringActiveMqTopicProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Apple company & products
		 */
		// initial company and products
		Product iphone7 = new Product("Iphone 7");
		Product iPadPro = new Product("IPadPro");

		List<Product> appleProducts = new ArrayList<Product>(Arrays.asList(iphone7, iPadPro));

		Company apple = new Company("Apple", appleProducts);

		// send message to ActiveMQ
		publisher.send(apple);

		/*
		 * Samsung company and products
		 */
		Product galaxyS8 = new Product("Galaxy S8");
		Product gearS3 = new Product("Gear S3");

		List<Product> samsungProducts = new ArrayList<Product>(Arrays.asList(galaxyS8, gearS3));

		Company samsung = new Company("Samsung", samsungProducts);

		/*
		 * send message to ActiveMQ
		 */
		publisher.send(samsung);
	}
}

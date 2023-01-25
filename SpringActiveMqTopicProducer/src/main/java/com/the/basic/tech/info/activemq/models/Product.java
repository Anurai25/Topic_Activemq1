package com.the.basic.tech.info.activemq.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
 @Data
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Product.class)
public class Product {
    private String name;
    
    private Company company;
	
    public Product(){
    }
    
    public Product(String name){
    	this.name = name;
    }
    
    public Product(String name, Company company){
    	this.name = name;
    	this.company = company;
    }
     
}
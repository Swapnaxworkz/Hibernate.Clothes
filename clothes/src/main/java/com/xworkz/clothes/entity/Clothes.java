package com.xworkz.clothes.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clothes")
public class Clothes {
	
	@Id
	private int id;
	private String brand;
	private double price;
	@Column(name ="manufatcuredDate")
    private Date date;

}

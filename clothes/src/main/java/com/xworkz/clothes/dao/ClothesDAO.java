package com.xworkz.clothes.dao;

import java.util.Date;

import com.xworkz.clothes.entity.Clothes;


public interface ClothesDAO {

public void insertClothes(Clothes cloth);
	
	public ClothesDAO getClothesById(Integer id);
	
	public void updateDateById(Date date, Integer id);
	
	public void deleteClothesById(Integer id);


}

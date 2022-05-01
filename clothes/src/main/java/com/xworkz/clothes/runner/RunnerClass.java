package com.xworkz.clothes.runner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.xworkz.clothes.dao.ClothesDAOImpl;
import com.xworkz.clothes.entity.Clothes;

public class RunnerClass {

	public static void main(String[] args) {
		Clothes clothes = new Clothes();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date date;
		try {
			date = (Date) simpleDateFormat.parse("2022-06-03");
			clothes.setDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clothes.setId(5);
		clothes.setBrand("PUMA");
		clothes.setPrice(750.00);
		ClothesDAOImpl daoImpl = new ClothesDAOImpl();
		// daoImpl.insertClothes(clothes);
		// System.out.println("Saved Successfully....");

		// daoImpl.getClothesById(4);
		/*
		 * try { date = simpleDateFormat.parse("2021-01-01");
		 * daoImpl.updateDateById(date, 4);
		 * System.out.println("Updated Successfully..."); } catch (ParseException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } }
		 */
		daoImpl.deleteClothesById(4);
		System.out.println("Deleted Successfully..");

	}
}

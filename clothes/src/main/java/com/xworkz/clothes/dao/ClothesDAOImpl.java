package com.xworkz.clothes.dao;

import java.util.Date;


import com.xworkz.clothes.entity.Clothes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ClothesDAOImpl implements ClothesDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("clothes");
	EntityManager manager = null;
	EntityTransaction tx = null;
	Clothes clothes = null;
	Date date;

	@Override
	public void insertClothes(Clothes cloth) {
		try {
			manager = factory.createEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(cloth);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}

	}

	@Override
	public Clothes getClothesById(Integer id) {
		manager = factory.createEntityManager();
		clothes = manager.find(Clothes.class, id);
		if (clothes != null) {
			System.out.println(clothes.toString());
		} else {
			System.out.println("Record Not Found");
		}

		return clothes;
	}

	@Override
	public void updateDateById(Date date, Integer id) {
		try {
		manager=factory.createEntityManager();
		clothes=manager.find(Clothes.class, id);
		if (clothes!=null) {
			tx=manager.getTransaction();
			tx.begin();
			clothes.setDate(date);
			manager.merge(clothes);
			tx.commit();
		}else {
			System.out.println("Record Not Found..");
		}
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			if (manager!=null) {
				manager.close();
			}
		}
	}

	@Override
	public void deleteClothesById(Integer id) {
		try {
			manager=factory.createEntityManager();
			clothes = manager.find(Clothes.class, id);
			if (clothes!=null) {
				tx=manager.getTransaction();
				tx.begin();
				manager.remove(clothes);
				tx.commit();
			} else {
				System.out.println("Records Not Found");

			}
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			if (manager!=null) {
				manager.close();
			}
		}
	}
}
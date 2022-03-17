package com.sda.hibernate.zadanie;

import com.sda.hibernate.dao.GenericDao;
import com.sda.hibernate.dao.GenericDaoImpl;
import com.sda.hibernate.dao.UserCriteriaDao;
import com.sda.hibernate.dao.UserCriteriaDaoImpl;
import com.sda.hibernate.model.Product;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        UserCriteriaDao criteriaDao = new UserCriteriaDaoImpl();
        criteriaDao.findAllByCountryAlias("PL").forEach(System.out::println);
        criteriaDao
                .findAllBornBetween(
                        LocalDate.of(1970, 1, 1),
                        LocalDate.of(2020, 1, 1)
                ).forEach(System.out::println);
        GenericDao<Product> productDao = new GenericDaoImpl<>(Product.class);

        System.out.println("all who bought");
        criteriaDao.findAllWhoBoughtProduct(productDao.findById(4))
                .forEach(System.out::println);

        System.out.println("hql");
        criteriaDao.findAllWhoBoughtProduct(productDao.findById(4))
                .forEach(System.out::println);

    }
}

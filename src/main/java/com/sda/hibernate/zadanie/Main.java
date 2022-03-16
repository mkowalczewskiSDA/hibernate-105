package com.sda.hibernate.zadanie;

import com.sda.hibernate.dao.UserCriteriaDao;
import com.sda.hibernate.dao.UserCriteriaDaoImpl;

public class Main {
    public static void main(String[] args) {
        UserCriteriaDao criteriaDao = new UserCriteriaDaoImpl();
        criteriaDao.findAllByCountryAlias("PL").forEach(System.out::println);

    }
}

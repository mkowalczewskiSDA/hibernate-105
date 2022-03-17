package com.sda.hibernate.zadanie;

import com.sda.hibernate.dao.UserCriteriaDao;
import com.sda.hibernate.dao.UserCriteriaDaoImpl;

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

    }
}

package com.sda.hibernate.dao;

import com.sda.hibernate.model.User;

import java.time.LocalDate;
import java.util.List;

public interface UserCriteriaDao {

    List<User> findUserWhereLastNameContains(String s);
    List<User> findAllByCountryAlias(String alias);
    List<User> findAllBornBetween(LocalDate date1, LocalDate date2);

}

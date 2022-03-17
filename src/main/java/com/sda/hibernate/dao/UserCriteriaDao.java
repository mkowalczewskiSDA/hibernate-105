package com.sda.hibernate.dao;

import com.sda.hibernate.model.Product;
import com.sda.hibernate.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface UserCriteriaDao {

    List<User> findUserWhereLastNameContains(String s);
    List<User> findAllByCountryAlias(String alias);
    List<User> findAllBornBetween(LocalDate date1, LocalDate date2);
    //join
    //List<User> findAllWhoBoughtProduct(Product product);
    //join
    //List<User> findAllWhoBoughtProductHql(Product product);
    List<User> findAllWithOrdersMoreExpensiveThan(double price);

}

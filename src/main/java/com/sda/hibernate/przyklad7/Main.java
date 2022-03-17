package com.sda.hibernate.przyklad7;

import com.sda.hibernate.model.User;
import com.sda.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityGraph;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        EntityGraph entityGraph = session.createEntityGraph("user-address");
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", entityGraph);
        User user = session.find(User.class, 1, properties);
        Query query = session.createQuery("")
                .setHint("javax.persistence.fetchgraph", entityGraph);
        //User user = session.find(User.class, 1);
        session.close();
        System.out.println("test");
    }
}

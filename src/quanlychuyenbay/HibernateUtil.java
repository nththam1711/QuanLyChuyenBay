/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlychuyenbay;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import quanlychuyenbay.pojo.ChuyenBay;
import quanlychuyenbay.pojo.MayBay;

/**
 *
 * @author thamt
 */
public class HibernateUtil {
    private static SessionFactory factory;
    
    static {
        Configuration configure = new Configuration();
        configure.addAnnotatedClass(ChuyenBay.class);
        configure.addAnnotatedClass(MayBay.class);
        configure.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configure.getProperties());
        factory = configure.buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}

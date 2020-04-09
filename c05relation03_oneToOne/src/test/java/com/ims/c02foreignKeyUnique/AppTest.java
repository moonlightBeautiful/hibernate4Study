package com.ims.c02foreignKeyUnique;

import com.ims.model.c02foreignKeyUnique.Passport2;
import com.ims.model.c02foreignKeyUnique.People2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private Session session;

    @Before
    public void setUp() throws Exception {
        // 实例化配置文件
        Configuration configuration = new Configuration().configure();
        // 实例化注册服务
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        // 获取Session工厂
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        // 获取Session
        session = sessionFactory.openSession();
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }


    @Test
    public void test() {
        session.beginTransaction();

        People2 people2 = new People2();
        people2.setName("李四");
        Passport2 passport2 = new Passport2();
        passport2.setName("护照2");
        passport2.setPeople2(people2);
        people2.setPassport2(passport2);
        session.save(people2);

        session.getTransaction().commit();
    }
}

package com.ims.c01sharedPrimaryKey;

import static org.junit.Assert.assertTrue;

import com.ims.model.c01sharedPrimaryKey.Passport1;
import com.ims.model.c01sharedPrimaryKey.People1;
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

        People1 people1 = new People1();
        people1.setName("张三");
        Passport1 passport1 = new Passport1();
        passport1.setName("张三护照");
        passport1.setPeople1(people1);
        people1.setPassport1(passport1);
        session.save(people1);

        session.getTransaction().commit();
    }
}

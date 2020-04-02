package com.ims.c03;

import com.ims.model.c02fatherTableAndChildrenTables.Animal2;
import com.ims.model.c02fatherTableAndChildrenTables.Cat2;
import com.ims.model.c02fatherTableAndChildrenTables.Dog2;
import com.ims.model.c03childrenTables.Animal3;
import com.ims.model.c03childrenTables.Cat3;
import com.ims.model.c03childrenTables.Dog3;
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

    /**
     * 多字表
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        session.beginTransaction();

        Animal3 animal = new Animal3();
        animal.setName("动物");
        session.save(animal);

        Cat3 cat1 = new Cat3();
        cat1.setName("猫1");
        cat1.setLength(11.00);
        session.save(cat1);

        Cat3 cat2 = new Cat3();
        cat2.setName("猫2");
        cat2.setLength(22.00);
        session.save(cat2);

        Dog3 dog1 = new Dog3();
        dog1.setName("狗1");
        dog1.setWeight(11.00);
        session.save(dog1);

        Dog3 dog2 = new Dog3();
        dog2.setName("狗2");
        dog2.setWeight(22.00);
        session.save(dog2);

        session.getTransaction().commit();
    }
}

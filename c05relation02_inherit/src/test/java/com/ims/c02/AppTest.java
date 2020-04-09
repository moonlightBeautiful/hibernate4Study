package com.ims.c02;

import com.ims.model.c01singleTable.Animal1;
import com.ims.model.c01singleTable.Cat1;
import com.ims.model.c01singleTable.Dog1;
import com.ims.model.c02fatherTableAndChildrenTables.Animal2;
import com.ims.model.c02fatherTableAndChildrenTables.Cat2;
import com.ims.model.c02fatherTableAndChildrenTables.Dog2;
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
     * 单表继承，测试生成的表和数据
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        session.beginTransaction();

        Animal2 animal = new Animal2();
        animal.setName("动物");
        session.save(animal);

        Cat2 cat1 = new Cat2();
        cat1.setName("猫1");
        cat1.setLength(11.00);
        session.save(cat1);

        Cat2 cat2 = new Cat2();
        cat2.setName("猫2");
        cat2.setLength(22.00);
        session.save(cat2);

        Dog2 dog1 = new Dog2();
        dog1.setName("狗1");
        dog1.setWeight(11.00);
        session.save(dog1);

        Dog2 dog2 = new Dog2();
        dog2.setName("狗2");
        dog2.setWeight(22.00);
        session.save(dog2);

        session.getTransaction().commit();
    }
}

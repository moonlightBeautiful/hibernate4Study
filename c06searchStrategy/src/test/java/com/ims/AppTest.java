package com.ims;

import com.ims.model.City;
import com.ims.model.Province;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void save()  {
        session.beginTransaction(); // 开启事务

        City city1 = new City();
        city1.setName("临沂");
        session.save(city1);

        City city2 = new City();
        city2.setName("济南");
        session.save(city2);

        City city3 = new City();
        city3.setName("菏泽");
        session.save(city3);

        Province province = new Province();
        province.setName("山东");
        province.getCities().add(city1);
        province.getCities().add(city2);
        province.getCities().add(city3);
        session.save(province);

        session.getTransaction().commit(); // 提交事务
    }

    @Test
    public void get(){
        session.beginTransaction(); // 开启事务


        session.getTransaction().commit(); // 提交事务
    }

}

package com.ims.c02singleWayOneToMany;

import com.ims.model.c02singleWayOneToMany.City;
import com.ims.model.c02singleWayOneToMany.Province;
import com.ims.model.c03twoWayOneToMany.Company;
import com.ims.model.c03twoWayOneToMany.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

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
    public void save() throws IOException, ParseException {
        session.beginTransaction(); // 开启事务

        City city1 = new City();
        city1.setName("临沂");
        // session.save(city);      //如果不设置级联保存，则不预先session缓存中保存city，会报错
        City city2 = new City();
        city2.setName("青岛");

        Province province = new Province();
        province.setName("山东");
        province.getCities().add(city1);
        province.getCities().add(city2);
        session.save(province);


        session.getTransaction().commit(); // 提交事务
    }


}

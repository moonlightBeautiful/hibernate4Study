package com.ims.c03twoWayOneToMany;

import com.ims.model.c01singleWayManyToOne.School;
import com.ims.model.c01singleWayManyToOne.Student;
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

        Employee employee1 = new Employee();
        employee1.setName("张三");
        Employee employee2 = new Employee();
        employee2.setName("李四");
        //session.save(employee1);
        //session.save(employee2);
        Company company = new Company();
        company.setName("神软");
        company.getEmployees().add(employee1);
        company.getEmployees().add(employee2);
        session.save(company);

        session.getTransaction().commit(); // 提交事务
    }

    @Test
    public void get() throws IOException, ParseException {
        session.beginTransaction(); // 开启事务



        session.getTransaction().commit(); // 提交事务
    }

}

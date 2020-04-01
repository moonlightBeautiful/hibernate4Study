package com.ims.c01singleWayManyToOne;

import com.ims.model.c01singleWayManyToOne.School;
import com.ims.model.c01singleWayManyToOne.Student;
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

        School school = new School();
        school.setName("临沂一中");
        session.save(school);       //默认不会级联保存

        Student student1 = new Student();
        student1.setName("张三");
        student1.setSchool(school);

        Student student2 = new Student();
        student2.setName("李四");
        student2.setSchool(school);

        session.save(student1);
        session.save(student2);

        session.getTransaction().commit(); // 提交事务
    }

    @Test
    public void get() throws IOException, ParseException {
        session.beginTransaction(); // 开启事务

        Student student = (Student) session.get(Student.class, Long.valueOf(3));
        School school = student.getSchool();
        System.out.println(school);

        session.getTransaction().commit(); // 提交事务
    }

}

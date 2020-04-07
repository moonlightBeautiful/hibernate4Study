package com.ims.c02twoWayManyToMany;

import com.ims.model.c01singleWayManyToMany.Course1;
import com.ims.model.c01singleWayManyToMany.Student1;
import com.ims.model.c02twoWayManyToMany.Course2;
import com.ims.model.c02twoWayManyToMany.Student2;
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
    public void save() {
        session.beginTransaction();

        Course2 course1 = new Course2();
        course1.setName("课程1");

        Course2 course2 = new Course2();
        course2.setName("课程2");

        Student2 student1 = new Student2();
        student1.setName("学生1");
        student1.getCourses().add(course1);
        student1.getCourses().add(course2);

        Student2 student2 = new Student2();
        student2.setName("学生2");
        student2.getCourses().add(course1);
        student2.getCourses().add(course2);

        session.save(student1);
        session.save(student2);

        session.getTransaction().commit();
    }
}

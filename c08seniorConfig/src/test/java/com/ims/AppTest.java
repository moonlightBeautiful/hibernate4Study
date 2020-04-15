package com.ims;

import com.ims.model.Student;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private SessionFactory sessionFactory;
    private Session session;
    private Logger logger = Logger.getLogger(AppTest.class);

    @Before
    public void setUp() throws Exception {
        // 实例化配置文件
        Configuration configuration = new Configuration().configure();
        // 实例化注册服务
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        // 获取Session工厂
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * 查
     */
    @Test
    public void testLog() {
        // 获取Session
        session = sessionFactory.openSession();
        // 开启事务
        session.beginTransaction();

        Student student = new Student();
        student.setName("张三");
        session.save(student);

        logger.debug("这是一个debug信息");
        logger.info("这是一个info信息");
        logger.error("这是一个错误信息");

        // 提交事务
        session.getTransaction().commit();
        session.close();
    }

    /**
     * 二级缓存测试 无 2条sql 有 1条sql
     */
    @Test
    public void testEhcache() {
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        Student student1 = (Student) session1.get(Student.class, Long.valueOf(1));
        System.out.println(student1);
        session1.getTransaction().commit();
        session1.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        Student student2 = (Student) session2.get(Student.class, Long.valueOf(1));
        System.out.println(student2);
        session2.getTransaction().commit();
        session2.close();

        System.out.println(student1 == student2);
    }
}

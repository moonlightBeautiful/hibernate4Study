package com.ims;

import com.ims.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    public void initTables() {
        System.out.println("根据实体类映射文件创建表成功。");
    }

    @Test
    public void addTest() {
        session.beginTransaction(); // 开启事务

        Student user = new Student();
        user.setName("赵四");
        session.save(user);

        session.getTransaction().commit(); // 提交事务
    }

    @Test
    public void deleteTest() {
        session.beginTransaction(); // 开启事务

        Student user = (Student) session.get(Student.class, Long.valueOf(1));
        session.delete(user);

        session.getTransaction().commit(); // 提交事务
    }

    @Test
    public void updateTest() {
        session.beginTransaction(); // 开启事务

        Student user = (Student) session.get(Student.class, Long.valueOf(2));
        user.setName("奔驰");
        session.update(user);  // = session.save(car); 效果一样

        session.getTransaction().commit(); // 提交事务
    }

    @Test
    public void getAllTest() {
        session.beginTransaction(); // 开启事务

        //通过hql查询
        //String hql = "from User where id = 1";
        String hql = "from Student";
        Query query = session.createQuery(hql);
        List<Student> users = query.list();
        for (Student user : users) {
            System.out.println(user);
        }
        session.getTransaction().commit(); // 查询不用提交事务
    }

    @Test
    public void getOneTest() {
        session.beginTransaction(); // 开启事务

        Student user = (Student) session.get(Student.class, Long.valueOf(2));
        System.out.println(user);

        session.getTransaction().commit(); // 查询不用提交事务
    }
}

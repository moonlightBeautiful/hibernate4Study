package com.ims;

import com.ims.model.Student;
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


public class AppTestC01Sql {

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
        // 开启事务
        session.beginTransaction();
    }

    @After
    public void tearDown() throws Exception {
        session.getTransaction().commit(); // 提交事务
        session.close();
    }

    /**
     * 增删改
     */
    @Test
    public void excuteBySql() {
        /**
         * 增
         */
        /*String sql = "insert c07_t_student values(null,?);";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter(0,"李四");
        int result = query.executeUpdate();
        System.out.println(result);*/

        /**
         * 删
         */
       /* String sql = "delete from c07_t_student where stuId = :stuId";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("stuId",3);
        int result = query.executeUpdate();
        System.out.println(result);*/

        /**
         * 改
         */
        String sql = "update c07_t_student set name = :name where stuId = :stuId";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("stuId", 2);
        query.setParameter("name", "王五");
        int result = query.executeUpdate();
        System.out.println(result);
    }

    /**
     * 查
     */
    @Test
    public void queryBySql() {
        /**
         * 查
         */
        String sql = "select * from c07_t_student";
        /*SQLQuery query = session.createSQLQuery(sql);
        List<Object> list = query.list();*/
        SQLQuery query = session.createSQLQuery(sql);
        List<Student> list = query.addEntity(Student.class).list();
        for(Student student : list){
            System.out.println(student);
        }
    }
}

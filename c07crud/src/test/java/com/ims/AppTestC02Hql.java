package com.ims;

import com.ims.model.Student;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;


public class AppTestC02Hql {

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
    public void excuteByHql() {
        /**
         * 增 Hibernate没有对插入做insert实现，使用save因为Hibernate的
         * HQL语言是用于面向对象实现查询功能的,然而在插入操作中是不会牵涉任何查询动作的,所以HQL不能用于insert语句的插入操作
         */
        ;
        /**
         * 删  delete from Student as p where p.id=?
         */
       /* String hql = "delete Student as p where p.id=?";
        Query query=session.createQuery(hql);
        query.setInteger(0,2);
        query.executeUpdate();*/

        /**
         * 改
         */
        String hql = "update Student as p set p.name = ? where p.id=?";
        Query query = session.createQuery(hql);
        query.setString(0, "高旭");
        query.setInteger(1, 4);
        query.executeUpdate();

    }


    /**
     * 查  可以省略 select
     */
    @Test
    public void query() {
        /**
         * 普通查询：from class
         */
       /* String sql = "from Student";
        Query query = session.createQuery(sql);
        List<Student> list = query.list();
        for(Student student : list){
            System.out.println(student);
        }*/

        /**
         * 带条件查询：from class where name=:name
         */
       /* String sql = "from Student where name=:name";
        Query query = session.createQuery(sql);
        query.setParameter("name","李四");
        List<Student> list = query.list();
        for(Student student : list){
            System.out.println(student);
        }*/

        /**
         * 使用别名：from class as 别名 where name=:name
         */
       /* String sql = "from Student as s where s.name=:name";
        Query query = session.createQuery(sql);
        query.setParameter("name","李四");
        List<Student> list = query.list();
        for(Student student : list){
            System.out.println(student);
        }*/

        /**
         * 结果排序：from class order by name desc
         */
       /* String sql = "from Student order by name asc";
        Query query = session.createQuery(sql);
        List<Student> list = query.list();
        for(Student student : list){
            System.out.println(student);
        }*/

        /**
         * 分页查询：query.setFirstResult(1);
         *           query.setMaxResults(1);
         */
       /* String sql = "from Student order by name asc";
        Query query = session.createQuery(sql);
        List<Student> list = query.list();
        for(Student student : list){
            System.out.println(student);
        }
        query.setFirstResult(1);
        query.setMaxResults(1);
        list = query.list();
        for(Student student : list){
            System.out.println(student);
        }*/

        /**
         * 单个对象查询：from class order by name desc
         */
        /*String sql = "from Student as s where s.name=:name";
        Query query = session.createQuery(sql);
        query.setParameter("name", "李四");
        Student student = (Student) query.uniqueResult();
        System.out.println(student);*/

        /**
         * 链式写法
         */
        String hql = "from Student as s where s.name=:name";
        Query query=session.createQuery(hql);
        List<Student> studentList=(List<Student>)query.setString("name", "高旭").list();
        Iterator it=studentList.iterator();
        while(it.hasNext()){
            Student s=(Student)it.next();
            System.out.println(s);
        }		;
    }
}

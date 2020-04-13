package com.ims;

import com.ims.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;


public class AppTestC03Qbc {

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
    public void excuteByQbc() {
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
         * 普通查询：session.createCriteria(Student.class)
         */
        /*Criteria criteria = session.createCriteria(Student.class);
        List<Student> studentList = criteria.list();
        Iterator it = studentList.iterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            System.out.println(s);
        }*/

        /**
         * 带条件查询：Restrictions
         */
       /* Criteria criteria=session.createCriteria(Student.class);
        Criterion c1= Restrictions.like("name", "高%");
        //Criterion c2=Restrictions.eq("age", 10);
        criteria.add(c1);
        //criteria.add(c2);
        List<Student> studentList=criteria.list();
        Iterator it=studentList.iterator();
        while(it.hasNext()){
            Student s=(Student)it.next();
            System.out.println(s);
        }*/
        /**
         * 结果排序：.addOrder(Order.desc("age"))
         */
        /*Criteria criteria=session.createCriteria(Student.class);
        criteria.addOrder(Order.desc("id"));
        List<Student> studentList=criteria.list();
        Iterator it=studentList.iterator();
        while(it.hasNext()){
            Student s=(Student)it.next();
            System.out.println(s);
        }*/

        /**
         * 分页查询：criteria.setFirstResult(1);
         *           criteria.setMaxResults(1);
         */
       /* Criteria criteria=session.createCriteria(Student.class);
        criteria.setFirstResult(1);
        criteria.setMaxResults(1);
        List<Student> studentList=criteria.list();
        Iterator it=studentList.iterator();
        while(it.hasNext()){
            Student s=(Student)it.next();
            System.out.println(s);
        }*/

        /**
         * 单个对象查询：criteria.uniqueResult()
         */
       /* Criteria criteria=session.createCriteria(Student.class);
        criteria.setFirstResult(0);
        criteria.setMaxResults(1);
        Student student=(Student)criteria.uniqueResult();
        System.out.println(student);*/

        /**
         * 链式写法
         */
        Criteria criteria = session.createCriteria(Student.class);
        List<Student> studentList = criteria.setFirstResult(0).setMaxResults(2).list();
        Iterator it = studentList.iterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            System.out.println(s);
        }
    }
}

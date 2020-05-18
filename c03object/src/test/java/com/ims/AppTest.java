package com.ims;

import com.ims.model.User;
import org.hibernate.Query;
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
    public void initTables() {
        System.out.println("创建表成功");
    }

    @Test
    public void addTest() {
        session.beginTransaction(); // 开启事务

        User user = new User();
        user.setName("赵四");
        session.save(user);

        session.getTransaction().commit(); // 提交事务
    }

    @Test
    public void objectOidTest() {
        session.beginTransaction(); // 开启事务

        User car1 = (User) session.get(User.class, Long.valueOf(2));
        User car2 = (User) session.get(User.class, Long.valueOf(2));
        User car3 = (User) session.get(User.class, Long.valueOf(3));
        System.out.println("主键相同，则指向session缓存中同一个缓存对象：" + (car1 == car2));
        System.out.println("主键不同，则指向session缓存中不同的缓存对象：" + (car1 == car3));

        session.getTransaction().commit();  // 提交事务
    }

    @Test
    public void transientTest() {
        session.beginTransaction(); // 开启事务

        User user = new User(); //临时状态

        session.getTransaction().commit();  // 提交事务
    }

    @Test
    public void persistentTest() throws Exception {
        session.beginTransaction();

        /**
         * java对象与数据库对象建立联系
         *      1.通过save方法把临时状态转化为持久化状态
         *      2.通过get/load方法直接从数据库中加载持久化对象
         *      3.通过update把游离对象变为持久化对象
         */
        //1.临时状态-》持久化状态
       /* User user1 = new User("张三"); //临时状态
        session.save(user1);    //持久化状态*/

        //2.直接从数据库获取持久化状态
        /*User user2 = (User) session.get(User.class, 1L);   //持久化状态
        System.out.println(user2);*/

        //3.更新游离状态为持久化状态
        User user3 = (User) session.get(User.class, 1L);   //持久化状态
        session.getTransaction().commit();
        session.close();  //user3变成了游离对象
        setUp();
        session.beginTransaction();
        user3.setName("李四");
        session.update(user3); //user3变成了持久化对象


        session.getTransaction().commit();
    }

    @Test
    public void detachedTest() {
        session.beginTransaction();

        User user2 = (User) session.get(User.class, 1L);   //持久化状态

        session.getTransaction().commit();
        //session.close(); 之后，user2变成了游离状态
    }

    @Test
    public void removedTest() {
        session.beginTransaction();
        //1.
        /*User user2 = (User) session.get(User.class, 2);   //持久化状态
        session.delete(user2);  //此时，user2变成了删除状态*/
        //2.
        User user2 = (User) session.get(User.class, 2);   //持久化状态
        session.close();  //此时，user2变成了游离状态
        session.delete(user2);  //此时，user2变成了删除状态

        session.getTransaction().commit();
    }

    @Test
    public void mergeTest() throws Exception {
        session.beginTransaction();

        /**
         *   user1和user2具有相同的oid，但是user2在缓存中，user1不在缓存中
         */
        User user1 = (User) session.get(User.class, 1L);
        session.getTransaction().commit();
        session.close();//user1处于游离状态
        setUp();
        session.beginTransaction();
        User user2 = (User) session.get(User.class, 1L); //user2处于持久化状态

        //可以更新user2，不可以更新user1，因为持久对象和游离对象是同一个对象，则以持久化对象为准
        /*user1.setName("新名字1");
        session.update(user1);*/
       /* user2.setName("新名字2");
        session.update(user2);*/

        //建议把游离状态对象属性合并到持久化对象中,然后更新持久化对象
        user1.setName("新名字1");
        user2.setName("新名字2");
        session.merge(user1);
        session.update(user2);

        session.getTransaction().commit(); // 提交事务
    }

}

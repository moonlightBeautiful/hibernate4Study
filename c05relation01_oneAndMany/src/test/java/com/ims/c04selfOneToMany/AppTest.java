package com.ims.c04selfOneToMany;

import com.ims.model.c04selfOneToMany.Node;
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
    private SessionFactory sessionFactory;

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

    @Test
    public void testSaveWithCascade() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Node node = new Node();
        node.setName("根节点");

        Node subNode1 = new Node();
        subNode1.setName("子节点1");
        subNode1.setParentNode(node);

        Node subNode2 = new Node();
        subNode2.setName("子节点2");
        subNode2.setParentNode(node);

        session.save(subNode1);
        session.save(subNode2);

        session.getTransaction().commit(); // 提交事务
        session.close();
    }

}
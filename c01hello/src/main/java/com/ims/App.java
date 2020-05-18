package com.ims;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //1. 实例化配置文件
        Configuration configuration = new Configuration().configure();
        //2. 实例化注册服务
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        //3. 获取Session工厂
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        //4. 获取Session
        Session session = sessionFactory.openSession();

        //5. crud
        System.out.println("根据实体类映射文件创建表成功。");

        //6. 关闭Session
        session.close();
    }
}

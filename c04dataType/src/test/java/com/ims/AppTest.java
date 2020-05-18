package com.ims;

import com.ims.model.Book;
import com.ims.model.People;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public void initTables() throws IOException, ParseException {
        session.beginTransaction(); // 开启事务

        session.getTransaction().commit(); // 提交事务
    }
    /**
     * 基本数据类型
     */
    @Test
    public void hello1() throws IOException, ParseException {
        session.beginTransaction(); // 开启事务

        /*Book book = new Book();
        book.setBookName("java编程思想");   //String
        book.setPrice(100);    //float
        book.setSpecialPrice(true);   //boolean   ->tinyint
        book.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").parse("2013-1-1")); //date   ->datetime
        book.setAuthor("埃克尔");  //String
        book.setIntroduction("简介...");   //String  ->text*/
        /**
         * Blob
         */
     /*   LobHelper lobHelper = session.getLobHelper();
        InputStream in = new FileInputStream("java编程思想.jpg");
        Blob bookPic = lobHelper.createBlob(in, in.available());
        book.setBookPic(bookPic);
        session.save(book);*/

        session.getTransaction().commit(); // 提交事务
    }


    /**
     * 集合类型
     */
    @Test
    public void hello2() throws IOException, ParseException {
        session.beginTransaction(); // 开启事务

        /**
         * Set测试
         */
        /*Set<String> imageSet=new HashSet<String>();
        imageSet.add("够1");
        imageSet.add("够2");
        imageSet.add("够3");
        imageSet.add("够1");
        People s1=new People();
        s1.setDogs(imageSet);
        session.save(s1);*/
        /*People student=(People)session.get(People.class, Long.valueOf(2));
        Iterator it=student.getDogs().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/
        /**
         * List测试
         */
        /*List<String> imageList=new ArrayList<String>();
        imageList.add("image1.png");
        imageList.add("image2.png");
        imageList.add("image3.png");
        imageList.add("image3.png");
        People s2=new People();
        s2.setCats(imageList);
        session.save(s2);*/
       /* People student2=(People)session.get(People.class, Long.valueOf(2));
        Iterator it=student2.getCats().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/
        /**
         * IdBag测试
         */
        /*List<String> imageList=new ArrayList<String>();
        imageList.add("image1.png");
        imageList.add("image2.png");
        imageList.add("image3.png");
        imageList.add("image3.png");
        People s3=new People();
        s3.setHorses(imageList);
        session.save(s3);*/
       /* People student3 = (People) session.get(People.class, Long.valueOf(3));
        Iterator it = student3.getHorses().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }*/
        /**
         * Map测试
         */
        Map<String, String> imageMap = new HashMap<String, String>();
        imageMap.put("i1", "image1.png");
        imageMap.put("i2", "image2.png");
        imageMap.put("i3", "image3.png");
        imageMap.put("i4", "image4.png");
        People s4 = new People();
        s4.setPigs(imageMap);
        session.save(s4);


        session.getTransaction().commit(); // 提交事务
    }

}

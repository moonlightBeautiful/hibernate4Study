# hibernateStudy
基本crud
    session.beginTransaction(); // 开启事务
    。。。。。。。。。。//crud
    session.getTransaction().commit(); // 提交事务
1.查询    
    查询单个：
        session.get(Object.class, 主键);  //返回Object
    查询多个
        hql：from class / from class where id = 1
        Query query = session.createQuery(hql);
        List<Object> userList = query.list();
2.增加
     session.save(Object)
3.删除
    先得到：session.get(Object.class, 主键);  //返回Object
    再删除：session.delete(Object)
4.更新
    先得到：get(Object.class, 主键);
    再更新：delete(Object)
   
                  
        
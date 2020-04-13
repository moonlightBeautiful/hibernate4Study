# hibernateStudy
基本crud
    1.查询    
        查询单个：
            get(Object.class, 主键);
        查询多个
            hql：from class 
            Query query = session.createQuery(hql);
            List<Object> users = query.list();
    1.增加
         save(Object)
    2.删除
        先得到：get(Object.class, 主键);
        再删除：delete(Object)
    3.更新
        先得到：get(Object.class, 主键);
        再更新：delete(Object)
   
                  
        
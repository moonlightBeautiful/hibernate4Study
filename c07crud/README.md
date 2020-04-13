# hibernateStudy
方式：
    1.oid，也就是主键
    2.对象导航
    3.sql
    4.hql
    5.qbc
1.通过oid（主键）
    通过oid可以获取对象
        (Student) session.get(Student.class, Long.valueOf(2));
        (Student) session.load(Student.class, Long.valueOf(2));
    获取对象后可以 save delete update 单个对象
2.对象导航
    通过对象的关联属性来获取关联的对象
    student.getSchool()
    对关联的对象进行修改后，然后可以 save 获取的对象级联修改关联的对象
3.sql
    首先设置参数2种方式
        1.按参数名称绑定   =:自定义名     query.setParameter(“自定义名”,值,【基本数据类型不用写】); 
        2.按参数位置邦定   =?             query.setParameter(index 0开始,值);            
    查 ： select 
    增、删、改：insert、delete、update
4.hql：createQuery(hql)
    增：
        HQL语言是用于面向对象实现查询功能的,然而在插入操作中是不会牵涉任何查询动作的,所以HQL不能用于insert语句的插入操作
    删：
        delete 【from】Student as p where p.id=?
    改：
        update Student as p set p.name = ? where p.id=?
    查：select 属性 可以省略
        普通查询：from class
        带条件查询：from Student where name=:name
        使用别名：from Student as s where s.name=:name   s可以省略
        对结果进行排序：from class order by name desc
        分页查询：  query.setFirstResult(1); query.setMaxResults(1);
        查询单个对象： query.uniqueResult();
        链式写法：query.setString("name", "高旭").list()
5.qbc：Query By Criteria，是用来查询的
    查：session.createCriteria(Student.class)
        普通查询：session.createCriteria(Student.class)    criteria.list()
        带条件查询：Restrictions.条件（）  criteria.add（条件）
        对结果进行排序：from class order by name desc
        分页查询：  criteria.setFirstResult(1); criteria.setMaxResults(1);
        查询单个对象： query.uniqueResult();
        链式写法：criteria.setFirstResult(0).setMaxResults(2).list();
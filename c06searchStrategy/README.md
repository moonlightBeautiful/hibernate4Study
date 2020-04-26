# hibernateStudy
检索策略
    如果程序加载一个持久化对象的目的是为访问他的属性，则可以采用立即加载。
    如果程序加载一个持久化对象的目的仅仅是为了获得他的引用，则可以采用延迟加载。
    1、lazy：延迟加载关联表
        配置set上
            true（默认值）：延迟检索。用到关联类的时候再加载关联类的全部数据。
            fasle：立即检索。立即加载关联类的全部数据。  
            extra：增强型延迟加载。少很少用到，用到关联类的时候再加载用到的关联类的相关数据。
        配置在多的一端mant-to-one上
            proxy（默认值）：代理延迟检索。用到关联类的时候再加载关联类的全部数据。
            false：立即检索。立即加载关联类的全部数据。 
            no-proxy：无代理延迟检索，关联对象是null，用到的时候再查。需要编译时字节码增强，需要额外的工具。基本用不到   
        注解：
            @OneToMany(mappedBy="多端的关联属性名",fetch=FetchType.EAGER)
            1、FetchType.LAZY：懒加载，加载一个实体时，定义懒加载的属性不会马上从数据库中加载。
            2、FetchType.EAGER：急加载，加载一个实体时，定义急加载的属性会立即从数据库中加载。
   2、batch-size：指定一次查询多少个集合 
        配置set上，默认值1。
        hql或者sql查询一端的时候才有效。 例如hql = from Class
            lasy：true，batch-size：n。延迟批量加载n个。
            lasy：false，batch-size：n。立即批量加载n个。
               List<Class> classes =  session.createQuery("from Class").list();
               classes.iterator().next();  //比如batch-size=2，,每次批量加载2个学生
            批量加载sql为：
                select * from 多端（也就是集合） where 外键 in （batch-size一端主键） order by 一端主键
   3、fetch：加载关联对象的方式
        配置set上
        select，默认
            先查询主体对象sql，然后根据主对象主键查询关联对象，形成n+1次查询。
        subselect
            先查询主体对象sql，然后用子查询查询多端，select 多端 主键 in (select 一端主键 )
        join检索：外连接查询。因为采用的是外连接查询，同时把一端和多端都查询出来了。
            主体对象和关联对象用一句外键关联的sql同时查询出来，不会形成多次查询。
            这个不会            
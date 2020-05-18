#hello
简介
    开源的面向对象ORM(对象关系映射框架)框架。
编码
    1.hibernate上下文配置：hibernate.cfg.xml
        1.配置数据库信息：地址 用户 密码 方言
        2.其他配置：控制台是否显示sql 是否自动更新表
        3.实体类、实体类对应的xml 与 表映射
    2.实体类与表映射配置：
        1.xml方式
            xml文件与实体类映射
                1.实体类就是普通的模型类
                2.xml文件：
                    主键使用id标签，其他字段property标签，如果不额外限制字段，则使用默认值。
        2.注解方式
            类上
                @Entity
                @Table(name = "表名")
            主键属性上  
                自增主键：
                    @Id
                    @GeneratedValue(generator = "_native")
                    @GenericGenerator(name = "_native", strategy = "native")
                自定义主键
                    @Id
                    @Column(name = "id", unique = true, nullable = false, length = 40,columnDefinition="text")
            其他属性上
                可以什么都不写，则默认配置
                @Transient：忽略该属性映射
    3.使用hibernate
        // 实例化配置文件
        Configuration configuration = new Configuration().configure();
        // 实例化注册服务
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        // 获取Session工厂
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        // 获取Session
        session = sessionFactory.openSession();
        // 使用完Session后关闭
        session.close();
    4.提示
        数据库需要自己创建
方言
    在Hibernate底层依然使用SQL语句来执行数据库操作。
    数据库都是支持sql的，不过不同的数据库会存在一些sql语法上面的差异，不同数据库的sql就是方言。
    方言则帮助hql翻译成sql保证语法的正确。
    hql是普通话，数据库的专属sql是方言。
主键策略
    1.native 以后就用这个
        由Hibernate根据底层数据库自行判断采用identity、hilo、sequence其中一种作为主键生成方式。
    2.identity
        由数据库生成主键。
    3.---等等
note:
    关于根据映射配置自动更新表
        1.如果实体类映射的表不存在则自动创建。
        2.如果实体类映射配置改变，则自动更新表：
            1.增加个属性，则表自动增加个字段。
            2.删除个属性，表不会自动删除字段，需要手动删除。
            3.修改个属性，表不会自动修改字段，需要手动修改。
   
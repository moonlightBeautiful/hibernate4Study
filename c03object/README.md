# 对象
简介：
    即java对象，可与数据库的记录对应。
1.对象标识符OID，也就是主键）
    hibernate在session缓存中使用，对象标识符-映射-对象(Object)和记录，的关系。对象标识符相同，则表示的是同一个对象。
    主键
        分类：代理主键和业务主键
        代理主键：increment、identity、sequence、hilo、native
            1.increment：由hibernate自动以递增的方式生成OID，数据库中主键并没有选择自增选项。
            2.identity：由数据库生产标识符，即数据库中表主键会被hibernate控制配置成自增选项。
            3.sequence：由hibernate根据数据库的序列（每条记录有一个序列）来生成标识符。mysql不支持。
            4.hilo：由hibernate根据high/low算法来生成标识符。
            5.native：由hibernate根据数据库对自动生成标识符的支持能力，来选择identify，sequence或者 hilo。Mysql的话，native=identity。         
2.java对象的状态 
    4种状态：  
        1.临时状态（transient）：new创建，还没进入session缓存中。
        2.持久化状态（persistent）：处于session缓存中，且在数据库中有对应的记录。
        3.删除状态（removed）：不处于session缓存中，且session计划将其从数据库中删除。
        4.游离状态（detached）：在session缓存中没有，但在数据库中有对应的记录。
    6种操作 
        1.load/get：从数据库中加载一个持久化对象。
            load延迟加载 get立即加载
            类 实例 = （类）session.load/get()
        2.delete：将一个持久化对象/游离对象从数据库中删除。变成删除状态。
            session.delete(持久化对象)
        3.save：将一个临时对象持久化成持久化对象
            session.save(临时对象)
        4.update：将一个游离对象/持久化对象变为持久化对象。
            session.update(游离对象/持久化对象)
        5.saveOrUpdate：将一个临时对象/游离对象/持久化对象变成持久化对象。
             session.saveOrUpdate(临时对象/游离对象/持久化对象)
        6.merge：存在游离对象和持久化对象是同一个记录的时候，
            如果要对游离对象持久化操作，需要把游离对象合并到持久化对象
            session.merge(游离对象)  提交后，会更新到数据库
            
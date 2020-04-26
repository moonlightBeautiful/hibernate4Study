# hibernateStudy
高级配置：
    1.连接池配置
    2.日志log4j配置
    3.二级缓存配置
1.连接池配置
    简介
        与数据库建立连接很耗时：连接到数据库服务器需要经历几个漫长的过程，很耗时。
        连接池：它存放了一定数量的与数据库服务器的物理连接。
        hibernate自带的连接池不好，有bug。推荐使用c3p0等
    引入jar：c3p0
    配置：很奇怪，引入c3p0的包之后，没有声明使用c3p0就自动使用了
        <!-- 最小连接数 -->
        <property name="c3p0.min_size">7</property>
        <!-- 最大连接数 -->
        <property name="c3p0.max_size">42</property>
        <!-- 获得连接的超时时间,如果超过这个时间,会抛出异常，单位毫秒 -->
        <property name="c3p0.timeout">1800</property>
        <!-- 最大的PreparedStatement的数量 -->
        <property name="c3p0.max_statements">50</property>
2.日志log4j配置   
    简介
        默认使用的slf4j，支持log4j，引入直接可用。
    引入jar：log4j
    引入配置文件：log4j.properties
    然后直接打日志
3.二级缓存配置
    简介
        介于物理数据源和应用程序之间，比如内存、硬盘。hibernate读取数据，根据缓存机制在相应的缓存找查找，查找到了叫做缓存命中。
        把常用的数据放到缓存中，避免了频繁访问物理数据源带来的性能损耗。
    hibernate缓存
        1、session缓存（事务缓存），hibernate内置的，不能卸除。session级别
            只能被自己的session对象访问，生命周期依赖于session的生命周期。
            一个session缓存对应一个自己专属的一级缓存，比如 开始2个session缓存，session缓存1和session缓存2都获取到了一条记录，但是却不相等。
        2、sessionFactory缓存（二级缓存），第三方插件，可拔插。SessionFactory级别
            被应用范围内的所有session共享，生命周期依赖于应用程序。当Session需要抓取数据时，Session就会优先从二级缓存中抓取。
            第三方插件
                EHCache，OSCache，SwarmCache，jBoss Cathe2
                其中 EHCache，OSCache 是不能用于集群环境（Cluster Safe）的，而 SwarmCache，jBoss Cathe2 是可以的。
                HashTable 缓存主要是用来测试的，只能把对象放在内存中，EHCache，OSCache 可以把对象放在内存（memory）中，也可以
                把对象放在硬盘（disk）上。
            什么数据适合放二级缓存中：一般只读的
                （1）经常被访问
                （2）改动不大
                （3）数量有限
                （4）不是很重要的数据，允许出现偶尔并发的数据。
                 比如组织机构代码，列表信息等；
            配置ehcache
                1.引入依赖包：在hibernate4的下载包 lib/optional/ehcache下有依赖包
                    <!-- 二级缓存ehcache -->
                    <dependency>
                        <groupId>org.hibernate</groupId>
                        <artifactId>hibernate-ehcache</artifactId>
                        <version>4.3.8.Final</version>
                    </dependency>
                    <dependency>
                        <groupId>net.sf.ehcache</groupId>
                        <artifactId>ehcache</artifactId>
                        <version>2.9.0</version>
                    </dependency>
                2.引入ehcache配置：在hibernate4的下载包 project/hibernate-ehcache/bin/hibernate-config中有示例
                3.hibernate配置文件中配置二级缓存
                    <!-- 二级缓存配置 -->
                    <!-- 启用二级缓存 -->
                    <property name="cache.use_second_level_cache">true</property>
                    <!-- 启用查询的二级缓存:是否缓存查询结果 -->
                    <property name="cache.use_query_cache">true</property>
                    <!-- 配置二级缓存的产品 EhCache -->
                    <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
                    <!-- 二级缓存ehcache的配置文件位置，默认就是在resources/ehcache.xml -->
                    <property name="hibernate.cache.provider_configuration_file_resource_path">ehcache.xml</property>
                4.配置需二级缓存实体和属性
                    1.注解
                        在实体类和实体的那些集合属性get方法上启用二级缓存使用
                        @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
                    2.xml
                        <cache usage="read-only"/>
                    缓存usage事务隔离机制
                        read-only是只读型，缓存不更新，适用于不发生改变的数据，效率最高，事务隔离内级别最低。
                        read-write读写型，缓存在数据变化时触发更新，适用于变化的数据。
                        nonstrict-read-write不严格读写型，缓存不定期更新，适用于变化频率低的数据。
                        transactional事务型，缓存在数据变化时更新，并且支持事务，效率最低，事务隔离级别最容高。
                    
                        
                        
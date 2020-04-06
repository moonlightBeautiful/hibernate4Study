# hibernateStudy
一对一
    简介：
        比如身份证和人，2种实现方式。
    1.共享主键
        两张表主键共享，主从表，从表的主键来自主表的主键。
        所以保存是先保存主表再保存从表，删除是先删除从表再删除主表。
        主表配置：其他一样
            <one-to-one name="passport1" class="com.ims.model.c01sharedPrimaryKey.Passport1" cascade="all"></one-to-one>
        从表配置：其他一样
            <!-- 主键生成策略  -->
            <id name=" " column=" ">
                <generator class="foreign">	
                    <param name="property"> </param>
                </generator>
            </id>
            <!-- constrained 启用约束 -->
            <one-to-one name=" " class="主表类全类名" constrained="true"></one-to-one>
        constrained="true"解释
            1.只能用在从表的一对一标签上，主表的一对一标签用了没用处。
            2.表明我们的主键当外键使用了，不需要写column属性。
            3.有级联保存主表作用，先保存主表数据，在保存从表数据。不能主表级联保存从表。
    2.外键值唯一
        类属性还是一对一形式
        主表配置
            <many-to-one name="从表属性" class="从表类全类名" column="外键字段名"unique="true"/>
        从表配置
            <one-to-one name="主表属性" property-ref="主表类的从表属性" class="主表类全类名"/>
        
     
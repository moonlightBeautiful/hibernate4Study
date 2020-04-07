# hibernateStudy
多对多
    简介：
        需要依靠中间表建立多对多的关系，中间表有2个字段，由两张表的主键组成，是联合主键。        
        1.单向：只在一端配置多对多
            在一端配置文件中指定中间表表名和中间表的联合主键。
            比如学生有多个课程
            <set name="courses" table="c050401_t_student_course" cascade="save-update">
                <!-- key的column，表示当前类在中间表中的外键 -->
                <key column="student_id"/>
                <!-- many-to-many表示多对多关系, class表示另一方类的全限定名,column表示另一方在中间表中的外键 -->
                <many-to-many class="com.ims.model.c01singleWayManyToMany.Course1" column="course_id"/>
            </set>
        2.双向：两端配置多对多  
            在两端配置文件中指定中间表表名和中间表的联合主键，配置要一样。
            学生有多个课程，课程被多个学生选。
            两边都配置 set      
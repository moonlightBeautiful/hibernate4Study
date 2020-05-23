# hibernateStudy
数据类型
    简介：
        java和hibernate和sql数据类型映射。
    映射：基本数据类型和集合数据类型
        1.基本数据类型
             java                -              mysql
            int/Integer                         int  
            long/Long                           bigint   
            float/Float                         float
            double/Double	                    double
            String                              varchar(255)默认，可配置成longtext(oracle是clob)
            boolean                             tinyint  (在mysql中0是false，1是true)
            Date                                datetime
            Blob                                longblob
        2.集合数据类型：集合独立成为一张表。单纯的数据，没有oid和生命周期 ，不带缓存。
            java                        标准sql 
            Set                         独立的表(没有主键，有一个外键来自于类表的主键) 无序不重复                                        
            List                        list：独立的表，（混合主键(来自类的主键+索引键)） 有序可重复
                                        idbag：独立的表，（主键+外键，主键自己生成，外键来自类主键）  有序不重复  
            Map                         独立的表，（混合主键(来自类的主键+map的key））  
        note:
            key 是外键，主表的主键
            index  column 不要取名为index，否则创建不成表
            element column 不要取名为name，否则创建不成表
                     
        

        
        		
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
            String                           varchar(255)默认，可配置成longtext(oracle是clob)
            boolean                           tinyint  (在mysql中0是false，1是true)
            Date                                datetime
            Blob                                 longblob
        2.集合数据类型：
            集合独立成为一张表。单纯的数据，没有oid和生命周期 ，不带缓存。
            java                 hibernate                                      标准sql 
            Set                  set<必须指定类型>                                独立的表
                无序（每次获取的顺序逼样）不重复（一样的内容，save，只保存一个）
                独立的表，没有主键，但是key来自于主表的主键                                           
            List                 list标签，有序可重复 /idbag标签，无序可重复         独立的表
                list：独立的表，混合主键，其中一个主键来自于主表的主键  
                idbag：独立的表，主键自己生成，其中一个字段来自于主表的主键    
            Map                   map标签                                                独立的表
                独立的表，混合主键，其中一个主键来自于主表的主键  
        note:
            key 是外键，主表的主键
            index  column 不要取名为index，否则创建不成表
            element column 不要取名为name，否则创建不成表
                     
        

        
        		
package com.hx.mybatis;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * @author yxqiang
 * @create 2018-10-08 16:00
 */
public class C3P0DataSourceFactory extends UnpooledDataSourceFactory {

    public C3P0DataSourceFactory(){
        this.dataSource = new ComboPooledDataSource();
    }
}

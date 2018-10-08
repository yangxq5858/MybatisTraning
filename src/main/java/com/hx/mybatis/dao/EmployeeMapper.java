package com.hx.mybatis.dao;

import com.hx.mybatis.bean.Employee;

/**
 * @author yxqiang
 * @create 2018-10-08 10:18
 */
public interface EmployeeMapper {

    Employee getEmployeeById(Integer id);
}

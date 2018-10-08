package com.hx.mybatis.dao;

import com.hx.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yxqiang
 * @create 2018-10-08 10:18
 */
public interface EmployeeMapper {


    List<Employee> getEmployeesByName(String lastName);

    //使用pojo的参数方式
    Employee getEmployeeByPOJO(Employee employee);

    Employee getEmployeeById(Integer id);
    //多参数
    Employee getEmployeeByIdAndLastName(@Param("id") Integer id,@Param("lastName") String lastName);

    Integer insertEmp(Employee employee);

    Boolean updateEmp(Employee employee);

    Boolean delEmp(Integer id);

}

import com.hx.mybatis.bean.Employee;
import com.hx.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yxqiang
 * @create 2018-10-07 21:25
 */
public class MybatisTest {

    private SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }


    //测试原始用法
    @Test
    public void test1() throws IOException {
        //参数：sql的唯一标识，参数
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Employee employee = sqlSession.selectOne("com.hx.mybatis.bean.EmployeeMapper.selectEmployee", 1);
            System.out.println(employee);
        }finally {
            sqlSession.close();

        }
    }

    @Test
    public void testInterface() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println("---------------------------------");
            Employee employee = mapper.getEmployeeById(1);
            System.out.println(employee.toString());
        }finally {
            sqlSession.close();

        }
    }


}

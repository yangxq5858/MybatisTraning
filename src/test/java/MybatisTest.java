import com.hx.mybatis.bean.Employee;
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

    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;


    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void after(){
        sqlSession.close();
    }


    @Test
    public void test1(){
        //参数：sql的唯一标识，参数
        Employee employee = sqlSession.selectOne("com.hx.mybatis.bean.EmployeeMapper.selectEmployee", 1);
        System.out.println(employee);

    }



}

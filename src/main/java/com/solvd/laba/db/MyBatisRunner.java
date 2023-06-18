package com.solvd.laba.db;

import com.solvd.laba.db.mappers.EmployeeMapper;
import com.solvd.laba.model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisRunner {
    public static void main(String[] args) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis_config.xml")) {
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
            SqlSession session = sessionFactory.openSession();

            Employee employee = session.selectOne("com.solvd.laba.db.mapper.EmployeeMapper.selectEmployeeById", 2);


            System.out.println(employee);

            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


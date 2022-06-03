package com.liyeam.seckill;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootTest
class SeckillDemoApplicationTests {

    @Autowired
    HikariDataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user where id = 18099998888");
        System.out.println(resultSet == null);
        statement.close();
        connection.close();
    }

}

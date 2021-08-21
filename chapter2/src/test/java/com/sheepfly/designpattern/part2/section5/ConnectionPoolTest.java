package com.sheepfly.designpattern.part2.section5;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionPoolTest {
    private static Logger log = LoggerFactory.getLogger(ConnectionPoolTest.class);

    @Test
    public void testSql() {
        ConnectionPool pool = ConnectionPool.getInstance();

        Connection connection = pool.getConnection();
        String sql = "select * from cla";
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            log.info("开始取值");
            while (resultSet.next()) {
                log.info(resultSet.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
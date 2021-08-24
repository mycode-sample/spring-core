package com.sheepfly.chapter2.part2.section5;

import cn.hutool.core.io.resource.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public class ConnectionPool extends Pool {
    private static int num = 0;
    private static int numActivate = 0;
    private static ConnectionPool pool = null;
    private final Vector<Connection> freeConnections = new Vector<>();
    private int checkOut;
    private String username = null;
    private String password = null;
    private String url = null;

    private ConnectionPool() {
        try {
            log.info("开始创建连接池");
            init();
            for (int i = 0; i < normalConnect; i++) {
                Connection connection = newConnection();
                if (connection != null) {
                    freeConnections.addElement(connection);
                    num++;
                }
            }
            log.info("连接池创建完成，共创建" + normalConnect + "个连接");
        } catch (Exception e) {
            log.info("创建连接池失败", e);
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public Connection newConnection() {
        Connection connection = null;
        log.info("创建数据库连接,url: " + url);
        try {
            if (username == null) {
                connection = DriverManager.getConnection(url);
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (Exception e) {
            log.info("创建连接失败,url " + url, e);
        }
        if (connection != null) {
            checkOut++;
        }
        return connection;
    }

    private void init() throws IOException {
        ClassPathResource resource = new ClassPathResource(propertiesName);
        InputStream inputStream = resource.getStream();
        Properties properties = new Properties();
        properties.load(inputStream);
        this.username = properties.getProperty("username");
        this.password = properties.getProperty("password");
        this.url = properties.getProperty("url");
        this.maxConnect = Integer.parseInt(properties.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(properties.getProperty("normalConnect"));
    }

    @Override
    public void createPool() {
        pool = new ConnectionPool();
        if (pool != null) {
            log.info("创建连接池成功");
        } else {
            log.error("创建连接池失败");
        }
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        if (freeConnections.size() > 0) {
            num--;
            connection = freeConnections.firstElement();
            freeConnections.removeElementAt(0);
            try {
                if (connection.isClosed()) {
                    log.error("从连接池中删除一个已关闭的连接");
                }
            } catch (Exception e) {
                log.error("发生异常", e);
            }
        } else if (maxConnect == 0 || checkOut < maxConnect) {
            connection = newConnection();
        }
        return connection;
    }

    @Override
    public void release() {
        log.info("开始关闭所有连接");
        try {
            Enumeration allConnections = freeConnections.elements();
            while (allConnections.hasMoreElements()) {
                Connection connection = (Connection) allConnections.nextElement();
                try {
                    connection.close();
                    num--;
                } catch (Exception e) {
                    log.error("关闭连接失败");
                }
            }
            freeConnections.removeAllElements();
            numActivate = 0;
        } finally {
            super.release();
        }
    }

    @Override
    public Connection getConnection(long timeout) {
        long starTime = System.currentTimeMillis();
        Connection connection;
        while ((connection = getConnection()) == null) {
            try {
                wait(timeout);
            } catch (Exception e) {
                log.error("发生异常", e);
            }
            if ((System.currentTimeMillis() - starTime) >= timeout) {
                return null;
            }
        }
        return connection;
    }

    @Override
    public void freeConnection(Connection connection) {
        freeConnections.addElement(connection);
        num++;
        checkOut--;
        numActivate--;
        notifyAll();
    }

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public int getNumActive() {
        return numActivate;
    }
}

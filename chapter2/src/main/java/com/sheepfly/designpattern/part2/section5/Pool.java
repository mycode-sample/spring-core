package com.sheepfly.designpattern.part2.section5;

import cn.hutool.core.io.resource.ClassPathResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

public abstract class Pool {
    public static Logger log = LoggerFactory.getLogger(Pool.class);
    public static Pool instance = null;
    public String propertiesName = "database.properties";
    protected int maxConnect = 100;
    protected int normalConnect = 10;
    protected String driverName = null;
    protected Driver driver = null;

    protected Pool() {
        try {
            init();
            loadDrivers(driverName);
        } catch (Exception e) {
            log.error("初始化失败", e);
        }
    }

    public static synchronized Pool getInstance() {
        if (instance != null) {
            try {
                instance = (Pool) Class.forName("com.sheepfly.designpattern.part2.section5.Pool").newInstance();
            } catch (Exception e) {
                log.error("获取唯一连接池失败", e);
            }
        }
        return instance;
    }

    private void init() throws IOException {
        log.info("初始化数据库");
        ClassPathResource resource = new ClassPathResource(propertiesName);
        InputStream inputStream = resource.getStream();
        Properties properties = new Properties();
        properties.load(inputStream);
        this.driverName = properties.getProperty("driverName");
        this.maxConnect = Integer.parseInt(properties.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(properties.getProperty("normalConnect"));
        log.info("初始化完成");
    }

    protected void loadDrivers(String driverName) {
        try {
            log.info("开始加载驱动:" + driverName);
            driver = (Driver) Class.forName(driverName).newInstance();
            DriverManager.registerDriver(driver);
            log.info("驱动加载完成");
        } catch (Exception e) {
            log.error("驱动加载失败:" + driverName, e);
        }
    }

    public abstract void createPool();

    public abstract Connection getConnection();

    public abstract Connection getConnection(long time);

    public abstract void freeConnection(Connection connection);

    public abstract int getNum();

    public abstract int getNumActive();

    protected synchronized void release() {
        try {
            log.info("开始卸载驱动" + driver.getClass().getName());
            DriverManager.deregisterDriver(driver);
        } catch (Exception e) {
            log.error("驱动卸载失败", e);
        }
    }
}

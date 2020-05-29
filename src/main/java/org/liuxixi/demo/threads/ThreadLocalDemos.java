package org.liuxixi.demo.threads;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Cleanup;

/**
 * Description for this class
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/4/15 9:27
 */
public class ThreadLocalDemos {

    /**
     * 数据库连接池
     */
    private static HikariDataSource source;
    /**
     * 为不同的线程管理连接
     */
    private static ThreadLocal<Connection> local;


    static {

        source = new HikariDataSource();
        //初始化线程本地
        local = new ThreadLocal<>();
    }

    public static Connection getConnection() throws SQLException {
        //获取Connection对象
        @Cleanup Connection connection = source.getConnection();
        //把Connection放进ThreadLocal里面
        local.set(connection);
        //返回Connection对象
        return connection;
    }

    public static void closeConnection() throws SQLException {
        //从线程中拿到Connection对象
        @Cleanup Connection connection = local.get();
        if (connection != null) {
            //恢复连接为自动提交
            connection.setAutoCommit(true);
            //这里不是真的把连接关了,只是将该连接归还给连接池
            connection.close();
            //既然连接已经归还给连接池了,ThreadLocal保存的Connection对象也已经没用了
            local.remove();
        }
    }
}
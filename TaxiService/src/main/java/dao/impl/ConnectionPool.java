package dao.impl;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class ConnectionPool {
    
	private static volatile DataSource dataSource;
    
	//lazy
    public static DataSource getDataSource(){
        if (dataSource == null){
            synchronized (ConnectionPool.class) {
                if (dataSource == null) {
                	PoolProperties pprops = new PoolProperties();
                	pprops.setUrl("jdbc:mysql://localhost:3306/mydb");
                	pprops.setDriverClassName("com.mysql.jdbc.Driver");
                	pprops.setUsername("root");
                	pprops.setPassword("root");
                	pprops.setMaxIdle(10);
                	pprops.setMaxWait(10000); //milliseconds until throwing exception
                    dataSource = new DataSource(pprops);
                }
            }
        }
        return dataSource;
    }


}
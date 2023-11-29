/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudhakar.connection;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.InputStream;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author sudhakar
 */
public class DbConnection
{
    static Connection con;
    
    public static void main(String[] args)
    {
        String jdbc_url=null, username=null, password=null;
        try
        {
            InputStream is=DbConnection.class.getResourceAsStream("db.properties");
            
            Properties p=new Properties();
            p.load(is);
            
            jdbc_url=p.getProperty("jdbc-url");
            username=p.getProperty("username");
            password=p.getProperty("password");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal","root","root");
            
            MysqlDataSource ds=new MysqlDataSource();
            
            ds.setURL(jdbc_url);
            ds.setUser(username);
            ds.setPassword(password);
            
            con=ds.getConnection();
        }
        catch(Exception e)
        {
            out.println(e.getMessage());
        }
        
       // return con;
    }

    public static Connection getConnect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

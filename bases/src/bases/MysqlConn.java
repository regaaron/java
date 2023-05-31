/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import  java.sql.ResultSet;
/**
 *
 * @author aaron
 */
public class MysqlConn {
    Statement stmt = null;
    ResultSet rs= null;
    Connection conn = null;
    
    public MysqlConn(){
        try{
            class.forName("com.mysql.jdbc.Driver");
            String connectionUrl
                    ="jdbc:mysql://"
        }catch()
    }
}
don
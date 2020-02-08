package POS;

import java.sql.*;

public class dbconn {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String id;
    String pw;
    int r;

    public dbconn() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  //드라이버연결
            this.conn = DriverManager.getConnection ("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "pos", "1234");
            String sql = "select *from login";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                id = rs.getString("id");
                pw = rs.getString("password");
                //System.out.println(id + pw);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void select(String query){
        try {
            this.stmt = this.conn.prepareStatement(query);
            this.rs = this.stmt.executeQuery(query);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void update(String query){
        try {
            this.stmt = this.conn.prepareStatement(query);
            this.stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void close() {
        try {
            conn.close();
        }
        catch(Exception e) { System.out.println("close error:"+e); }
    }
}

package dao;

import context.DBContext;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.DatatypeConverter;
import model.User;


public class UserDAO {


    public String HashMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] hash = md.digest(password.getBytes());

            return DatatypeConverter.printHexBinary(hash).toLowerCase();
        } catch (NoSuchAlgorithmException ex) {
        }
        return null;
    }

    /**
     * selectAllUser.<br>
     * 
     * @return list all user
     * @throws Exception 
     */
    public List<User> selectAllUser() throws Exception {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM dbo.[user]";
        
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String user = rs.getString(1);
            String pwd = rs.getString(2);
            String email = rs.getString(3);
            boolean role = rs.getBoolean(4);
            // add user to list
            users.add(new User(user, pwd, email, role));
        }
        //close
        db.closeConection(conn, ps, rs);
        return users;
    }

    /**
     * getUserByUserName.<br>
     * 
     * @param user
     * @return the user with username
     * @throws Exception 
     */
    public User getUserByUserName(String user) throws Exception {
        for (User u : selectAllUser()) {
            if (u.getUser().equals(user)) {
                return u;
            }
        }
        return null;
    }
    
    /**
     * addNewUser.<br>
     * 
     * @param u
     * @throws Exception 
     */
    public void addNewUser(User u) throws Exception{
        String sql = "INSERT INTO [user] (username, [password], email, [role])"
                + "VALUES(?, ?, ?, ?)";
        
        // get connection
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        
        // set value for "?" in sql command
        ps.setString(1, u.getUser());
        ps.setString(2, u.getPwd());
        ps.setString(3, u.getEmail());
        ps.setBoolean(4, u.isRole());
        
        // excecute sql command
        ps.execute();
        
        // close
        db.closeConection(conn, ps, null);
    }
}

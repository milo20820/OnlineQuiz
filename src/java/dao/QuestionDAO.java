package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Question;

public class QuestionDAO {

    /**
     * addNewQuestion.<br>
     *
     * @param q
     * @throws Exception
     */
    public void addNewQuestion(Question q) throws Exception {
        String sql = "INSERT INTO question(q_name, ans_1, ans_2, ans_3, ans_4, true_answer, created_by)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        // get connection
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        // set value for "?" in sql command
        ps.setString(1, q.getQ_name());
        ps.setString(2, q.getAns_1());
        ps.setString(3, q.getAns_2());
        ps.setString(4, q.getAns_3());
        ps.setString(5, q.getAns_4());
        ps.setString(6, q.getTrue_ans());
        ps.setString(7, q.getAuthor());

        // Execute command
        ps.executeUpdate();

        // Close
        db.closeConection(conn, ps, null);
    }

    /**
     * getAllQuestions.<br>
     *
     * @return list of all question
     * @throws Exception
     */
    public List<Question> getAllQuestions() throws Exception {
        List<Question> list = new ArrayList<>();
        String sql = "SELECT * FROM question";

        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        while (rs.next()) {
            int id = rs.getInt("id");
            String q_name = rs.getString("q_name");
            Date d = new Date(rs.getString("date_created"));

            String date = df.format(d);
            String ans_1 = rs.getString("ans_1");
            String ans_2 = rs.getString("ans_2");
            String ans_3 = rs.getString("ans_3");
            String ans_4 = rs.getString("ans_4");
            String true_ans = rs.getString("true_answer");
            String author = rs.getString("created_by");
            // add question to list
            list.add(new Question(id, q_name, date, ans_1, ans_2, ans_3, ans_4, true_ans, author));
        }
        // Close
        db.closeConection(conn, pstmt, rs);
        return list;
    }

    /**
     * getQuestionsByUser.<br>
     *
     * @param start
     * @param end
     * @param username
     * @return the list of question by user
     * @throws Exception
     */
    public List<Question> getPaggingQuestionsByUser(int start, int end, String username) throws Exception {
        List<Question> list = new ArrayList<>();
        String query = "SELECT * FROM (\n"
                + "SELECT *, ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNum FROM question\n"
                + ") AS MyDerivedTable WHERE MyDerivedTable.RowNum BETWEEN ? AND ? and MyDerivedTable.created_by = ?";

        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, start);
        pstmt.setInt(2, end);
        pstmt.setString(3, username);
        ResultSet rs = pstmt.executeQuery();
        DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        while (rs.next()) {
            int id = rs.getInt("id");
            String q_name = rs.getString("q_name");
            Date d = new Date(rs.getString("date_created"));

            String date = df.format(d);
            String ans_1 = rs.getString("ans_1");
            String ans_2 = rs.getString("ans_2");
            String ans_3 = rs.getString("ans_3");
            String ans_4 = rs.getString("ans_4");
            String true_ans = rs.getString("true_answer");
            String author = rs.getString("created_by");
            // add question to list
            list.add(new Question(id, q_name, date, ans_1, ans_2, ans_3, ans_4, true_ans, author));
        }
        // Close
        db.closeConection(conn, pstmt, rs);
        return list;
    }

    /**
     * saveResult.<br>
     *
     * @param user
     * @param score
     * @param numberQuestion
     * @throws Exception
     */
    public void saveResult(String user, float score, int numberQuestion) throws Exception {
        String sql = "INSERT INTO result(username, score, numberQuestion)"
                + "VALUES(?, ?, ?)";
        // get connection
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        // set value for "?" in sql command
        ps.setString(1, user);
        ps.setFloat(2, score);
        ps.setInt(3, numberQuestion);

        // excecute sql command
        ps.executeUpdate();

        // Close
        db.closeConection(conn, ps, null);
    }

    /**
     * countQuest.<br>
     *
     * @param createBy
     * @return number of question
     * @throws Exception
     */
    public int countQuest(String createBy) throws Exception {
        String sql = "select count(*) as c from question where created_by = ?";
        // get connection
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, createBy);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("c");
        }

        // Execute command
        ps.executeUpdate();

        // close
        db.closeConection(conn, ps, rs);

        return 0;
    }
    
    public int countQuest() throws Exception {
        String sql = "select count(*) as c from question";
        // get connection
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("c");
        }

        // Execute command
        ps.executeUpdate();

        // close
        db.closeConection(conn, ps, rs);

        return 0;
    }

    /**
     *
     *
     * @param id
     * @throws Exception
     */
    public void deleteQ(int id) throws Exception {
        String sql = "DELETE FROM dbo.question WHERE id = ?";
        // get connection
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        // set value for "?" in sql command
        ps.setInt(1, id);

        // excecute sql command
        ps.executeUpdate();

        db.closeConection(conn, ps, null);
    }
}

package dao;

import entity.Comment;
import oracle.jdbc.pool.OracleDataSource;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    private Connection connection;

    public CommentDao() throws IOException {
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setDriverType("thin");
            ods.setServerName("192.168.43.39");
            ods.setServiceName("logistics_db");
            ods.setPortNumber(1521);
            ods.setUser("logistics_admin");
            ods.setPassword("1234");
            connection = ods.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public List<Comment> getComments(int refId) throws  SQLException{
        ResultSet resultSet = connection.createStatement().executeQuery("select * from Our_comment where refId ="+refId);
        List<Comment> comments = new ArrayList<Comment>();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            refId = resultSet.getInt(2);
            String sessionId = resultSet.getString(3);
            Date stamp = resultSet.getDate(4);
            String comment = resultSet.getString(5);
            comments.add(new Comment(id,refId,sessionId,stamp,comment));
        }
        return  comments;
    }

    public void addComment(Comment comment) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call AddComment(?,?,?,?)}");
        callableStatement.setInt(1, comment.getRefId());
        callableStatement.setString(2,comment.getSessionId());
        callableStatement.setDate(3,comment.getStamp());
        callableStatement.setString(4,comment.getComment());
        callableStatement.execute();
    }

    public void updateComment(Comment comment) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("update Our_comment set comments = ? where id = ?");
        preparedStatement.setString(1,comment.getComment());
        preparedStatement.setInt(2,comment.getId());
        preparedStatement.executeUpdate();
    }

    public void  deleteComment(int id) throws SQLException {
        connection.createStatement().executeUpdate("delete from Our_comment where id = "+id);
    }
}

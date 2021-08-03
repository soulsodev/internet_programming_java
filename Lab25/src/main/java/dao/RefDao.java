package dao;

import entity.Reference;
import oracle.jdbc.pool.OracleDataSource;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RefDao {
    private Connection connection;

    public RefDao() throws IOException {
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

    public List<Reference> getReferences(String filter) throws  SQLException{
        if (filter == null)
            filter = "";
        PreparedStatement preparedStatement = connection.prepareStatement("select * from our_refs where description like ?");
        preparedStatement.setString(1,"%"+filter+"%");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Reference> references = new ArrayList<Reference>();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String url = resultSet.getString(2);
            String description = resultSet.getString(3);
            int minus = resultSet.getInt(4);
            int plus = resultSet.getInt(5);
            references.add(new Reference(id,url,description,minus,plus));
        }
        return  references;
    }

    public void addReference(Reference reference) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call AddReference(?,?,?,?)}");
        callableStatement.setString(1, reference.getUrl());
        callableStatement.setString(2,reference.getDescription());
        callableStatement.setInt(3,reference.getMinus());
        callableStatement.setInt(4,reference.getPlus());
        callableStatement.execute();
    }

    public void  updateReference(Reference reference) throws SQLException{
        String sqlRequest = "update our_refs set ";
        if (reference.getUrl() != null && reference.getDescription() != null)
            sqlRequest += "url = '"+reference.getUrl()+"', description = '"+reference.getDescription()+"'";
        if (reference.getPlus() != -1)
            sqlRequest += " plus = "+(reference.getPlus()+1);
        if (reference.getMinus() != -1)
            sqlRequest += " minuss = "+(reference.getMinus()+1);
        sqlRequest += " where id ="+reference.getId();
        connection.createStatement().executeUpdate(sqlRequest);
    }

    public void  deleteReference(int id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from Our_comment where refId = "+id);
        statement.executeUpdate("delete from our_refs where id = "+id);
    }
}
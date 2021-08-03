import POJO.TableModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DBConnect", urlPatterns = "/DBConnect")
public class DBConnect extends HttpServlet {

    final private String ip = "80.94.168.145";
    final private String port = "1433";
    String driver = "net.sourceforge.jtds.jdbc.Driver";
    final private String database = "Taraikovich_lab10";
    final private String username = "student";
    final private String password = "Pa$$w0rd";
    final private String url = "jdbc:jtds:sqlserver://" + ip + ":" + port + "/" + database;
    Connection connection;
    ResultSet resultSet;


    public void init() {
        try {
            Class.forName(driver);
            System.out.println("Before connection to database");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected to database");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String currentTask = req.getParameter("task");
        System.out.println("Current task: " + currentTask.toString());
        switch (currentTask) {
            case "1": {
                String query = "SELECT * FROM phones";
                Statement statement = null;
                try {
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery(query);
                    ArrayList<TableModel> tableModelList = new ArrayList<>();
                    while (resultSet.next()) {
                        tableModelList.add(new TableModel(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
                    }
                    req.setAttribute("tableModelList", tableModelList);

                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }

                RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/queryResult.jsp");
                reqDispatcher.forward(req, resp);
            }
            case "2": {
                String query = "SELECT * FROM phones WHERE price >=?";
                PreparedStatement preparedStatement = null;
                String reqCondition = req.getParameter("minPrice");
                try {
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, reqCondition);
                    resultSet = preparedStatement.executeQuery();

                    ArrayList<TableModel> tableModelList = new ArrayList<>();

                    while (resultSet.next()) {
                        tableModelList.add(new TableModel(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
                    }
                    req.setAttribute("tableModelList", tableModelList);
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/queryResult.jsp");
                reqDispatcher.forward(req, resp);
            }
            case "3": {
                try {
                    CallableStatement callableStatement = connection.prepareCall("dbo.phone_name ?");
                    callableStatement.setInt(1, Integer.parseInt(req.getParameter("id")));
                    ResultSet resultSet = callableStatement.executeQuery();

                    ArrayList<TableModel> tableModelList = new ArrayList<>();

                    while (resultSet.next()) {
                        tableModelList.add(new TableModel(resultSet.getString(1), resultSet.getString(2)));
                    }
                    req.setAttribute("tableModelList", tableModelList);
                    RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/queryResult.jsp");
                    reqDispatcher.forward(req, resp);

                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
        }
    }

}

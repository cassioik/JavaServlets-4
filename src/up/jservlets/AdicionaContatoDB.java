package up.jservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdicionaContatoDB
 */
public class AdicionaContatoDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection dbConnection;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaContatoDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		System.out.println(getServletName() + " : Initializing...");

		String driverClassName = config.getInitParameter("driverclassname");

		String dbURL = config.getInitParameter("dburl");

		String username = config.getInitParameter("username");

		String password = config.getInitParameter("password");

		//Load the driver class
		try {
			Class.forName(driverClassName);			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//get a database connection
		try {
			dbConnection = DriverManager.getConnection(dbURL,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Initialized "+dbConnection.toString());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try{
			dbConnection.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
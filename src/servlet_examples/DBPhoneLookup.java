package servlet_examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class DBPhoneLookup extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Connection con = null;
		// java本身
		res.setContentType("text/html ; charset=Big5");
		PrintWriter out = res.getWriter();

		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB2");
			Connection conn = ds.getConnection();

			// Load (and therefore register) the Oracle Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //驅動程式-第一類:
			// JDBC-ODBC橋接器

			// Get a Connection to the database
			// con =
			// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
			// "scott", "food1234");

			// Display the result set as a list
			out.println("<HTML><HEAD><TITLE>Phonebook</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<UL>");
			// while (rs.next()) {
			// out.println("<LI>" + rs.getString(1) + " " + rs.getString(2));
			// }

			// out.println(new HtmlResultSet(rs));

			out.println(new HtmlSQLResult("SELECT * FROM EMP2", con));
			// out.println(new HtmlSQLResult("DELETE * FROM EMP2", con));

			out.println("</UL>");
			out.println("</BODY></HTML>");
			// } catch (ClassNotFoundException e) {
			// out.println("Couldn't load database driver: " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			out.println("SQLException caught: " + e.getMessage());
		} finally {
			// Always close the database connection.
			try {
				if (con != null)
					con.close();
			} catch (SQLException ignored) {
			}
		}
	}
}

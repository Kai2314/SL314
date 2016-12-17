package servlet_examples;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

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
			// Load (and therefore register) the Oracle Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //驅動程式-第一類:
			// JDBC-ODBC橋接器

			// Get a Connection to the database
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "food1234");

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
		} catch (ClassNotFoundException e) {
			out.println("Couldn't load database driver: " + e.getMessage());
		} catch (SQLException e) {
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

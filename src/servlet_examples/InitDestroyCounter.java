package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
 * - 按右上X 跟 terminate一樣
 * - Tomcat 1.4 開始會有個事件，讓你按X時，自動運行事件 (注意:只有tomcat才有)
 * - 運行重點:
 * 		destory shutdown時自動運行
 * 		doGet 資料庫連絡
 * 		init 開啟的時後自動運行
 * 注意:
 * 	有個程式重載入，其他程式也會運行destory
 * 	
 */

public class InitDestroyCounter extends HttpServlet {

	int count;

	public void destroy() {// shutdown的時候會自動call destory
		super.destroy(); // entirely optional : 這行不寫也沒有關係
		saveState(); // 重點
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter();
		count++;
		out.println("Since the beginning, this servlet has been accessed " + count + " times.");
	}

	public void init() throws ServletException {
		// Try to load the initial count from our saved persistent state
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader("InitDestroyCounter.initial");
			bufferedReader = new BufferedReader(fileReader);
			String initial = bufferedReader.readLine();// BufferReader超好用方法
														// readline
			count = Integer.parseInt(initial);
			return;
		} catch (FileNotFoundException ignored) {
		} // no saved state
		catch (IOException ignored) {
		} // problem during read
		catch (NumberFormatException ignored) {
		} // corrupt saved state
		finally {
			// Make sure to close the file
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException ignored) {
			}
		}

		// No luck with the saved state, check for an init parameter
		String initial = getInitParameter("initial");
		try {
			count = Integer.parseInt(initial);
			return;
		} catch (NumberFormatException ignored) {
		} // null or non-integer value

		// Default to an initial count of "0"
		count = 0;
	}

	public void saveState() {
		// Try to save the accumulated count
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter("InitDestroyCounter.initial"); // 由左往右，預設為伺服器啟動位置；跟SE不一樣
			printWriter = new PrintWriter(fileWriter);// 由左往右
			printWriter.println(count); // 由右往左
			return;
		} catch (IOException e) { // problem during write
			// Log the exception. See Chapter 5.
		} finally {
			// Make sure to close the file
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
}

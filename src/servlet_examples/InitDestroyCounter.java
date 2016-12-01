package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
 * - ���k�WX �� terminate�@��
 * - Tomcat 1.4 �}�l�|���Өƥ�A���A��X�ɡA�۰ʹB��ƥ� (�`�N:�u��tomcat�~��)
 * - �B�歫�I:
 * 		destory shutdown�ɦ۰ʹB��
 * 		doGet ��Ʈw�s��
 * 		init �}�Ҫ��ɫ�۰ʹB��
 * �`�N:
 * 	���ӵ{�������J�A��L�{���]�|�B��destory
 * 	
 */

public class InitDestroyCounter extends HttpServlet {

	int count;

	public void destroy() {// shutdown���ɭԷ|�۰�call destory
		super.destroy(); // entirely optional : �o�椣�g�]�S�����Y
		saveState(); // ���I
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
			String initial = bufferedReader.readLine();// BufferReader�W�n�Τ�k
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
			fileWriter = new FileWriter("InitDestroyCounter.initial"); // �ѥ����k�A�w�]�����A���Ұʦ�m�F��SE���@��
			printWriter = new PrintWriter(fileWriter);// �ѥ����k
			printWriter.println(count); // �ѥk����
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

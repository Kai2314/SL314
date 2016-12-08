/*
   測試:   http://localhost:8081/SL314/ViewFile/images/tomcat.gif
   應注意     (※1)注意當有用到【額外路徑資訊】時必須使用【前置路徑對應】的設定
   同時注意(※2)web.xml內的<url-pattern>是<url-pattern>/ViewFile/*</url-pattern>                        
*/

package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.oreilly.servlet.ServletUtils;

public class ViewFile extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// Use a ServletOutputStream because we may pass binary information
		ServletOutputStream out = res.getOutputStream();// 二進位的出

		// Get the file to view
		/* ※第1個主要方法 */String file = req.getPathTranslated();

		// No file, nothing to view
		if (file == null) {
			out.println("No file to view");
			return;
		}

		/* ※第2個主要方法 :Get and set the type of the file */
		String contentType = getServletContext().getMimeType(
				file);/*
						 * file代表檔案 從"String file = req.getPathTranslated();"
						 */
		/* ※第3個主要方法 */
//		res.setContentType(
//				contentType);/*
//								 * "text/html;charset=Utf-8" 改為contentType ， 不寫死
//								 */
//		System.out.println(
//				"contentType=" + contentType);/*
//												 * print: contentType=image/gif
//												 * contentType=application/pdf
//												 */
		
		//---

		//#測試:下載功能:
		res.setContentType("application/force-download");
		res.setHeader("Content-Disposition", "attachment; filename=\""+(new File(file)).getName() + "\"");
		//#測試:加工功能:

		
		// Return the file
		try {
			ServletUtils.returnFile(file,
					out);/*
							 * 如果沒有這個呢? - 這邊才是真的在讀檔。前面只是拿到檔案而以。
							 */
		} catch (FileNotFoundException e) {
			out.println("File not found");
		} catch (IOException e) {
			out.println("Problem sending file: " + e.getMessage());
		}
	}
}

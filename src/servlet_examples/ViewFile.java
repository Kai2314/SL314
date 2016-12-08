/*
   ����:   http://localhost:8081/SL314/ViewFile/images/tomcat.gif
   http://localhost:8081/SL314/ViewFile/images/1.txt
   ���`�N     (��1)�`�N���Ψ�i�B�~���|��T�j�ɥ����ϥΡi�e�m���|�����j���]�w
   �P�ɪ`�N(��2)web.xml����<url-pattern>�O<url-pattern>/ViewFile/*</url-pattern>                        
*/

package servlet_examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.ServletUtils;

public class ViewFile extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// Use a ServletOutputStream because we may pass binary information
		ServletOutputStream out = res.getOutputStream();// �G�i�쪺�X
		PrintWriter pr = new PrintWriter(out, true);//?

		// Get the file to view
		/* ����1�ӥD�n��k */String file = req.getPathTranslated();

		// No file, nothing to view
		if (file == null) {
			out.println("No file to view");
			return;
		}

		/* ����2�ӥD�n��k :Get and set the type of the file */
		String contentType = getServletContext().getMimeType(
				file);/*
						 * file�N���ɮ� �q"String file = req.getPathTranslated();"
						 */
		/* ����3�ӥD�n��k */
//		res.setContentType(
//				contentType);/*
//								 * "text/html;charset=Utf-8" �אּcontentType �A ���g��
//								 */
//		System.out.println(
//				"contentType=" + contentType);/*
//												 * print: contentType=image/gif
//												 * contentType=application/pdf
//												 */
		
		//---

		//#����:�U���\��:
		res.setContentType("application/force-download");
		res.setHeader("Content-Disposition", "attachment; filename=\""+(new File(file)).getName() + "\"");
		//#����:�[�u�\��:
		pr.println("aaaaaaaaaaaaaaaaaa");
		
		// Return the file
		try {
			ServletUtils.returnFile(file,
					out);/*
							 * �p�G�S���o�өO? - �o��~�O�u���bŪ�ɡC�e���u�O�����ɮצӥH�C
							 */
		} catch (FileNotFoundException e) {
			out.println("File not found");
		} catch (IOException e) {
			out.println("Problem sending file: " + e.getMessage());
		}
		pr.println("<br>bbbbbbbbb");
		pr.println("ccccccccc");
	}
}

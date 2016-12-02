package han;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScheduleTimer extends HttpServlet {
	Timer timer = new Timer();
	HttpServletRequest req;
	HttpServletResponse res;

	public void doGet(HttpServletRequest areq, HttpServletResponse ares) throws ServletException, IOException {
		req = areq;
		res = ares;
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter();

		out.print("<b>Test</b>");
	}

	public void init() {
		MyTimerTask myTimerTask = new MyTimerTask();
		Calendar cal = new GregorianCalendar();
		Date date = cal.getTime();
		// System.out.println(date);//print:Sat Dec 03 02:30:46 CST 2016
		timer.scheduleAtFixedRate(myTimerTask, date, 1000);// delay代表從1970年開始，需要Date類型
	}

	class MyTimerTask extends TimerTask {
		int count = 0;

		public void run() {
			/*
			 * System.out.println(res); System.out.println(req); Print:
			 * org.apache.catalina.connector.ResponseFacade@4787a1e
			 * org.apache.catalina.connector.RequestFacade@417ae4f5
			 */
			if (res != null || req != null) {
				res.setContentType("text/plain");
				PrintWriter out = null;
				try {
					out = res.getWriter();
				} catch (IOException e) {
					e.printStackTrace();
				}
				out.print("<b>Test</b>");
			}

			System.out.println(++count);
		}
	}

}

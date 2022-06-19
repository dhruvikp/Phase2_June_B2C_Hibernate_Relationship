package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.entity.Student;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ReadStudentServlet
 */
@WebServlet("/read-student")
public class ReadStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		List<Student> students = session.createQuery("from Student").list();
		
		out.println("<h1>Student List :-</h1>");
		out.println("<style> table,td,th { border:2px solid green; padding:10px; } </style>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th> Student Id </th>");
		out.println("<th> Student First Name </th>");
		out.println("<th> Student Last Name </th>");
		out.println("<th> Student Phone Numbers </th>");
		out.println("<th> Student Course Names </th>");
		out.println("<th> Student Address </th>");
		out.println("</tr>");
		
		for(Student st: students) {
			out.println("<tr>");
			out.println("<td>"+st.getStudent_id()+"</td>");
			out.println("<td>"+st.getFname()+"</td>");
			out.println("<td>"+st.getLname()+"</td>");
			out.println("<td>"+st.getPhones()+"</td>");
			out.println("<td>"+st.getCourse()+"</td>");
			out.println("<td>"+st.getAddress()+"</td>");
			out.println("</tr>");
		}
		out.println("</table></body></html>");
		session.close();
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

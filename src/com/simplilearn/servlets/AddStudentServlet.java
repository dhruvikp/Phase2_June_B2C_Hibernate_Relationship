package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.Address;
import com.simplilearn.entity.Course;
import com.simplilearn.entity.PhoneNumber;
import com.simplilearn.entity.Student;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("add-student.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student student = populateStudent(request);

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(student);

		tx.commit();
		session.close();

		PrintWriter out = response.getWriter();
		out.append("<html><body>");
		out.println("Records saved successfully");
		out.append("</html></body>");
	}

	private Student populateStudent(HttpServletRequest request) {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");

		Student student = new Student();

		// Phone1
		String phoneNum1 = request.getParameter("phone_1");
		String phoneType1 = request.getParameter("types1");
		PhoneNumber phoneNumber1 = new PhoneNumber();
		phoneNumber1.setPhoneNumber(phoneNum1);
		phoneNumber1.setPhoneType(phoneType1);
		phoneNumber1.setStudent(student);

		// Phone2
		String phoneNum2 = request.getParameter("phone_2");
		String phoneType2 = request.getParameter("types2");
		PhoneNumber phoneNumber2 = new PhoneNumber();
		phoneNumber2.setPhoneNumber(phoneNum2);
		phoneNumber2.setPhoneType(phoneType2);
		phoneNumber2.setStudent(student);

		// Phone3
		String phoneNum3 = request.getParameter("phone_3");
		String phoneType3 = request.getParameter("types3");
		PhoneNumber phoneNumber3 = new PhoneNumber();
		phoneNumber3.setPhoneNumber(phoneNum3);
		phoneNumber3.setPhoneType(phoneType3);
		phoneNumber3.setStudent(student);

		List<PhoneNumber> phones = new ArrayList<>();
		phones.add(phoneNumber1);
		phones.add(phoneNumber2);
		phones.add(phoneNumber3);

		student.setFname(fname);
		student.setLname(lname);
		student.setPhones(phones);

		List<Student> students = new ArrayList<>();
		students.add(student);

		// Add details for courses

		// Read Course1
		String courseName1 = request.getParameter("course_1");
		String courseType1 = request.getParameter("course_type_1");

		Course course1 = new Course();
		course1.setCourseName(courseName1);
		course1.setCourseType(courseType1);
		course1.setStudents(students);

		// Read Course2
		String courseName2 = request.getParameter("course_2");
		String courseType2 = request.getParameter("course_type_2");

		Course course2 = new Course();
		course2.setCourseName(courseName2);
		course2.setCourseType(courseType2);
		course2.setStudents(students);

		// Read Course3
		String courseName3 = request.getParameter("course_3");
		String courseType3 = request.getParameter("course_type_3");

		Course course3 = new Course();
		course3.setCourseName(courseName3);
		course3.setCourseType(courseType3);
		course2.setStudents(students);

		List<Course> courses = new ArrayList<>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);

		student.setCourse(courses);
		
		// Populate address object
		
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		
		Address addr = new Address();
		addr.setState(state);
		addr.setCity(city);
		addr.setStreet(street);
		
		student.setAddress(addr);
		
		return student;
	}

}

package com.welcome;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/newStudent")
public class NewStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentName = request.getParameter("studentName");
        String studentId = request.getParameter("studentId");
        String dept = request.getParameter("dept");
        String academicLevel = request.getParameter("academicLevel");
        String startingSemester = request.getParameter("startingSemester");

        // Save the student information to a CSV file
        try (FileWriter writer = new FileWriter("student_info.csv", true)) {
            writer.append(studentName)
                  .append(',')
                  .append(studentId)
                  .append(',')
                  .append(dept)
                  .append(',')
                  .append(academicLevel)
                  .append(',')
                  .append(startingSemester)
                  .append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        response.getWriter().println("<h1>Student Information Submitted</h1>");
        response.getWriter().println("<p>Name: " + studentName + "</p>");
        response.getWriter().println("<p>ID: " + studentId + "</p>");
        response.getWriter().println("<p>Department: " + dept + "</p>");
        response.getWriter().println("<p>Academic Level: " + academicLevel + "</p>");
        response.getWriter().println("<p>Starting Semester: " + startingSemester + "</p>");
    }
}
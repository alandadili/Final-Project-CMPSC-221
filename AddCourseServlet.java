import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addCourse")
public class AddCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseName = request.getParameter("courseName");
        String courseCode = request.getParameter("courseCode");
        String instructor = request.getParameter("instructor");
        String semester = request.getParameter("semester");

        // Save the course information to a CSV file
        try (FileWriter writer = new FileWriter("course_info.csv", true)) {
            writer.append(courseName)
                  .append(',')
                  .append(courseCode)
                  .append(',')
                  .append(instructor)
                  .append(',')
                  .append(semester)
                  .append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        response.getWriter().println("<h1>Course Information Submitted</h1>");
        response.getWriter().println("<p>Course Name: " + courseName + "</p>");
        response.getWriter().println("<p>Course Code: " + courseCode + "</p>");
        response.getWriter().println("<p>Instructor: " + instructor + "</p>");
        response.getWriter().println("<p>Semester: " + semester + "</p>");
    }
}
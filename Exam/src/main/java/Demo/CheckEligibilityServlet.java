package Demo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkEligibility")
public class CheckEligibilityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int attendanceThreshold = Integer.parseInt(request.getParameter("attendanceThreshold"));
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ExamManagementDB", "root", "heist");
            String query = "SELECT * FROM Students WHERE attendance >= ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, attendanceThreshold);
            ResultSet rs = stmt.executeQuery();
            
            request.setAttribute("resultSet", rs);
            request.getRequestDispatcher("eligibleStudents.jsp").forward(request, response);

            // We should not close the ResultSet and PreparedStatement here
            // because they are needed in the JSP. This will be done after the
            // forward completes.
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
}
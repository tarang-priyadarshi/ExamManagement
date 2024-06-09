<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Eligible Students</title>
</head>
<body>
    <h1>Eligible Students</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Attendance</th>
        </tr>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("resultSet");
            try {
                while (rs.next()) {
                    out.println("<tr><td>" + rs.getInt("student_id") + "</td><td>" + rs.getString("name") + "</td><td>" + rs.getString("email") + "</td><td>" + rs.getInt("attendance") + "</td></tr>");
                }
                rs.close();  // Close ResultSet here
            } catch (SQLException e) {
                e.printStackTrace();
            }
        %>
    </table>
</body>
</html>
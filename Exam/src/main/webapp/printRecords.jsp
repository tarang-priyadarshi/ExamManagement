<%@ page import="java.sql.*" %>
<html>
<head>
    <title>All Student Records</title>
</head>
<body>
    <h1>All Student Records</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Attendance</th>
        </tr>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("resultSet");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("student_id") + "</td><td>" + rs.getString("name") + "</td><td>" + rs.getString("email") + "</td><td>" + rs.getInt("attendance") + "</td></tr>");
            }
        %>
    </table>
</body>
</html>
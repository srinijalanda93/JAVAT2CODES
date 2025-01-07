package Prj;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//public class Attendee {
//
//}


@WebServlet("/Attendee")
public class JavPrj extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/christattendence";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            switch (action) {
                case "add":
                    addAttendee(request, response);
                    break;
                case "edit":
                    editAttendee(request, response);
                    break;
                case "delete":
                    deleteAttendee(request, response);
                    break;
                case "search":
                    searchAttendee(request, response);
                    break;
                case "stats":
                    generateStatistics(request, response);
                    break;
                default:
                    response.getWriter().write("Invalid action.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error: " + e.getMessage());
        }
    }

    private void addAttendee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String contactNumber = request.getParameter("contactNumber");
        String country = request.getParameter("country");

        String sql = "INSERT INTO attendees (FullName, Email, ContactNumber, Country) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fullName);
            stmt.setString(2, email);
            stmt.setString(3, contactNumber);
            stmt.setString(4, country);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                response.getWriter().write("Attendee added successfully.");
            } else {
                response.getWriter().write("Failed to add attendee.");
            }
        }
    }

    private void editAttendee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int attendeeID = Integer.parseInt(request.getParameter("attendeeID"));
        String email = request.getParameter("email");
        String contactNumber = request.getParameter("contactNumber");

        String sql = "UPDATE attendees SET Email = ?, ContactNumber = ? WHERE AttendeeID = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, contactNumber);
            stmt.setInt(3, attendeeID);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                response.getWriter().write("Attendee updated successfully.");
            } else {
                response.getWriter().write("Failed to update attendee.");
            }
        }
    }

    private void deleteAttendee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int attendeeID = Integer.parseInt(request.getParameter("attendeeID"));

        String sql = "DELETE FROM Attendees WHERE AttendeeID = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, attendeeID);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                response.getWriter().write("Attendee deleted successfully.");
            } else {
                response.getWriter().write("Failed to delete attendee.");
            }
        }
    }

    private void searchAttendee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String searchBy = request.getParameter("searchBy");
        String value = request.getParameter("value");

        String sql;
        if ("id".equals(searchBy)) {
            sql = "SELECT * FROM Attendees WHERE AttendeeID = ?";
        } else if ("name".equals(searchBy)) {
            sql = "SELECT * FROM Attendees WHERE FullName LIKE ?";
            value = "%" + value + "%";
        } else if ("country".equals(searchBy)) {
            sql = "SELECT * FROM Attendees WHERE Country = ?";
        } else {
            response.getWriter().write("Invalid search criteria.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, value);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                response.getWriter().write("ID: " + rs.getInt("AttendeeID") + ", Name: " + rs.getString("FullName") + ", Email: " + rs.getString("Email") + ", Country: " + rs.getString("Country") + "\n");
            }
        }
    }

    private void generateStatistics(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sql = "CALL GetAttendeeStatistics()";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             CallableStatement stmt = conn.prepareCall(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                response.getWriter().write("Country: " + rs.getString("Country") + ", Count: " + rs.getInt("AttendeeCount") + "\n");
            }
        }
    }
}


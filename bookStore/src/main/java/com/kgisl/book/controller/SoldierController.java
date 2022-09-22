package com.kgisl.book.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgisl.book.entity.Soldier;

public class SoldierController extends HttpServlet {
    Soldier soldier = null;
    List<Soldier> lsoldier = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertSoldier(request, response);
                    break;
                case "/delete":
                    deleteSoldier(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateSoldier(request, response);
                    break;
                default:
                    listSoldier(request, response);
                    break;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    private void listSoldier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {

            lsoldier = new ArrayList<Soldier>();
            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery("select * from soldiers");
            while (rset.next()) {
                lsoldier.add(new Soldier(rset.getInt("soldier_id"), rset.getString("first_name"), rset.getString("dob"),
                        rset.getString("gender"), rset.getString("join_date"), rset.getInt("general_id"),
                        rset.getInt("event_id")));
            }
            stmt.close();
            con.close();
            request.setAttribute("soldier", lsoldier);
            RequestDispatcher dis = request.getRequestDispatcher("soldierform.jsp");
            dis.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("soldierlist.jsp");
        dispatcher.forward(request, response);
    }

    public void insertSoldier(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            int soldier_id = Integer.parseInt(req.getParameter("soldier_id"));
            String first_name = req.getParameter("first_name");
            String dob = req.getParameter("dob");
            String gender = req.getParameter("gender");
            String join_date = req.getParameter("join_date");
            int general_id = Integer.parseInt(req.getParameter("general_id"));
            int event_id = Integer.parseInt(req.getParameter("event_id"));
            soldier = new Soldier(soldier_id, first_name, dob, gender, join_date, general_id, event_id);
            String sql = "insert into soldiers (soldier_id,first_name,DOB,gender,join_date,general_id,event_id)values (?,?,?,?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, soldier.getSoldier_id());
            statement.setString(2, soldier.getFirst_name());
            statement.setString(3, soldier.getDob());
            statement.setString(4, soldier.getGender());
            statement.setString(5, soldier.getJoin_date());
            statement.setInt(6, soldier.getGeneral_id());
            statement.setInt(7, soldier.getEvent_id());

            statement.executeUpdate();
            statement.close();
            con.close();
            resp.sendRedirect("/list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSoldier(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            int soldier_id = Integer.parseInt(req.getParameter("soldier_id"));
            soldier = new Soldier(soldier_id);
            String sql = "DELETE FROM soldiers where soldier_id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, soldier.getSoldier_id());
            statement.executeUpdate();
            statement.close();
            con.close();
            resp.sendRedirect("/list");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            int soldier_id = Integer.parseInt(request.getParameter("soldier_id"));
            Soldier soldier = null;
            String sql = "SELECT * FROM soldiers WHERE soldier_id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, soldier_id);
            ResultSet rset = statement.executeQuery();
            if (rset.next()) {
                soldier = new Soldier(rset.getInt("soldier_id"), rset.getString("first_name"), rset.getString("dob"),
                        rset.getString("gender"), rset.getString("join_date"), rset.getInt("general_id"),
                        rset.getInt("event_id"));
            }
            rset.close();
            statement.close();
            con.close();
            RequestDispatcher dispatcher = request.getRequestDispatcher("soldierlist.jsp");
            request.setAttribute("soldier", soldier);
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSoldier(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            int soldier_id = Integer.parseInt(req.getParameter("soldier_id"));
            String first_name = req.getParameter("first_name");
            String dob = req.getParameter("dob");
            String gender = req.getParameter("gender");
            String join_date = req.getParameter("join_date");
            int general_id = Integer.parseInt(req.getParameter("general_id"));
            int event_id = Integer.parseInt(req.getParameter("event_id"));
            soldier = new Soldier(soldier_id, first_name, dob, gender, join_date, general_id, event_id);
            String sql = "UPDATE soldiers SET first_name=?,dob=?,gender=?,join_date=?,general_id=?,event_id=? WHERE soldier_id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, soldier.getFirst_name());
            statement.setString(2, soldier.getDob());
            statement.setString(3, soldier.getGender());
            statement.setString(4, soldier.getJoin_date());
            statement.setInt(5, soldier.getGeneral_id());
            statement.setInt(6, soldier.getEvent_id());
            statement.setInt(7, soldier.getSoldier_id());
            statement.executeUpdate();
            statement.close();
            con.close();
            resp.sendRedirect("/list");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

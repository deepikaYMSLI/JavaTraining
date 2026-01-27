package com.trainee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trainee.dto.Trainee;
import com.trainee.exceptions.DaoException;
import com.trainee.util.ConnectionFactory;

public class TraineeDaoJdbcImpl implements TraineeDao {

   
    public void addTrainee(Trainee trainee) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement(
                    "INSERT INTO trainee (trainee_name, branch, percentage) VALUES (?, ?, ?)");

            ps.setString(1, trainee.getTraineeName());
            ps.setString(2, trainee.getBranch());
            ps.setDouble(3, trainee.getPercentage());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("Insert failed", e);
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
            }
        }
    }

    
    public Trainee findTraineeById(int traineeId) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Trainee trainee = null;

        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("SELECT * FROM trainee WHERE trainee_id=?");
            ps.setInt(1, traineeId);

            rs = ps.executeQuery();

            if (rs.next()) {
                trainee = new Trainee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4));
            }

        } catch (SQLException e) {
            throw new DaoException("Fetch failed", e);
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
            }
        }
        return trainee;
    }
}


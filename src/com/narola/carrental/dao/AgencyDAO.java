package com.narola.carrental.dao;

import com.narola.carrental.exception.DAOException;
import com.narola.carrental.model.AgencyDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgencyDAO {

    public void addAgency(int UserId, AgencyDetails agencyDetails, int addressId) throws DAOException {
        try {
            String sql = "insert into agency(agency_Name,GST_Number,user_Id,address_id) values (?,?,?,?)";

            PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(sql);
            stmt.setString(1, agencyDetails.getAgencyName());
            stmt.setString(2, agencyDetails.getGSTNumber());
            stmt.setInt(3, UserId);
            stmt.setInt(4, addressId);
            stmt.executeUpdate();
            System.out.println("----- Agency Register Successfully-----");
        } catch (SQLException e) {
            throw new DAOException("Error while connecting");
        }
    }

    public AgencyDetails viewAgencyDetails(int UserId) {
        AgencyDetails agencyDetails = null;
        try {
            String sql = "select * from agency where User_id=?";
            PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(sql);
            stmt.setInt(1, UserId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                agencyDetails = new AgencyDetails();
                agencyDetails.setAgencyDetailsId(rs.getInt(1));
                agencyDetails.setAgencyName(rs.getString(2));
                agencyDetails.setGSTNumber(rs.getString(3));
                agencyDetails.setUserId(rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agencyDetails;
    }


}

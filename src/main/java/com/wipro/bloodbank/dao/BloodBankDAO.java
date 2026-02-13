package com.wipro.bloodbank.dao;

import com.wipro.bloodbank.bean.BloodBankBean;
import com.wipro.bloodbank.util.DBUtil;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BloodBankDAO {

    public String createRecord(BloodBankBean bloodBean) {
        String result = "FAIL";
        Connection con = DBUtil.getDBConnection();

        String query = "INSERT INTO BLOODBANK_TBL (RECORDID, DONORNAME, BLOODGROUP, DONATION_DATE, AGE, CONTACT, REMARKS) VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, bloodBean.getRecordId());
            ps.setString(2, bloodBean.getDonorName());
            ps.setString(3, bloodBean.getBloodGroup());
            ps.setDate(4, bloodBean.getDonationDate());
            ps.setInt(5, bloodBean.getAge());
            ps.setString(6, bloodBean.getContact());
            ps.setString(7, bloodBean.getRemarks());

            int row = ps.executeUpdate();

            if (row > 0) {
                result = bloodBean.getRecordId();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public BloodBankBean fetchRecord(String donorName, java.util.Date donationDate) {

        BloodBankBean bean = null;
        Connection con = DBUtil.getDBConnection();

        String query = "SELECT * FROM BLOODBANK_TBL WHERE DONORNAME = ? AND DONATION_DATE = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, donorName);
            ps.setDate(2, new java.sql.Date(donationDate.getTime()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bean = new BloodBankBean();

                bean.setRecordId(rs.getString(1));
                bean.setDonorName(rs.getString(2));
                bean.setBloodGroup(rs.getString(3));
                bean.setDonationDate(rs.getDate(4));
                bean.setAge(rs.getInt(5));
                bean.setContact(rs.getString(6));
                bean.setRemarks(rs.getString(7));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

    public String generateRecordID(String donorName, java.util.Date donationDate) {

        String recordId = "";
        Connection con = DBUtil.getDBConnection();

        try {

            DateFormat format = new SimpleDateFormat("yyyyMMdd");
            String datePart = format.format(donationDate);
            String namePart = donorName.substring(0, 2).toUpperCase();

            String query = "SELECT BLOODBANK_SEQ.NEXTVAL FROM DUAL";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                int seq = rs.getInt(1);
                recordId = datePart + namePart + seq;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return recordId;
    }

    public boolean recordExists(String donorName, java.util.Date donationDate) {
        return fetchRecord(donorName, donationDate) != null;
    }

    public List<BloodBankBean> fetchAllRecords() {

        List<BloodBankBean> list = new ArrayList<>();
        Connection con = DBUtil.getDBConnection();

        String query = "SELECT * FROM BLOODBANK_TBL";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                BloodBankBean bean = new BloodBankBean();

                bean.setRecordId(rs.getString(1));
                bean.setDonorName(rs.getString(2));
                bean.setBloodGroup(rs.getString(3));
                bean.setDonationDate(rs.getDate(4));
                bean.setAge(rs.getInt(5));
                bean.setContact(rs.getString(6));
                bean.setRemarks(rs.getString(7));

                list.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}

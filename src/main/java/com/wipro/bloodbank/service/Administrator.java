package com.wipro.bloodbank.service;

import java.util.Date;
import java.util.List;

import com.wipro.bloodbank.bean.BloodBankBean;
import com.wipro.bloodbank.dao.BloodBankDAO;
import com.wipro.bloodbank.util.InvalidInputException;

public class Administrator {

    BloodBankDAO dao = new BloodBankDAO();

    public String addRecord(BloodBankBean bloodBean) {

        try {
            if (bloodBean == null || bloodBean.getDonorName() == null || bloodBean.getDonationDate() == null) {
                throw new InvalidInputException();
            }
            if (bloodBean.getDonorName().length() < 2) {
                return "INVALID";
            }
            if (dao.recordExists(bloodBean.getDonorName(),bloodBean.getDonationDate()))
                return "EXISTS";

            String id = dao.generateRecordID(bloodBean.getDonorName(),bloodBean.getDonationDate());
            bloodBean.setRecordId(id);
            return dao.createRecord(bloodBean);
        } catch (InvalidInputException e) {
            return "INVALID";
        }
    }
    public BloodBankBean viewRecord(String donorName, Date donationDate) {
        return dao.fetchRecord(donorName, donationDate);
    }

    public List<BloodBankBean> viewAllRecords() {
        return dao.fetchAllRecords();
    }
}

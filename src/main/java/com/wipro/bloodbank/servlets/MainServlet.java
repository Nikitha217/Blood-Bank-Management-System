package com.wipro.bloodbank.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.wipro.bloodbank.bean.BloodBankBean;
import com.wipro.bloodbank.service.Administrator;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Administrator admin = new Administrator();
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        try {
            if ("newRecord".equals(operation)) {
                BloodBankBean bean = new BloodBankBean();
                bean.setDonorName(request.getParameter("donorName"));
                bean.setBloodGroup(request.getParameter("bloodGroup"));
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("donationDate"));
                bean.setDonationDate(date);
                bean.setAge(Integer.parseInt(request.getParameter("age")));
                bean.setContact(request.getParameter("contact"));
                bean.setRemarks(request.getParameter("remarks"));

                String result = admin.addRecord(bean);

                if (result.equals("FAIL") || result.equals("INVALID") || result.equals("EXISTS")) {

                    response.sendRedirect("error.html");

                } else {
                    response.sendRedirect("success.html");
                }

            }

            else if ("viewRecord".equals(operation)) {

                String donorName = request.getParameter("donorName");

                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("donationDate"));
                BloodBankBean bean = admin.viewRecord(donorName, date);
                if (bean == null) {
                    request.setAttribute("message", "No matching records exist!");
                } else {
                    request.setAttribute("bean", bean);
                }
                RequestDispatcher rd =request.getRequestDispatcher("displayDonor.jsp");
                rd.forward(request, response);
            }
            else if ("viewAllRecords".equals(operation)) {
                List<BloodBankBean> list = admin.viewAllRecords();

                if (list == null || list.isEmpty()) {
                    request.setAttribute("message", "No records available!");
                } else {
                    request.setAttribute("list", list);
                }
                RequestDispatcher rd = request.getRequestDispatcher("displayAllDonors.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
}

<%@ page import="java.util.List" %>
<%@ page import="com.wipro.bloodbank.bean.BloodBankBean" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Donors</title>
</head>
<body>
<h3>All Donor Records</h3>
<%
    List<BloodBankBean> list = (List<BloodBankBean>) request.getAttribute("list");
    String message = (String) request.getAttribute("message");

    if (list != null && !list.isEmpty()) {

        for (BloodBankBean bean : list) {
%>
Record ID: <%= bean.getRecordId() %><br>
Donor Name: <%= bean.getDonorName() %><br>
Blood Group: <%= bean.getBloodGroup() %><br>
Donation Date: <%= bean.getDonationDate() %><br>
Age: <%= bean.getAge() %><br>
Contact: <%= bean.getContact() %><br>
Remarks: <%= bean.getRemarks() %><br>
--------------------------------------<br><br>

<%
        }

    } else {
%>
<%= message %>
<%
    }
%>
</body>
</html>

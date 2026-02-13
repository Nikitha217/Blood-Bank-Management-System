<%@ page import="com.wipro.bloodbank.bean.BloodBankBean" %>

<!DOCTYPE html>
<html>
<head>
    <title>Donor Details</title>
</head>
<body>
<h3>Donor Details</h3>
<%
    BloodBankBean bean = (BloodBankBean) request.getAttribute("bean");
    String message = (String) request.getAttribute("message");
    if (bean != null) {
%>
Record ID: <%= bean.getRecordId() %><br><br>
Donor Name: <%= bean.getDonorName() %><br><br>
Blood Group: <%= bean.getBloodGroup() %><br><br>
Donation Date: <%= bean.getDonationDate() %><br><br>
Age: <%= bean.getAge() %><br><br>
Contact: <%= bean.getContact() %><br><br>
Remarks: <%= bean.getRemarks() %><br><br>
<%
    } else {
%>
<%= message %>
<%
    }
%>
</body>
</html>

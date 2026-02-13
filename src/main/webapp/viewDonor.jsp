<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Donor</title>
</head>
<body>
<h2>View Donor Record</h2>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="viewRecord">
Donor Name:
<input type="text" name="donorName" required><br><br>
Donation Date:
<input type="date" name="donationDate" required><br><br>
<input type="submit" value="Search">
</form>
<br>
<a href="menu.html">Back to Menu</a>
</body>
</html>

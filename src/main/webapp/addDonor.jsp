<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Donor</title>
</head>
<body>
<h2>Add Donor Record</h2>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="newRecord">
Donor Name: <input type="text" name="donorName" required><br><br>
Blood Group:
<select name="bloodGroup" required>
<option value="A+">A+</option>
<option value="A-">A-</option>
<option value="B+">B+</option>
<option value="B-">B-</option>
<option value="O+">O+</option>
<option value="O-">O-</option>
<option value="AB+">AB+</option>
<option value="AB-">AB-</option>
</select><br><br>
Donation Date:
<input type="date" name="donationDate" required><br><br>
Age:
<input type="number" name="age" required><br><br>
Contact:
<input type="text" name="contact" required><br><br>
Remarks:
<input type="text" name="remarks"><br><br>
<input type="submit" value="Add Record">
</form>
<br>
<a href="menu.html">Back to Menu</a>
</body>
</html>

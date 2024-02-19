<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Title Page</title>
</head>
<body>
<h1>Welcome to Alien Student's World</h1>

<form action="displayStudents" method="get">
    <h3>Show the list of students</h3>
    <input type="submit">
</form>

<form action="addStudent" method="post">
    <h3>You can add a Alien to the Gang</h3>
    Enter your Student id : <input type="text" name="sid"><br>
    Enter your Student name : <input type="text" name="sname"><br>
    <input type="submit">
</form>

<form action="getStudentByID" method="get">
    <h3>Find an Alien by ID</h3>
    Enter your Alien id : <input type="text" name="sid"><br>
    <input type="submit">
</form>

<form action="getStudentByName" method="get">
    <h3>Find an Alien by Name</h3>
    Enter the Alien name : <input type="text" name="sname"><br>
    <input type="submit">
</form>

</body>
</html>
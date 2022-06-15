<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="model.ListStudent" %>
<%@ page import="model.Student" %>
<%@ page import="model.Score" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title> Practice week #1: Student Management </title>
</head>

<body>
	<!-- List of students section -->
	
	<div align="left">
        <table  id="tableListStudent" border="1" cellpadding="5">
            <caption>List of students</caption>
        </table>
    </div>
    <!-- Special students's information section -->
	<p>Largest GPA: <span id="smartestStudent"></span ></p>
	<p>Lowest GPA: <span id="stupidStudent"></span></p>
	<h3>Add new student</h3>
	<form action="index" method="post">
		<p>Name: </p>
        <input type="text" name="studentNameInput">
        <p>Age: </p>
        <input type="text" name="studentAgeInput">
        <p>Classes: </p>
        <input type="text" name="studentClassesInput">
        <p>Province: </p>
        <input type="text" name="studentProvinceInput">
        <p>Math score: </p>
        <input type="text" name="mathScoreInput">
        <p>English score: </p>
        <input type="text" name="englishScoreInput">
        <p>Physical score: </p>
        <input type="text" name="physicalScoreInput">
        <input type="submit"/>
	</form>
	</body>
	<script type="text/javascript">
		var listStudent = '<%= request.getAttribute("listStudent") %>';
		listStudent = JSON.parse(listStudent);
		
		var tableListStudent = document.getElementById("tableListStudent");
		// show rows of table
		students = listStudent["students"]
		for (i = 0; i < students.length; i++) {
			var row = tableListStudent.insertRow(0);
			var cellName = row.insertCell(0);
			var cellAge = row.insertCell(1);
			var cellClasses = row.insertCell(2);
			var cellProvince = row.insertCell(3);
			cellName.innerHTML = students[i].name;
			cellAge.innerHTML = students[i].age;
			cellClasses.innerHTML = students[i].classes;
			cellProvince.innerHTML = students[i].province;
			scores = listStudent["students"][i]["scores"];
			for (j = 4; j < 4 + scores.length; j++) {
				var cellScore = row.insertCell(j);
				cellScore.innerHTML = scores[j-4].point;
			}
		}
		// show header of table
		sampleScore = listStudent["students"][0]["scores"];
		headerListStudent = tableListStudent.createTHead();
		var rowListStudent = headerListStudent.insertRow(0);
		for (i = sampleScore.length - 1; i >= 0; i--) {
			var cell = rowListStudent.insertCell(0);
			cell.innerHTML = sampleScore[i].name;
		}
		var cellProvince = rowListStudent.insertCell(0);
		cellProvince.innerHTML = "Province";
		var cellClasses = rowListStudent.insertCell(0);
		cellClasses.innerHTML = "Classes";
		var cellAge = rowListStudent.insertCell(0);
		cellAge.innerHTML = "Age";
		var cellName = rowListStudent.insertCell(0);
		cellName.innerHTML = "Name";
		// show special student
		smartestStudent = listStudent["smartestStudent"].name;
		stupidStudent = listStudent["stupidStudent"].name;
		document.getElementById("smartestStudent").innerHTML = smartestStudent;
		document.getElementById("stupidStudent").innerHTML = stupidStudent;
	</script>
</html>
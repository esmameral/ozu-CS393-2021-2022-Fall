function validateForm() {
	var desc = document.getElementById("description").value;
	var type = document.getElementById("type").value;
	if (desc == null || desc == "") {
		alert("Please enter course description!")
		return false;
	}

	if (type == null || type == "0") {
		alert("Please select course type!")
		return false;
	}
	saveCourse();
	return true;
}

function saveCourse() {
	var code = document.getElementById("code").value;
	var name = document.getElementById("name").value;
	var credit = document.getElementById("credit").value;
	var desc = document.getElementById("description").value;
	var type = document.getElementById("type").value;
	var course = {
		code: code,
		"name": name,
		"credit": credit,
		"type": type,
		"description": desc
	}
	
	console.log("Course info:" + JSON.stringify(course));
	axios.post('http://localhost:9090/courses', course)
      .then(res => {
        console.log(res);
        console.log(res.data);
      })
	return true;
}


function getCourses() {

	axios.get("http://localhost:9090/courses")
		.then(res => {
			const courses = res.data;
			printCourses(courses);

		})

}

function printCourses(courses) {

	var tableStr = "<table class=\"table table-dark table-striped\">";
	tableStr += "<thead>";
	tableStr += "<tr>";
	tableStr += "	<th scope=\"col\">Code</th>";
	tableStr += "	<th scope=\"col\">Name</th>";
	tableStr += "	<th scope=\"col\">Credits</th>";
	tableStr += "</tr>";
	tableStr += "</thead>";
	tableStr += "<tbody>";

	for (c of courses) {
		tableStr += " <tr>";
		tableStr += "<td>" + c.code + "</td>";
		tableStr += "<td>" + c.name + "</td>";
		tableStr += "<td>" + c.credit + "</td>";
		tableStr += "</tr>";
	}
	tableStr += "	</tbody>";
	tableStr += "</table>";
	document.getElementById("courses").innerHTML = tableStr;
}



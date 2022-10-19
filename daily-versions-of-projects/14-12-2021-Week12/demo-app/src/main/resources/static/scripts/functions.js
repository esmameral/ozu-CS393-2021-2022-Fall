function validateForm() {
	var desc = document.getElementById("description").value;
	var type = document.getElementById("type").value;
	if (desc == null || desc == "") {
		alert("Please enter course description!")
		return false;
	}

	if (type== null || type== "0") {
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
		"code": code,
		"name": name,
		"credit": credit,
		"type": type,
		"description": desc
	}
	alert("Course info:"+JSON.stringify(course));
	console.log("Course info:"+JSON.stringify(course));
	return true;
}

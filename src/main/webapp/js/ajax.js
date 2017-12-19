// pathname is contextRoot/path/path/ so we want to get [1] 
// that is where contextRoot is
// [0] has "" as a result of split 
var contextRoot = "/" + window.location.pathname.split('/')[1];

function categorySubmit() {
	var sendToSend = JSON.stringify(serializeObject($('#categoryForm')));
	$.ajax({
		url : contextRoot + '/categories/add',
		type : 'POST',
		dataType : "json", // Accepts
		data : sendToSend,
		contentType : 'application/json', // Sends
		success : function(category) {
			var newOption = "<option value='" + category.id + "' selected>" + category.name + "</option>";
			$("#categories").append(newOption);
			resetForm('categoryForm');
		},

		error : function(jqXHR, textStatus, exception) {
			alert(jqXHR.responseJSON.message);
		}
	});
}

toggle_visibility = function(id) {
	var e = document.getElementById(id);
	if (e.style.display == 'block')
		e.style.display = 'none';
	else
		e.style.display = 'block';
}

make_hidden = function(id) {
	var e = document.getElementById(id);
	e.style.display = 'none';
}

make_visible = function(id) {
	var e = document.getElementById(id);
	e.style.display = 'block';
}

resetForm = function(id) {
	var e = document.getElementById(id);
	$(e)[0].reset();

}

// Translate form to array
// Then put in JSON format
function serializeObject(form) {
	var jsonObject = {};
	var array = form.serializeArray();
	$.each(array, function() {
		jsonObject[this.name] = this.value;
	});
	return jsonObject;

};


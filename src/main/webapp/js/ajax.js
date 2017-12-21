// pathname is contextRoot/path/path/ so we want to get [1] 
// that is where contextRoot is
// [0] has "" as a result of split 
var contextRoot = "/" + window.location.pathname.split('/')[1];

function categorySubmit() {
	var sendToSend = JSON.stringify(serializeObject($('#categoryForm')));
	console.log(sendToSend);
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
			console.log(jqXHR);
		}
	});
}
function getAsUriParameters(data) {
	   var url = '';
	   for (var prop in data) {
	      url += encodeURIComponent(prop) + '=' + 
	          encodeURIComponent(data[prop]) + '&';
	   }
	   return url.substring(0, url.length - 1)
	}

function selectProductSubmit() {
	var sendToSend = JSON.stringify(serializeObject($('#selectProductForm')));
	/*console.log(sendToSend);
	let urlParameters = getAsUriParameters(sendToSend);
	console.log(urlParameters);*/
	let productId = $('#productId').val();
	console.log(productId);
	let quantity = $('#quantity').val();
	console.log(quantity);
	$.ajax({
		url : contextRoot + '/orders/addProductToOrder',
		type : 'GET',
		dataType : "json", // Accepts
		data : "productId=" + productId +"&quantity=" + quantity,
		success : function(orderLine) {
			var newRow = '<p>' + '<strong>' + orderLine.product.productName + '</strong>' + '. Price: ' + orderLine.product.price + '. Quantity: ' + orderLine.quantity + '</p>';

			$("#products").append(newRow);
			resetForm('selectProductForm');
		},

		error : function(jqXHR, textStatus, exception) {
			console.log(jqXHR);
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


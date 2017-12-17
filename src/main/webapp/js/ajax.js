 	// pathname is contextRoot/path/path/ so we want to get [1] 
    // that is where contextRoot is
	// [0] has "" as a result of split 
	var contextRoot = "/" + window.location.pathname.split( '/' )[1];

 
function phoneSubmit(){
   	var sendToSend = JSON.stringify(serializeObject($('#phoneForm')));
	$.ajax({
		url: contextRoot + '/addPhones',
		type: 'POST',
		dataType: "json",           // Accepts
 		data:sendToSend,
 		contentType: 'application/json',   // Sends
		success: function(phone){
 			
 			var newRow = '<tr><td>&nbsp;</td><td>' + 
 							    phone.areaCode + ' '   + 
 								phone.prefix + ' ' +  phone.number + '</td></tr>';
 			
 			$("#phones").append(newRow);
 			resetForm('phoneForm');
		},
 
		error: function(jqXHR,  textStatus,  exception ){	
			
				alert(jqXHR.responseJSON.message);

		}
	
	});
}

function addressSubmit(){
   	var sendToSend = JSON.stringify(serializeObject($('#addressForm')));
	$.ajax({
		url: contextRoot + '/addAddresses',
		type: 'POST',
		dataType: "json",           // Accepts
 		data:sendToSend,
 		contentType: 'application/json',   // Sends
		success: function(address){
 			
 			var newRow = '<p>' + address.street + ' '   +
 							  address.city + ' '   + address.state + ' ' + address.zipCode + '</p>';
 			
 			$("#addresses").append(newRow);
 			resetForm('addressForm');
		},
 
		error: function(jqXHR,  textStatus,  exception ){	
			
				alert(jqXHR.responseJSON.message);

		}
	
	});
}


toggle_visibility = function(id) {
    var e = document.getElementById(id);
    if(e.style.display == 'block')
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
 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

};


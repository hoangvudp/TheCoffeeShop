	var scntDiv = $('#p_scents');
	var i = $('#p_scents tr').size() + 1;
	$('#addScnt').click(function() {
	    
		
		

	   /* scntDiv.append('<c:forEach items="${order.orderLines}" var="orderLine" varStatus="idx"><form:select path="orderLines[${idx.index}].product.id"><form:option value="NULL" label="--Select	Product--"/><form:options items="${products}" itemLabel="productName" itemValue="id" />	</form:select></c:forEach>');*/
	    scntDiv.append('<tr><td>' + $('#orderLineDiv').html() + '</td><td><a href="#" id="remScnt">Remove</a></td></tr>');   
	    i++;
	    //scntDiv.append('<tr><td>Hello><c:forEach items="${order.orderLines}" var="orderLine" varStatus="idx"><form:select path="orderLines[${idx.index}].product.id"><form:option value="NULL" label="--Select	Product--"/><form:options items="${products}" itemLabel="productName" itemValue="id" />	</form:select></c:forEach></td><td><a href="#" id="remScnt">Remove</a></td></tr>');
	    return false;
	});

	//Remove button
	$(document).on('click', '#remScnt', function() {
	    if (i > 2) {
	        $(this).closest('tr').remove();
	        i--;
	    }
	    return false;
	});

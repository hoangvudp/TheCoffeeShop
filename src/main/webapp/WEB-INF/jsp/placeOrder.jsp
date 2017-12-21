<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<script type="text/javascript" src="<spring:url value="/js/ajax.js"/>"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

	<form:form modelAttribute="order" action="add" method="POST">
		<p>
            <label for="firstName">Date: </label>
           	<form:input path="orderDate" cssStyle="width:20em'"/>
        </p>
        <input type="button" value="Add Product" onclick="make_visible('formInput');return false;">
  	     <br> <br>           
  	    <div id="products">
			<strong>Products:</strong>
		</div>
 		<br>
       <p id="buttons">
            <input id="submit" type="submit" value="Place Order">
        </p>
	</form:form>
	<div id="formInput" style="display:none" > 
	<h3 align="center">Select Product</h3>
        <form:form id="selectProductForm" commandName="orderLine">
            <table>
				<tr>
               		<td colspan="2"><form:errors path="*" cssStyle="color : red;"/></td>
               	</tr>
               	
				<tr>
                	<td>Product: </td>
               		<td>
	               		<form:select path="product.id" id="productId">
							<form:options items="${products}" itemLabel="productName" itemValue="id"/>
						</form:select>
  					</td>
  				</tr>
                <tr>
                	<td>Quantity: </td>
               		<td>
	               		<form:input id="quantity" path="quantity" cssStyle='width:10em'/>
  					</td>
  				</tr>
	            <tr>
	            	<td colspan="2"><input type="button" value="Save" onclick="selectProductSubmit();return false;"></td>
	            </tr>
			</table>
        </form:form>
	<h4 align="center"> 
    	<a href="#" onclick="make_hidden('formInput'); make_hidden('result');resetForm('selectProductForm');"><b>Exit</b></a> 
  	</h4>
        
	</div>

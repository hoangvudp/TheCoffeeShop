<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<script type="text/javascript" src="<spring:url value="/js/ajax.js"/>"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

	<form:form modelAttribute="product" action="${not empty product.id ? product.id : 'add'}" method="POST" enctype="multipart/form-data">
		<table>
				<tr>
               		<td colspan="3"><form:errors path="*" cssStyle="color : red;"/></td>
               	</tr>
                <tr>
                	<td>Name: </td>
               		<td colspan="2">
	               		<form:input path="productName" cssStyle="width:100em'"/>
  					</td>
  				</tr>
  				<tr>
                	<td>Description: </td>
               		<td colspan="2">
	               		<form:textarea path="description" rows="5" cols="40" />
  					</td>
  				</tr>
  				<tr>
                	<td>Category: </td>
               		<td>
	               		<form:select path="productCategory.id" id="categories">
							<form:option value="0"	label="--Select	Category--"/>
							<form:options items="${categories}"	itemLabel="name" itemValue="id"/>
						</form:select>
  					</td>
  					<td><input type="button" value="Add New" onclick="make_visible('formInput');return false;"></td>
  				</tr>
  				<tr>
                	<td>Price: </td>
               		<td colspan="2">
	               		<form:input path="price" cssStyle="width:20em'"/>
  					</td>
  				</tr>
  				
				<tr>
                	<td>Image: </td>
               		<td colspan="2">
	               		<form:input id="productImage" path="productImage" type="file"/>
  					</td>
  				</tr>			
	            <tr>
	            	<td colspan="3"><input type="submit" value="Save"></td>
	            </tr>
			</table>
	</form:form>
	<div id="formInput" style="display:none" > 
	<h3 align="center">Product Category</h3>
        <form:form id="categoryForm" commandName="productCategory" >
            <table>
				<tr>
               		<td colspan="2"><form:errors path="*" cssStyle="color : red;"/></td>
               	</tr>
                <tr>
                	<td>Name: </td>
               		<td>
	               		<form:input path="name" cssStyle='width:22em'/>
  					</td>
  				</tr>
	            <tr>
	            	<td colspan="2"><input type="button" value="Save" onclick="categorySubmit();return false;"></td>
	            </tr>
			</table>
        </form:form>
	<h4 align="center"> 
    	<a href="#" onclick="make_hidden('formInput'); make_hidden('result');resetForm('categoryForm');"><b>Exit</b></a> 
  	</h4>
        
	</div>

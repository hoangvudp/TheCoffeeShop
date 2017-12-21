<div class='container'>
			<table
				class="table table-striped, table table-hover table table-condensed table-bordered">
				<tr>

					<th>Id</th>
					<th>Order Id</th>
					<th>customer Name</th>
					<th>Product</th>
					<th>Quantity</th>
					<th>Price</th>
				</tr>
				<c:forEach var="order_line" items="${order_lines}">

					<tr>
						<td>${order_line.id}</td>
						<!-- order id -->
						<td>${order_line.order.orderDate}</td>
						<td>${order_line.order.person.firstName}</td>

						<td><div class="dropdown">
								<!-- product  -->
								<p>
								<p>${order_line.product.productName}</p>
								<div class="dropdown-content">

									<p>${order_line.product.productType}</p>
									<p>${order_line.product.description}</p>
								</div>
							</div></td>
						<td>${order_line.quantity}</td>

						<td>${order_line.product.price}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4">Total</td>
					<td>${totalQuantity}</td>
					<td>${totalPrice}</td>
				</tr>
			</table>
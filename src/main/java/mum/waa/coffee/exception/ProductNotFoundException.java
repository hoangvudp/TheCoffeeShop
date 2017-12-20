package mum.waa.coffee.exception;


public class ProductNotFoundException extends RuntimeException{
 	/**
	 * 
	 */
	private static final long serialVersionUID = 9060751397339719682L;
	private Long productId;
	private String message = "Product Not Found for this ID ";
	
 	public ProductNotFoundException() {}
	
	public ProductNotFoundException(Long productId, String message) {
		this.productId = productId;

		if (message != null) this.message = message;
		
	}
	
	public String getFullMessage() {
		return (message + productId);
	}
	
	public Long getProductId() {
		return productId;
	}
	
	@Override
	public String getLocalizedMessage() {
	// TODO Auto-generated method stub
	return super.getLocalizedMessage();
}


}

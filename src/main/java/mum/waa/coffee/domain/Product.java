package mum.waa.coffee.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Product implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1979663699318886847L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String productName;

    private String description;

//    @NotNull
//    @Min(value = 0)
//    private Double price;
    @Min(value=0, message="Min.Product.Price.validation}")
	@Digits(integer=8, fraction=2, message="{Digits.Product.Price.validation}")
	@NotNull(message= "{NotNull.Product.Price.validation}")
	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal price;

    @OneToOne()
    @JoinColumn(name="category_id")
    private ProductCategory productCategory;
    
    @Transient
    @JsonIgnore 
	private MultipartFile  productImage;

    public Product() {
        super(); // default constructor
    }

    public Product(String productName, String description, BigDecimal price, ProductCategory productCategory) {
        super();
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.productCategory = productCategory;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlTransient  
	public MultipartFile getProductImage() {
		return productImage;
	}
    
    public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
    
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", productCategory=" + productCategory +
                '}';
    }
}

package mum.waa.coffee.domain;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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

    @NotNull
    @Min(value = 0)
    private Double price;

    @OneToOne()
    @JoinColumn(name="category_id")
    private ProductCategory productCategory;

    public Product() {
        super(); // default constructor
    }

    public Product(String productName, String description, double price, ProductCategory productCategory) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

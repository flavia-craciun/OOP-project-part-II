package gifts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Category;

public final class Gifts {
    private String productName;
    private Double price;
    private Category category;
    private int quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    @JsonIgnore
    public int getQuantity() {
        return quantity;
    }

    @JsonProperty
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}

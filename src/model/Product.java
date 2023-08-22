package model;

/**
 *
 * @author Jacobo-bc
 */
public class Product {
    
    private final String code;
    
    private String name;
    private String distributor;
    private String category;
    private double price;

    public Product(String code, String name, String distributor, String category, double price) {
        this.code = code;
        this.name = name;
        this.distributor = distributor;
        this.category = category;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}

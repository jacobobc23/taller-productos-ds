package model;

/**
 *
 * @author Jacobo-bc
 */
public class Category {
    
    private final int id;
    private final String categoryName;

    public Category(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

}

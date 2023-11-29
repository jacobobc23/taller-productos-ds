package model;

/**
 *
 * @author jacobobc
 */
public class Category {
    
    private int id;
    private final String name;

    public Category(String name) {
        this.name = name;
    }
    
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

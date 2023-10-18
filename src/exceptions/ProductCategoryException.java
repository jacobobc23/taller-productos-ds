package exceptions;

/**
 *
 * @author Jacobo-bc
 */
public class ProductCategoryException extends RuntimeException {
    public ProductCategoryException() {
        super ("No se puede eliminar la categoría porque hay productos asociados a ella.");
    }
}

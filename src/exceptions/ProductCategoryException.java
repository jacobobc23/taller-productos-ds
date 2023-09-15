package exceptions;

/**
 *
 * @author Jacobo-bc
 */
public class ProductCategoryException extends RuntimeException {
    public ProductCategoryException() {
        super ("No se puede eliminar una categoría ya asignada a un producto");
    }
}

package barmanagement;

/**
 *This class represents an exception for zero balance in wallet of a Human.
 * @author William Kofi Danso DARKWA
 */
public class NotEnoughBalanceException extends Exception {
    NotEnoughBalanceException(){
        super("*Not enough balance in wallet*");
    }
}

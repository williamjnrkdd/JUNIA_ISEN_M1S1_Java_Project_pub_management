package barmanagement;

/**
 *This class represents a table in a bar.
 * @author William Kofi Danso DARKWA
 */
public class Table {
    public int i = 0;
    public Client[] seats = new Client[4];

    /**
     * Method allows to add a client to a table.
     * @param client 
     */
    public void add(Client client){
        this.seats[i++] = client;
    }
}

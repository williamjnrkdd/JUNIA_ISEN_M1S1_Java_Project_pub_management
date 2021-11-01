/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barmanagement;

/**
 *
 * @author Will
 */
public class Table {
    public int numberOfSeats = 4;
    public Drink[] consumptionSet;
    
    Table(Drink[] consumptionSet){
        this.consumptionSet = consumptionSet;
    }
}

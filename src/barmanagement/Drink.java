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
public class Drink {
    public String name;
    private Client owner;
    public boolean alcoholState;
    public int alcoholPoints;
    public double purchasePrice, sellingPrice;
    
    Drink(String name, boolean alcoholState, int alcoholPoints, double purchasePrice, double sellingPrice){
     this.name = name;
     this.alcoholState = alcoholState;
     this.alcoholPoints =  alcoholState ? alcoholPoints : 0;
     this.purchasePrice  = purchasePrice;
     this.sellingPrice = sellingPrice; 
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
    
    
    
}

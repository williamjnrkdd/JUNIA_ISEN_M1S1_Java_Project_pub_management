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
    private Human owner;
    public boolean alcoholState;
    public int alcoholPoints;
    public int purchasePrice, sellingPrice;
    
    Drink(String name, boolean alcoholState, int alcoholPoints, int purchasePrice, int sellingPrice){
     this.name = name;
     this.alcoholState = alcoholState;
     this.alcoholPoints = alcoholState ? alcoholPoints : 0;
     this.purchasePrice  = purchasePrice;
     this.sellingPrice = sellingPrice; 
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }

//    public final void setAlcoholPoints(int alcoholPoints) {
//        try{
//            if(alcoholPoints >= 0){
//                this.alcoholPoints = alcoholPoints;
//            }
//            else{
//                throw new LessThanZeroException("Alcohol points");
//            }
//        }
//        catch(LessThanZeroException e){
//            System.out.println(e.getMessage());
//        }
//    }

    Human getOwner() {
        return owner;
    }
  
    
    
    
}

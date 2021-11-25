package barmanagement;

/**
 *This class represents a drink in the bar.
 * @author William Kofi Danso DARKWA
 */
public class Drink {
    public String name;
//    private Human owner;
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

//    public void setOwner(Human owner) {
//        this.owner = owner;
//    }

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

//    Human getOwner() {
//        return owner;
//    }
  
    
    
    
}

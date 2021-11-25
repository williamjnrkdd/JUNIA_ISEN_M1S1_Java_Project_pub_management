package barmanagement;

/**
 *This represents the gender protagonists.
 * @author Will
 */
public enum Gender {
    MALE(0) {
        public int feature(){
            return sizeOfBiceps;
        }
    }, FEMALE(0){
        public int feature(){
            return coefficientOfCharm;
        }
    };
    
    int sizeOfBiceps, coefficientOfCharm;
    
    Gender(int feature){
        this.sizeOfBiceps = feature;
        this.coefficientOfCharm = feature;
   }
}

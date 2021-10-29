/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barmanagement;

/**
 *
 * @author Mary Denkyiwaa
 */
public class Human {
    public final String firstName;
    public String nickName;
    private int wallet;
    private int popularityRating;
    private String meaningfulCry;  

    public Human(String firstName, String nickName, int wallet, int popularityRating, String meaningfulCry) {
        this.firstName = firstName;
        this.nickName = nickName;
        this.wallet = wallet;
        this.popularityRating = popularityRating;
        this. meaningfulCry = meaningfulCry;
        
    }

    public void speak() {
        
    }
    
    public void drink() {
        
    }
     
     public void pay() {
        
    }
     
    public void offerDrink() {
        
    }
     
    public void present() {
        
    }
    
    public int getWallet() {
        return wallet;
    }
    
    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
    
    
    public int getPopularityRating(){
        return popularityRating;
    }
    
    public void setPopularityRating(int popularityRating) {
        this.popularityRating = popularityRating;
    }
     
    public String getMeaningfulCry() {
        return meaningfulCry;
    }
    
    public void setMeaningfulCry(String meaningfulCry) {
        this.meaningfulCry = meaningfulCry;
    }
     
     
     
}
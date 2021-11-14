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
public class Bar {
    public String name;
    public static Bartender bartender;
    public static Fund fund;
    public static Boss boss;
    
    Bar(String bossName, String bartenderFirstName, String bartenderNickName, String bartenderMeaningfulCry){
        name = "Chez " + bossName;
        //create boss object
        this.fund = new Fund();
        Bar.bartender = new Bartender(bartenderFirstName, bartenderNickName, bartenderMeaningfulCry);
        Bar.boss  = new Boss();
        
                
    }
}

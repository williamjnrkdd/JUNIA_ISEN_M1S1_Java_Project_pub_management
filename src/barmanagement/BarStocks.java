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
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BarStocks {
    public static Drink[] drinks;
    
    BarStocks(){
        try{
            File drinkStocks=new File("src\\barmanagement\\database.txt").getAbsoluteFile();    //creates a new file instance  
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(drinkStocks));
            lineNumberReader.skip(Long.MAX_VALUE);
            int lines = lineNumberReader.getLineNumber() - 1; //-1 for the header line
            lineNumberReader.close();
            this.drinks = new Drink[lines];
            FileReader fr =new FileReader(drinkStocks);   //reads the file  
            BufferedReader br =new BufferedReader(fr);  //creates a buffering character input stream  
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
            String line;
            int i = 0;
            boolean skipHeader = true;
            while((line=br.readLine())!=null)  
            {  
                if(skipHeader){
                    skipHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                this.drinks[i] = new Drink(data[0],data[1].equals("true"),Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4]),Integer.parseInt(data[5]));
                i++;
            }  
            fr.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void print(){
        BarStocks barstock = new BarStocks();
        System.out.print(barstock);
    }
    
    @Override
    public String toString(){
        String result = "";
        for(int i=0; i < this.drinks.length; i++){
            result += i+1 + ". " + this.drinks[i].name + "\n";
        }
        return result;
    }
}

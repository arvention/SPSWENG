/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Helper;

import java.util.Random;

/**
 *
 * @author Thursday
 */
public class PasswordGenerator {
    
    
    
    
        private static PasswordGenerator pg = new PasswordGenerator();
        private Random rand = new Random();	


    public String getPassword(){
            
        int randomNum;
	char cr;
	String str="";
	int newnum;
	char[] arr=null;
            
            for(int c=0 ; c< 6;c ++){
			randomNum = rand.nextInt((112 - 97) + 1) + 97;
			cr =(char)  randomNum;
			str+=cr;	
		}
		arr = str.toCharArray();
		for(int c=0; c<1; c++){
			randomNum = rand.nextInt((5 - 0) + 1);
			newnum = rand.nextInt((9 - 0) + 1);
			cr = Character.forDigit(newnum , 10);;
			arr[randomNum]=  cr;
		}
		

		
	return new String(arr);
    }
	
    public static PasswordGenerator getInstance(){
        return pg;
    }
    
		
}
    
    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassHelpers;

import Models.modelEmployee;
import java.util.ArrayList;

/**
 *
 * @author Thursday
 */
public class SearchResult {
    
    ArrayList<modelEmployee> result;
    
    public SearchResult(ArrayList<modelEmployee> result){
        this.result= result;
    
    }
    
    public ArrayList<modelEmployee> getResult(){
        return this.result;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ClassHelpers;

import Models.modelRecord;
import java.util.ArrayList;

/**
 *
 * @author Thursday
 */
public class Downloadables {
    
    private ArrayList<modelRecord> awards; 
    private ArrayList<modelRecord> evaluation;
    private ArrayList<modelRecord> memo;
    
    public Downloadables(){
        awards= new ArrayList<>();
        evaluation = new ArrayList<>();
        memo = new ArrayList<>();
    }
    
    public void addAward(modelRecord mr ){
        awards.add(mr);
    }
    
    public void addEvaluation(modelRecord mr ){
        evaluation.add(mr);
    }
        
    public void addMemo(modelRecord mr ){
        memo.add(mr);
    }
    
    public ArrayList<modelRecord> getAwards(){
        return awards;
    }
    
   public ArrayList<modelRecord> getEvaluation(){
        return evaluation;
    }
    
     public ArrayList<modelRecord> getMemo(){
        return memo;
    }
       
}

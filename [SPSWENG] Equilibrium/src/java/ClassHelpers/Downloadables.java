
/*  Class Name:     Downloadables
*   Developer:      Jet Virtusio
*   Description:    Objects that can be downloaded through the system.
*/  

package ClassHelpers;

import Models.modelRecord;
import java.util.ArrayList;

public class Downloadables {
    
    private ArrayList<modelRecord> awards; 
    private ArrayList<modelRecord> evaluation;
    private ArrayList<modelRecord> memo;
    
    /*
    *   constructor with no parameter
    */
    public Downloadables(){
        awards = new ArrayList<>();
        evaluation = new ArrayList<>();
        memo = new ArrayList<>();
    }
    
    /*
    *   used to add an award to the arraylist of awards
    */
    public void addAward(modelRecord mr){
        awards.add(mr);
    }
    
    /*
    *   used to add evaluation to the arraylist of evaluations
    */
    public void addEvaluation(modelRecord mr){
        evaluation.add(mr);
    }
       
    /*
    *   used to add memo to the arraylist of memos
    */
    public void addMemo(modelRecord mr){
        memo.add(mr);
    }
    
    /*
    *   getter function for the arraylist of awards
    */
    public ArrayList<modelRecord> getAwards(){
        return awards;
    }
    
    /*
    *   getter function for the arraylist of evaluations
    */
    public ArrayList<modelRecord> getEvaluation(){
       return evaluation;
    }
    
    /*
    *   getter function for the arraylist of memos
    */
    public ArrayList<modelRecord> getMemo(){
        return memo;
    }
}

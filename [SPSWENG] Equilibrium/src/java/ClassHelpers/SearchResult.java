
/*  Class Name:     Search Result
*   Developer:      Jet Virtusio
*   Description:    Objects used to display the search result of a search query in the system.
*/  

package ClassHelpers;

import Models.modelEmployee;
import java.util.ArrayList;

public class SearchResult {
    
    ArrayList<modelEmployee> result;
    
    /*
    *   setter function
    */
    public SearchResult(ArrayList<modelEmployee> result){
        this.result = result;
    }
    
    /*
    *   getter function
    */
    public ArrayList<modelEmployee> getResult(){
        return this.result;
    }
}

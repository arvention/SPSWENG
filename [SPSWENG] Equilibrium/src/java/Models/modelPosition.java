
package Models;

public class modelPosition {
    private int positionID;
    private String name;

    public modelPosition(int positionID, String name){
        this.positionID = positionID;
        this.name = name;
    }
    
    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

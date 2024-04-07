import java.util.ArrayList;

public class RStateTableAllocated implements RState{

    private ArrayList<Table> tables = new ArrayList<Table>();

    private String returnString = "Table assigned: ";

    public RStateTableAllocated(ArrayList<Table> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        for (Table table : tables) {
            returnString += table + " ";
        }
        return returnString;
    }
}

package HomeWork1;

import java.util.Comparator;

public class DescendingComparator implements Comparator<Vehicle>{
	
    // EZXFWK
    public int compare(Vehicle FIRSTCAR, Vehicle SECCAR) 
    { 
        return Integer.compare(FIRSTCAR.GET_HIGH(), SECCAR.GET_HIGH());
    } 
    
	
}

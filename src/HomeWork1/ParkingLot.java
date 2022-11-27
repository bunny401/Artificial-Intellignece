package HomeWork1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingLot extends Matrix{
	
    private Integer high;
    private Integer wide;
    private int[][] point;
    
    List<Vehicle> SortingofVehicles;
    { SortingofVehicles = new ArrayList<>(); }
    
    List<Vehicle> ListingVehicles;
    { ListingVehicles = new ArrayList<>(); }


 // Methods that are Overridden
    @Override
    public Integer GET_WIDE() { return wide; }
    @Override
    public void SET_HIGH(int hig) {high = hig;}
    @Override
    public void SET_WIDE(int wid) {  wide = wid; }
    @Override
    public Integer GET_HIGH() {return high;}
    
    public ParkingLot(int high, int wide) {
    	SET_HIGH(high);
    	SET_WIDE(wide);
        point = new int[this.GET_HIGH()][this.GET_WIDE()];
    }

    
    Boolean HALT = false; 
	public boolean Fill(Vehicle automobile){
        for(int l=0; l<GET_HIGH();l++){
            for(int m=0; m<GET_WIDE();m++){
            	
            		if (IsFree(l, m, automobile)){
            			// 
            			if(HALT == true) 
            			{
            				automobile.flip();
            				HALT = false;
            			}
                        FitIn(l, m, automobile);
                        return true;
                    }else
                    {
                    	automobile.flip();
                    }	

            }
        }
        return false;
    }
	
    public Boolean TotalFill()
    {
    	try
    	{
    		for(int i = 0; i < ListingVehicles.size(); i++)
        	{
        			Fill(ListingVehicles.get(i).GetVehicle());
        		
        	}
    	}catch(Exception except)
    	{
    		return false;
    	}
    	return true;
    }
    
    public void Push(Vehicle car)
	{
    	ListingVehicles.add(car);
	}
    
 	//We will print the sorted list
 	//according to the format that is provided
   
	
    private boolean IsFree(int rownumber, int columnnumber, Vehicle automobile){
    	
       for(int l=0; l<automobile.GET_HIGH();l++){
        	if(HALT == true)
        	{
        		break;
        	}
            for(int m=0; m<automobile.GET_WIDE();m++){

            	try
            	{
            		if (point[rownumber + l][columnnumber + m] != 0)
                        return false;
            	}catch(Exception except)
            	{
            		HALT = true;
            		break;
            	}

            }
        }
        return true;
    }
    
    public void printSortedList()
	{
		for(int i = 0; i < ListingVehicles.size(); i++)
		{
				System.out.println("" + ListingVehicles.get(i).GET_HIGH() + "|" + ListingVehicles.get(i).GET_WIDE());
		}
	}
    
    
    
    public void Sort()
 	{
 		Collections.sort(ListingVehicles, new DescendingComparator()); 
 		Collections.reverse(ListingVehicles);
 	}
 	

    private void FitIn(int RIndex, int CIndex, Vehicle car){
        for(int i=0; i<car.GET_HIGH();i++){
            for(int j=0; j<car.GET_WIDE();j++){
            		point[RIndex + i][CIndex + j] = car.GET_IDENTITY();
            }
        }
    }



    @Override
    
//StringBuilder in Java represents a mutable sequence of characters. 
//Since the String Class in Java creates an immutable sequence of characters, 
//the StringBuilder class provides an alternative to String Class, 
//as it creates a mutable sequence of characters
    public String toString() {
        StringBuilder Builder = new StringBuilder();
        int cell = 0;
        for(int l=0; l < this.GET_HIGH(); l++){
            for(int m = 0; m < this.GET_WIDE(); m++ ){
            	cell = this.point[l][m];
                if (m == (this.GET_WIDE() - 1 )){//separated by newline
                	Builder.append(cell + "\n");
                }                else{//separated by tab
                	Builder.append(cell + "\t");
                }
            }
        }
        
        String OUTPUTOFTHEMATRIX = new String(Builder); // Converts StringBuilder to String
        return OUTPUTOFTHEMATRIX;
    }

}
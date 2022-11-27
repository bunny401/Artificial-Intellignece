package HomeWork1;

public class Vehicle extends Matrix implements Changer {
	
	private Integer IDENTITY = 0;
	private Integer HIGH = 0;
	private Integer WIDE = 0;

	public Vehicle(int IDENTITY, int high, int wide) {
		SET_IDENTITY(IDENTITY);
		SET_HIGH(high);
		SET_WIDE(wide);
    }
	
	public Vehicle GetVehicle()
	{
		return this;
	}
	
	@Override
    public Integer GET_WIDE() {
		
        return WIDE;
    }
	
	@Override
    public Integer GET_IDENTITY() {
		
        return IDENTITY;
    }
	
	@Override
    public Integer GET_HIGH() {
		
        return HIGH;
    }
	
	@Override
    public void SET_IDENTITY(int id) {
		
        IDENTITY = id;
    }

	@Override
    public void SET_HIGH(int height) {
		// TODO Auto-generated method stub
        HIGH = height;
    }


	@Override
    public void SET_WIDE(int width) {
		
        WIDE = width;
    }

	
	@Override
    public Boolean flip(){
    	
    	try
    	{
    		Integer TEMPORARY=this.HIGH;
            this.HIGH=this.WIDE;
            this.WIDE=TEMPORARY;
    	}catch(Exception except)
    	{
    		return false;
    	}
    	return true;  
    }

   
}


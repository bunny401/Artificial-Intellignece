package HomeWork1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		//The Scanner class is used to get user input, and it is found in the java.util package.
		Scanner sc = new Scanner(System.in);
		
		String MatrixParamsString = sc.nextLine();
		//separated by tab space
		String[] MatrixParams = MatrixParamsString.split("\\t");
		
		int Heightofthematrix = Integer.parseInt(MatrixParams[0]);
		int Widthofthematrix = Integer.parseInt(MatrixParams[1]);
		
		
		ParkingLot park = new ParkingLot(Heightofthematrix,Widthofthematrix);

		String numberVehicles = sc.nextLine();

		
		for(int i = 0; i < Integer.parseInt(numberVehicles) ; i++)
		{
			String VehicleStr = sc.nextLine();
			String[] VehicleParameteres = VehicleStr.split("\\t");
			
			int Heightofauto = Integer.parseInt(VehicleParameteres[0]);
			int Widthofauto = Integer.parseInt(VehicleParameteres[1]);
			
			Vehicle auto = new Vehicle(i+1,Heightofauto,Widthofauto);
			park.Push(auto);
		}
	
		//arrange systematically in groups
		park.Sort();
		park.TotalFill();
	
		
		
		
		System.out.println(park.toString());
	}
}

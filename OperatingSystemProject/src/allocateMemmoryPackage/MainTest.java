package allocateMemmoryPackage;

import java.util.*;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int tempMemorySize = 0;
		int tempBlockSize = 0;
		Scanner reader = new Scanner(System.in); 
		System.out.println("Projekt zaliczeniowy systemy operacyjne");
		System.out.println("Podaj wielkoœæ dysku : ");
		tempMemorySize =  reader.nextInt();
		System.out.println("Podaj wielkoœæ pojedynczego bloku : ");
		tempBlockSize = reader.nextInt();
		
		HardDrive drive = new HardDrive(tempMemorySize, tempBlockSize);
		
		
	}
}

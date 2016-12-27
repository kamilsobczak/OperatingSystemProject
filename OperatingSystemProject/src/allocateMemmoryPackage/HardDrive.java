package allocateMemmoryPackage;

import java.util.*;

public final class HardDrive 	// reprezentacja przestrzeni dyskowej 
{						
	public byte[] drive;
	boolean[] vector; // tablica reprezentuj¹ca wektor bitowy
	List<CatalogPosition> catalog = new ArrayList<CatalogPosition>(); //tablica z list¹ istniej¹cych plików
	
	public HardDrive(int memorySize, int blockSize)
	{
		// tworzê tablicê reprezentuj¹c¹ dysk o wielkoœci podanej przez u¿ytkownika
		drive = new byte[memorySize];
		//dla ka¿dego elementu tablicy reprezentuj¹cej dysk, przypisywany jest obiekt klasy Block o podanej przez u¿ytkownika wielkoœci
		for (int i = 0; i < drive.length; i++)
		{									
			drive[i]= 0;
		}
		vector = new boolean[memorySize];
	}
}

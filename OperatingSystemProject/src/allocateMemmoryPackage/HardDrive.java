package allocateMemmoryPackage;

import java.util.*;

public final class HardDrive 	// reprezentacja przestrzeni dyskowej 
{						
	public byte[] drive;
	boolean[] vector; // tablica reprezentuj�ca wektor bitowy
	List<CatalogPosition> catalog = new ArrayList<CatalogPosition>(); //tablica z list� istniej�cych plik�w
	
	public HardDrive(int memorySize, int blockSize)
	{
		// tworz� tablic� reprezentuj�c� dysk o wielko�ci podanej przez u�ytkownika
		drive = new byte[memorySize];
		//dla ka�dego elementu tablicy reprezentuj�cej dysk, przypisywany jest obiekt klasy Block o podanej przez u�ytkownika wielko�ci
		for (int i = 0; i < drive.length; i++)
		{									
			drive[i]= 0;
		}
		vector = new boolean[memorySize];
	}
	
	public boolean CheckIfFileExists(String _fileName)
	{
		boolean result;
		result = false;
		
		for (CatalogPosition position : catalog)
		{
			if (position.GetFileName() == _fileName)
			{
				result = true;
				break;
			}
		}
		
		return result;
	}
}

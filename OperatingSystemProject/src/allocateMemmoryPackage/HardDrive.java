package allocateMemmoryPackage;

public final class HardDrive 	// reprezentacja przestrzeni dyskowej 
{						
	public Block[] drive;
	boolean[] vector; // tablica reprezentuj�ca wektor bitowy
	CatalogPosition[] catalog; //tablica z list� istniej�cych plik�w
	
	public HardDrive(int memorySize, int blockSize)
	{
		// tworz� tablic� reprezentuj�c� dysk o wielko�ci podanej przez u�ytkownika
		drive = new Block[memorySize];
		//dla ka�dego elementu tablicy reprezentuj�cej dysk, przypisywany jest obiekt klasy Block o podanej przez u�ytkownika wielko�ci
		for (int i = 0; i < drive.length; i++)
		{									
			drive[i]= new Block(blockSize);
		}
		vector = new boolean[memorySize];
		//ilo�� plik�w jakie mo�na zapisa� dla przydzia�u indeksowego jest r�wny wielko�ci dysku / 2,
		//poniewa� ka�dy plik wymaga co najmniej 2 blok�w by go zapisa� (blok indeksowy oraz co najmniej jeden blok z danymi)
		catalog = new CatalogPosition[memorySize/2];
	}
}

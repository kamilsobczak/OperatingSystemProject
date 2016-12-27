package allocateMemmoryPackage;

public final class HardDrive 	// reprezentacja przestrzeni dyskowej 
{						
	public Block[] drive;
	boolean[] vector; // tablica reprezentuj¹ca wektor bitowy
	CatalogPosition[] catalog; //tablica z list¹ istniej¹cych plików
	
	public HardDrive(int memorySize, int blockSize)
	{
		// tworzê tablicê reprezentuj¹c¹ dysk o wielkoœci podanej przez u¿ytkownika
		drive = new Block[memorySize];
		//dla ka¿dego elementu tablicy reprezentuj¹cej dysk, przypisywany jest obiekt klasy Block o podanej przez u¿ytkownika wielkoœci
		for (int i = 0; i < drive.length; i++)
		{									
			drive[i]= new Block(blockSize);
		}
		vector = new boolean[memorySize];
		//iloœæ plików jakie mo¿na zapisaæ dla przydzia³u indeksowego jest równy wielkoœci dysku / 2,
		//poniewa¿ ka¿dy plik wymaga co najmniej 2 bloków by go zapisaæ (blok indeksowy oraz co najmniej jeden blok z danymi)
		catalog = new CatalogPosition[memorySize/2];
	}
}

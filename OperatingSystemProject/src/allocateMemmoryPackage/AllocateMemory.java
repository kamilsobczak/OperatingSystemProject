package allocateMemmoryPackage;


public class AllocateMemory 
{
	public static enum memoryAllocateState
	{
		
		successfulyAllocatedMemory, //  pomy�lnie przydzielono pami�� do pliku
		fileAlreadyExist,			//	plik ju� istnieje(nie mo�na utworzy�!)
		notEnoughFreeMemory,		//	brak wystarczaj�cej ilo�ci wolnej pami�ci
		notEmptyINode,				//	brak wolnego iw�z�a
		noFileExist,				//	plik nie istnieje
		successfulyDeletedFile,		//	udanie usuni�to plik
		successfulyChangedFileSize,	//  udanie zmieniono wielko�� pliku
		Error;						// b��d
	}
	
	/**
	 * przypisywanie miejsca do pliku
	 * @param fileName nazwa
	 * @param fileSize wielko��
	 * @return zwraca warto�� enum'a reprezentuj�c� wynik funkcji
	 */
	public static memoryAllocateState AllocateMemoryForFile(String fileName, char[] fileContent)
	{
		memoryAllocateState result = memoryAllocateState.Error;	
		int fileSize = fileContent.length;
		boolean indexBlockIsNeaded = false;
		if (fileSize > 2)
		{
			indexBlockIsNeaded = true;
		}
		boolean isEnoughtSpace = false;
		int howManyBlocksIsNeaded = 0;
		if (indexBlockIsNeaded)
		{
			howManyBlocksIsNeaded = (fileContent.length - 2) / HardDrive.blockSize;
			isEnoughtSpace = CheckIfDriveHasEnoughFreeMemoryForFile(howManyBlocksIsNeaded);	
		}
		else
		{
			isEnoughtSpace = true;	
		}
		
		if (isEnoughtSpace)
		{
			int tempINodeNumber = GetFirstEmptyINode();
			if (tempINodeNumber == -1)
			{
				result = memoryAllocateState.notEmptyINode;
			}			
			int numberOfIndexBlock = GetFirstFreeBlock();
			if (numberOfIndexBlock == -1)
			{
				return memoryAllocateState.Error;
			}
			
			
			INode tempINode = new INode(fileContent[0], fileContent[1], fileSize, howManyBlocksIsNeaded, numberOfIndexBlock);
			HardDrive.catalog.add(new CatalogPosition(fileName, tempINodeNumber));
		}
		else
		{
			result = memoryAllocateState.notEnoughFreeMemory;
		}
		
		
		return result;
	}
	
	/**
	 * funkcja definiuj�ca wielko�� pami�ci i wielko�� bloku indeksowego
	 * @param memorySize wielko�� pami�ci
	 * @param blockSize wielko�� bloku
	 * @return
	 */
	public static boolean DefineMemorySize(int memorySize, int blockSize)
	{
		boolean result = false;
		return result;
	}
	
	/**
	 * funkcja usuwaj�ca plik z pami�ci
	 * @param fileName nazwa
	 * @return
	 */
	public static memoryAllocateState DeleteFileFromMemory(String fileName)
	{
		memoryAllocateState result = memoryAllocateState.Error;
		return result;
	}
	/**
	 * funkcja zmieniaj�ca wielko�� pliku
	 * @param fileName
	 * @param newFileSize
	 * @return
	 */
	public static memoryAllocateState ResizeFile(String _FileName, int newFileSize)
	{
		memoryAllocateState result = memoryAllocateState.Error;
		return result;
	}
	
	public static boolean CheckIfDriveHasEnoughFreeMemoryForFile(int howManyBLocksIsNeaded)
	{
		boolean result = false;

		for(int i = 0; i < HardDrive.vector.length; i++)
		{
			if (HardDrive.vector[i] == false) howManyBLocksIsNeaded--;
		}
		
		if (howManyBLocksIsNeaded == 0)
		{
			result = true;
		}
		else			
		{
			result = false;
		}
		
		return result;
	}
	
	public static char[] ReadBlock(int blockNumber)
	{
		char[] result = null;
		if (blockNumber <= HardDrive.driveMaxBlockCount)
		{ 
			result = new char[HardDrive.blockSize];
			int counter = 0;
			for (int i = blockNumber * HardDrive.blockSize; i < HardDrive.blockSize; i++)
			{
				result[counter] = HardDrive.drive[i];
				i++;
			}
		}
		
		return result;
	}
	
	private static int GetFirstEmptyINode()
	{
		int result = -1;
		
		for(int i = 0; i < HardDrive. iNodeTable.length; i++)
		{
			if(HardDrive.iNodeTable[i] == null) result = i;
		}
		
		return result;
	}
	
	private static int GetFirstFreeBlock()
	{
		int result = -1;
		for(int i = 0; i < HardDrive.vector.length; i++)
		{
			if (HardDrive.vector[i] == false) 
			{
				result = i;
				break;
			}
		}
		
		return result;
	}
}

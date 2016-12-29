package allocateMemmoryPackage;


public class AllocateMemory 
{
	public static enum memoryAllocateState
	{
		
		successfulyAllocatedMemory, //  pomyœlnie przydzielono pamiêæ do pliku
		fileAlreadyExist,			//	plik ju¿ istnieje(nie mo¿na utworzyæ!)
		notEnoughFreeMemory,		//	brak wystarczaj¹cej iloœci wolnej pamiêci
		notEmptyINode,				//	brak wolnego iwêz³a
		noFileExist,				//	plik nie istnieje
		successfulyDeletedFile,		//	udanie usuniêto plik
		successfulyChangedFileSize,	//  udanie zmieniono wielkoœæ pliku
		Error;						// b³¹d
	}
	
	/**
	 * przypisywanie miejsca do pliku
	 * @param fileName nazwa
	 * @param fileSize wielkoœæ
	 * @return zwraca wartoœæ enum'a reprezentuj¹c¹ wynik funkcji
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
	 * funkcja definiuj¹ca wielkoœæ pamiêci i wielkoœæ bloku indeksowego
	 * @param memorySize wielkoœæ pamiêci
	 * @param blockSize wielkoœæ bloku
	 * @return
	 */
	public static boolean DefineMemorySize(int memorySize, int blockSize)
	{
		boolean result = false;
		return result;
	}
	
	/**
	 * funkcja usuwaj¹ca plik z pamiêci
	 * @param fileName nazwa
	 * @return
	 */
	public static memoryAllocateState DeleteFileFromMemory(String fileName)
	{
		memoryAllocateState result = memoryAllocateState.Error;
		return result;
	}
	/**
	 * funkcja zmieniaj¹ca wielkoœæ pliku
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

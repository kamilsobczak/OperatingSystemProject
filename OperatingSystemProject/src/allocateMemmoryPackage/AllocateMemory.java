package allocateMemmoryPackage;

public class AllocateMemory 
{
	enum memoryAllocateState
	{
		
		successfulyAllocatedMemory, //   pomy�lnie przydzielono pami�� do pliku
		fileAlreadyExist,			//	plik ju� istnieje(nie mo�na utworzy�!)
		notEnoughFreeMemory,		//	brak wystarczaj�cej ilo�ci wolnej pami�ci
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
	public memoryAllocateState AllocateMemoryForFile(String fileName, int fileSize)
	{
		memoryAllocateState result = memoryAllocateState.Error;						
		return result;
	}
	
	/**
	 * funkcja definiuj�ca wielko�� pami�ci i wielko�� bloku indeksowego
	 * @param memorySize wielko�� pami�ci
	 * @param blockSize wielko�� bloku
	 * @return
	 */
	public boolean DefineMemorySize(long memorySize, int blockSize)
	{
		boolean result = false;
		return result;
	}
	
	/**
	 * funkcja usuwaj�ca plik z pami�ci
	 * @param fileName nazwa
	 * @return
	 */
	public memoryAllocateState DeleteFileFromMemory(String fileName)
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
	public memoryAllocateState ResizeFile(String _FileName, int newFileSize)
	{
		memoryAllocateState result = memoryAllocateState.Error;
		return result;
	}
	
}

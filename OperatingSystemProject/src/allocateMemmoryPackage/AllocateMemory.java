package allocateMemmoryPackage;

public class AllocateMemory 
{
	enum memoryAllocateState
	{
		
		successfulyAllocatedMemory, //   pomyœlnie przydzielono pamiêæ do pliku
		fileAlreadyExist,			//	plik ju¿ istnieje(nie mo¿na utworzyæ!)
		notEnoughFreeMemory,		//	brak wystarczaj¹cej iloœci wolnej pamiêci
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
	public memoryAllocateState AllocateMemoryForFile(String fileName, int fileSize)
	{
		memoryAllocateState result = memoryAllocateState.Error;						
		return result;
	}
	
	/**
	 * funkcja definiuj¹ca wielkoœæ pamiêci i wielkoœæ bloku indeksowego
	 * @param memorySize wielkoœæ pamiêci
	 * @param blockSize wielkoœæ bloku
	 * @return
	 */
	public boolean DefineMemorySize(long memorySize, int blockSize)
	{
		boolean result = false;
		return result;
	}
	
	/**
	 * funkcja usuwaj¹ca plik z pamiêci
	 * @param fileName nazwa
	 * @return
	 */
	public memoryAllocateState DeleteFileFromMemory(String fileName)
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
	public memoryAllocateState ResizeFile(String _FileName, int newFileSize)
	{
		memoryAllocateState result = memoryAllocateState.Error;
		return result;
	}
	
}

package allocateMemmoryPackage;

public class CatalogPosition // pozycja katalogu
{
	String fileName;
	int firstIndexBlockNumber;
	public CatalogPosition (String _fileName, int _firstIndexBlockNumber)
	{
		fileName = _fileName;
		firstIndexBlockNumber = _firstIndexBlockNumber;
	}
}
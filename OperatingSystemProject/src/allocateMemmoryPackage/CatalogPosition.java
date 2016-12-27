package allocateMemmoryPackage;

public class CatalogPosition // pozycja katalogu
{
	private String fileName;
	private int firstIndexBlockNumber;
	public CatalogPosition (String _fileName, int _firstIndexBlockNumber)
	{
		fileName = _fileName;
		firstIndexBlockNumber = _firstIndexBlockNumber;
	}
	
	public String GetFileName()
	{
		return fileName;
	}
	
	public int GetFirstIndexBlockNumber()
	{
		return firstIndexBlockNumber;
	}
}
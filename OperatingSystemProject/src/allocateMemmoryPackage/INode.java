package allocateMemmoryPackage;

public class INode 
{
	int fileSize;
	int blockCounter;
	//bloki bezpoœrednie
	char value1 = ' ';
	char value2 = ' ';
	//blok poœredni 1 poziomu
	int numberOfFirstLevelIndirectBlock;
	
	public INode(char _value1, char _value2, int _fileSize, int _blockCounter, int _numberOfFirstLevelIndirectBlock)
	{
		fileSize = _fileSize;
		blockCounter = _blockCounter;
		value1 = _value1;
		value2 = _value2;
		numberOfFirstLevelIndirectBlock = _numberOfFirstLevelIndirectBlock;
	}
	
	public int GetBlockCounter()
	{
		return blockCounter;
	}
	
	public int GetFileSize()
	{
		return fileSize;
	}
	
	public char GetValue1()
	{
		return value1;
	}
	
	public char GetValue2()
	{
		return value2;
	}

	public int GetFileIndexBlock()
	{
		return numberOfFirstLevelIndirectBlock;
	}
}

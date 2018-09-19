package troubleShootSearch.util;

/**
 * 
 * FileHelper class which returns the instance of the file
 *
 */
public class FileHelper implements  FileHelperI {
    private FileProcessor fp = null;
    public FileHelper(int debugValIn){
        this.fp = new FileProcessor(debugValIn);
    }
    @Override
    public FileProcessor getFp() {
        return this.fp;
    }
}

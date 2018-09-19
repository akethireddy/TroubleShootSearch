package troubleShootSearch.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import java.io.IOException;

/**
 * 
 * FileProcessor class processes each file 
 *
 */
public class FileProcessor {
    
	int debugVal;
	
	public FileProcessor(int debugValIn)
	{
		debugVal = debugValIn;
	}
	@Override
    public String toString() {
        return "FileProcessor{}";
    }
	
    public BufferedReader readerDesc(String name) {
        FileInputStream fp = null;
        BufferedReader reader = null;
        try {
            fp = new FileInputStream(name);
            reader = new BufferedReader(new InputStreamReader(fp));
        } catch (FileNotFoundException e) {
        	
            //System.out.println("File Not found, please make sure the input file available");
        	if(debugVal == 0)
        		Logger.writeMessage("File Not found, please make sure the input file available", Logger.getDebugValue());
            //e.printStackTrace();
            System.exit(0);
        } finally {

        }
        return reader;
    }

    
    public String readLine(BufferedReader reader) {
        if (reader == null) {
            return null;
        }
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("Read a line error");
            if(debugVal == 0)
        		Logger.writeMessage("File Not found, please make sure the input file available", Logger.getDebugValue());
           
            System.exit(0);
        } finally {

        }
        return line;
    }

    
}

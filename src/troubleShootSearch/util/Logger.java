package troubleShootSearch.util;

public class Logger {

    public static enum DebugLevel { SEARCH, EXACT , NONE , NAIVE , SEMANTIC
                                   };

    private static DebugLevel debugLevel;


    
    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	case 4: debugLevel = DebugLevel.SEMANTIC; break;
	case 3: debugLevel = DebugLevel.NAIVE; break;
	case 2: debugLevel = DebugLevel.EXACT; break;
	case 1: debugLevel = DebugLevel.SEARCH; break;
	case 0: debugLevel = DebugLevel.NONE; break;
	default: debugLevel = DebugLevel.NONE; break;
	}
    }

    public static DebugLevel getDebugValue()
    {
    	return debugLevel;
    }
    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    public String toString() {
	return "The debug level has been set to the following " + debugLevel;
    }
    
}

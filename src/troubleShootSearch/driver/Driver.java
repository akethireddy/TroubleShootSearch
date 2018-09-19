package troubleShootSearch.driver;

import troubleShootSearch.searchModule.ExactMatch;
import troubleShootSearch.searchModule.NaiveStemmingMatch;
import troubleShootSearch.searchModule.SemanticMatch;
import troubleShootSearch.searchModule.Visitor;
import troubleShootSearch.util.*;
/**
 * 
 * @author Abhi,Nagaraj
 *
 */
public class Driver {

    /**
     * Driver class for visitor pattern
     * @param args
     */
    public static void main(String[] args) {

    	int debugVal = Integer.parseInt(args[0]);
        FileHelperI fp = new FileHelper(debugVal);
        ProductBuilder productBuilder = new ProductBuilder(fp,debugVal);
        productBuilder.setProduct();

        ProductVersionI pro1v1 = new Pro1V1();

        
        
        Visitor EM = new ExactMatch(productBuilder,"userInputs.txt",fp,debugVal);
        Visitor NSM = new NaiveStemmingMatch(productBuilder, "userInputs.txt", fp,debugVal);
        Visitor SM = new SemanticMatch(productBuilder, "userInputs.txt", fp,debugVal);
       
        pro1v1.accept(EM);
        pro1v1.accept(NSM);
        pro1v1.accept(SM);
        
    }

}

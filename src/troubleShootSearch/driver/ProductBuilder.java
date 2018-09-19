package troubleShootSearch.driver;

import troubleShootSearch.util.*;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ProductBuilder class which creates instances for 4 products and assigns arraylist by parsing files
 *
 */
public class ProductBuilder{
    private FileProcessor fp = null;
    public List<String> synonym = null;
    int debugVal;
    
    public ProductBuilder()
    {
    	
    }
    
    
    public ProductBuilder(FileHelperI fp, int debugValIn) {
        this.fp = fp.getFp();
        debugVal = debugValIn;
    }
    
    
    @Override
	public String toString() {
		return "ProductBuilder [fp=" + fp + ", product1=" + product1
				+ ", product2=" + product2 + ", product3=" + product3
				+ ", product4=" + product4 + "]";
	}
    Product product1 = null;
    Product product2 = null;
    Product product3 = null;
    Product product4 = null;

    public void setProduct(){
        product1 = new Product();
        product2 = new Product();
        product3 = new Product();
        product4 = new Product();
        synonym = new ArrayList<String>();
        this.setProductContent(product1, "i1.txt");
        this.setProductContent(product2, "i2.txt");
        this.setProductContent(product3, "i3.txt");
        this.setProductContent(product4, "i4.txt");
        synonym.addAll(this.getFileContent("synonym.txt"));
    }

    public List<String> getSynonymList() {
        return synonym;
    }
    
    public Product getProduct1() {
        return product1;
    }

    public Product getProduct2() {
        return product2;
    }

    public Product getProduct3() {
        return product3;
    }

    public Product getProduct4() {
        return product4;
    }

    private void setProductContent(Product product, String name){
        product.setContentList(this.getFileContent(name));
    }
    private List<String> getFileContent( String name){
        BufferedReader reader;
        List<String> content = new ArrayList<>();

        try {
            String line;
            reader = fp.readerDesc(name);
            while ((line = fp.readLine(reader)) != null) {
                content.add(line);
            }
            

        }catch (Exception e){
        	if(debugVal == 0)
        		Logger.writeMessage("Exception occured while reading file", Logger.getDebugValue());
            //e.printStackTrace();
        }
        return  content;
    }

	
}

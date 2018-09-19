package troubleShootSearch.searchModule;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import troubleShootSearch.driver.ProductBuilder;
import troubleShootSearch.util.*;

/**
 * 
 * SemanticMatch class which checks for semantics for last entered word by user and finds the exact match with the available reocrds
 *
 */
public class SemanticMatch implements Visitor {

	ProductBuilder productBuilder = null;
	List<String> inputList = null;
	FileHelperI fp = null;
    public List<String> syn = null;
    int debugVal;
    
    public SemanticMatch() {
        
    }

    public SemanticMatch(ProductBuilder productBuilderIn, String inputFileNameIn, FileHelperI fpIn, int debugValIn) {
		this.productBuilder = productBuilderIn;
		this.inputList = new ArrayList<>();
		this.syn = new ArrayList<>();
		this.fp =  fpIn;
		this.setInputList(inputFileNameIn);
		Logger.setDebugValue(debugValIn);
		debugVal = debugValIn;
	}
    
    @Override
	public String toString() {
		return "SemanticMatch [productBuilder=" + productBuilder
				+ ", inputList=" + inputList + ", fp=" + fp + ", syn=" + syn
				+ "]";
	}

    public List<String> getInputList() {
		return inputList;
	}

	public void setInputList(String name) {
		BufferedReader reader;
		
		String line;
		
			reader = this.fp.getFp().readerDesc(name);
			while ((line = this.fp.getFp().readLine(reader)) != null) {
				inputList.add(line);
			}
	}

    

    public void semanticMatchFinding(List<String> listIn,List<String> synonymIn) {
    	
    	List<String> file = new ArrayList<>();
       
    	file.addAll(this.getInputList());
    	
        	for(int i=0;i<this.getInputList().size();i++)
        	{
        		String lastWord = this.getInputList().get(i).substring(this.getInputList().get(i).lastIndexOf(" ") + 1);	
        		for (String line: synonymIn){
    				if(line.contains((lastWord))){
    					String str[] = line.split(":");
    					file.set(i,file.get(i).replaceAll(str[0], str[1]));
    	                               				
    				}
    				
    			}
        	}
        	
        	

        
        for (String inputLine: listIn){ //Does the Exact Match
			for (String line: this.getInputList()){
				//if(inputLine.toLowerCase().contains((line.toLowerCase()))){
				if(inputLine.contains((line))){
					//System.out.println("SEMANTIC MATCH: "+inputLine);
					if(debugVal==4 || debugVal==1)
						Logger.writeMessage("SEMANTIC: "+inputLine, Logger.getDebugValue());
				}
			}
		}

    }
    @Override
    public void visit(Pro1V1 pro1v1) {
    	semanticMatchFinding(productBuilder.getProduct1().getContentList(),productBuilder.getSynonymList());
    	semanticMatchFinding(productBuilder.getProduct2().getContentList(),productBuilder.getSynonymList());
    	semanticMatchFinding(productBuilder.getProduct3().getContentList(),productBuilder.getSynonymList());
    	semanticMatchFinding(productBuilder.getProduct4().getContentList(),productBuilder.getSynonymList());
    }

	

	
}

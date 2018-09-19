package troubleShootSearch.searchModule;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import troubleShootSearch.driver.ProductBuilder;
import troubleShootSearch.util.*;

/**
 * 
 * Exact Match class which checks the user input for exact match in records
 *
 */
public class ExactMatch implements Visitor {

	ProductBuilder productBuilder = null;
	List<String> inputList = null;
	FileHelperI fp = null;
	int debugVal;
	
	public ExactMatch()
	{
		
	}
	
	public ExactMatch(ProductBuilder productBuilder, String inputFileName, FileHelperI fp, int debugValIn) {
		this.productBuilder = productBuilder;
		this.inputList = new ArrayList<>();
		this.fp =  fp;
		this.setInputList(inputFileName);
		Logger.setDebugValue(debugValIn);
		debugVal = debugValIn;
	}

	@Override
	public String toString() {
		return "ExactMatch [productBuilder=" + productBuilder + ", inputList="
				+ inputList + ", fp=" + fp + "]";
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

	public void exactMatchFinding(List<String> listIn)
	{
		for (String inputLine: listIn){
			for (String line: this.getInputList()){
				//if(inputLine.toLowerCase().contains((line.toLowerCase()))){
				if(inputLine.contains((line))){
					//System.out.println("EXACT MATCH: "+inputLine);
					if(debugVal==2 || debugVal==1)
					Logger.writeMessage("EXACT MATCH: "+inputLine, Logger.getDebugValue());
				}
			}
		}
	}
	
	public void visit(Pro1V1 pro1v1)
	{
		exactMatchFinding(productBuilder.getProduct1().getContentList());
		exactMatchFinding(productBuilder.getProduct2().getContentList());
		exactMatchFinding(productBuilder.getProduct3().getContentList());
		exactMatchFinding(productBuilder.getProduct4().getContentList());
	}

	

	
}

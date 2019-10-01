package com.mavenmulti.sample;

import java.util.List;

public class App {

    public static void main(String[] args ) {
    	Table table = new Table();
    	TableActions tableActions = new TableActions(table);
    	TextFileHandler tfHandler;
    	String choice = "";
    	String setOfPairs;
    	List list;
    	if(args != null) {
    		tfHandler = new TextFileHandler(args);
    	} else {
    		tfHandler = new TextFileHandler();
    	}

    	setOfPairs = tfHandler.generateSetOfPairs();
    	list = tableActions.pairsToList(setOfPairs);
    	table.setArrList(list);
    	tableActions = new TableActions(table);

    	while(!choice.equals("7")) {
	    	tableActions.showActions();
    		choice = ScannerUtil.getInputString("Enter chosen Action:");
    		tableActions.doActions(choice);
    		tfHandler.createFile(tableActions.listToPairs(table.getArrList()));
    	}

    	System.out.println("Terminating Program!");
    }
}




//how to bypass test phase 		->		-Dmaven.skip.test=true
//how to bypass not look at central repos		->		change Super POM on maven/lib/maven-builder-support 
//how to check update for a dependency from central repo 		->		mvn -cpu


//MODULARIZE 
//hatiin into four different module 
//root (model,app,service,utils)
//app = input output phasing user
//model = pojos
//serviec = business logics 
//utils = (optional) utility classes 
//rest of the chapters, dependency management

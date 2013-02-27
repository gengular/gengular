package com.gengular.main;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Gengulator {

	final static Logger LOGGER = LoggerFactory.getLogger(Gengulator.class);	
	
	public Gengulator(String pathToModelFile, String pathToTemplateFolder, String pathToDestinationFolder) {
		
		LOGGER.info("Initializing Gengulator");
		
		boolean valid =	validateInputFoldersAndFiles(pathToModelFile, pathToTemplateFolder, pathToDestinationFolder);
		Model model;
		
		if (valid) {
			model = createModel(pathToModelFile);
			generateOutput(model, pathToTemplateFolder, pathToDestinationFolder);
		}
	}

	private void generateOutput(Model model, String pathToTemplateFolder, String pathToDestinationFolder) {
		LOGGER.info("Generating Output");
	}

	private Model createModel(String pathToModelFile) {
		
		Model m = null;      
		POIWrapper excelFile = new POIWrapper(pathToModelFile);
		excelFile.getNumberOfSheets();
		LOGGER.info("Creating Model");
		
		return m;
	}

	private boolean validateInputFoldersAndFiles(String pathToModelFile, String pathToTemplateFolder, String pathToDestinationFolder) {
		
		File templateFolder = new File(pathToTemplateFolder);
		File modelFile = new File(pathToModelFile);
		File destinationFolder = new File(pathToDestinationFolder);			

		boolean valid = true;
		
		if (!templateFolder.exists()) {
			LOGGER.error("This is not a valid template folder: " + templateFolder.getAbsolutePath());
			valid = false;
		}
		if (!modelFile.exists()) {
			LOGGER.error("This is not a valid model file: " + modelFile.getAbsolutePath());
			valid = false;
		}
		if (!destinationFolder.exists()) {
			LOGGER.error("This is not a valid destination folder: " + destinationFolder.getAbsolutePath());
			valid = false;
		}

		return valid;
	
	}

	public void run() {
		LOGGER.info("Running Gengulator");
	}

}

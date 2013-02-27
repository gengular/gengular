package com.gengular.main.util;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FileUtilities {

	final static Logger LOGGER = LoggerFactory.getLogger(FileUtilities.class);	

	/**
	 * This method will look through all the files in the top level folder, 
	 * and all the sub folders, adding files to the list when they
	 * match the patterns that are provided.
	 * 
	 * @param folder the folder to start looking through
	 * @param stringPatterns the patterns to match the file paths with
	 * @param files the files list to add all the files to
	 * @return the list of files that match the patterns
	 */
	public static List<File> findFilesAndFoldersRecursively(final File folder, final List<File> files) {
		
		if (folder.isDirectory()) {
			File[] folderEntries = folder.listFiles();
			for (File entry : folderEntries) {
				if (entry.isDirectory()) {
					LOGGER.debug("Adding directory: " + entry.getPath());
					files.add(entry);
					findFilesAndFoldersRecursively(entry, files);
				} else {
					LOGGER.debug("     Adding file: " + entry.getPath());
					files.add(entry);
				}
			}						
		}
		return files;
		
	}

}
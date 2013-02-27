package com.gengular.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the Gengular client main class. This class has one functionality:
 * creating a blue print web site using Angular, based on a Model described in a
 * simple Excel file which should be given as a (command line) parameter.
 * 
 * @author tom.logghe
 * @since 29-dec-2012 13:58:44
 * 
 * @revision 01.00
 * @lastChangedBy tom.logghe
 * @lastChangedDate 29-dec-2012 14:18:24
 */
public class Gengular {

	final static Logger LOGGER = LoggerFactory.getLogger(Gengular.class);

	/**
	 * The main is called from the command line, using a bat file with all the
	 * appropriate parameters for the server and the directories.
	 * 
	 * @param args
	 *            an UNC path to an Excel file containing a Gengular Model.
	 */
	public static void main(String[] args) {
		boolean success = Boolean.TRUE;

		// TODO: proper command line parsing.
		if (args.length != 1) {
			success = Boolean.FALSE;
			LOGGER.info("Please provide one parameter: the UNC path to an Excel file containing a Genugular Model");
		} else {
			LOGGER.info("Gengularing from file: " + args[0]);
			startProcess(args[0]);
		}

		System.exit(success ? 0 : 1);
	}

	private static void startProcess(String pathToModelFile) {

	}

}

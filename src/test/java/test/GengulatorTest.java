package test;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gengular.main.Gengulator;
import com.gengular.main.util.FileUtilities;

public class GengulatorTest {

	final static Logger LOGGER = LoggerFactory.getLogger(GengulatorTest.class);	
	
	String pathToTemplateFolder = "src/test/resources/templates/unittest";
	String pathToModelFile = "src/test/resources/models/unittest.xls";
	String pathToDestinationFolder = "work/unittest";	
	
	@Before
	public void before() {
		cleanup();
		try {
			FileUtils.forceMkdir(new File(pathToDestinationFolder));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After
	public void after() {
		cleanup();
	}

	private void cleanup() {
		try {
			FileUtils.deleteDirectory(new File("pathToDestinationFolder"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGengulator() {

		Gengulator gengulator = new Gengulator(pathToModelFile, pathToTemplateFolder, pathToDestinationFolder);	
		gengulator.run();
		
		List<File> filesAndFolders = FileUtilities.findFilesAndFoldersRecursively(new File(pathToDestinationFolder), new ArrayList<File>());
		assertNotNull(filesAndFolders);		
		
	}
}

package libsvm;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ArrayOOBTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, URISyntaxException {
		final v32OOB bug = new v32OOB();
		final Path p = Paths.get(ArrayOOBTest.class.getResource("/data.csv").toURI());

		try (BufferedReader bw = Files.newBufferedReader(p, StandardCharsets.UTF_8)) {
			String line = "";
			final List<double[]> trainingData = new ArrayList<>();
			while ((line = bw.readLine()) != null) {
				if (!line.isEmpty()) {
					final String[] split = line.split(",");
					final double[] row = new double[split.length];
					for (int i = 0; i < split.length; i++) {
						row[i] = Double.parseDouble(split[i]);
					}
					trainingData.add(row);
				}
			}
			bug.train(trainingData);
		}
	}

}

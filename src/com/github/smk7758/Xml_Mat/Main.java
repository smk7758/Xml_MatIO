package com.github.smk7758.Xml_Mat;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Main {
	static final String filePathString = "F:\\users\\smk7758\\Desktop\\test.xml";
	static final Path filePath = Paths.get(filePathString);

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public static void main(String[] args) {
		outputTest0();

		Mat mat = inputTest();

		outputTest1(mat);
	}

	public static Mat inputTest() {
		return MatIO.loadMat(filePath);
	}

	public static void outputTest1(Mat mat) {
		MatIO.exportMat(mat, filePath);
	}

	public static void outputTest0() {
		// Output
		String testImagePathString = "F:\\users\\smk7758\\Desktop\\smk7758.png";
		Mat testMat = Imgcodecs.imread(testImagePathString);
		System.out.println(testMat.dump());
		MatIO.exportMat(testMat, filePath);
	}
}

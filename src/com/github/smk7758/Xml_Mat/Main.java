package com.github.smk7758.Xml_Mat;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

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
		Map<String, Mat> mats = new HashMap<>();
		mats.put("marker", Imgcodecs.imread("F:\\users\\smk7758\\Desktop\\marker_2018-12-01.png"));
		mats.put("smk7758", Imgcodecs.imread("F:\\users\\smk7758\\Desktop\\smk7758.png"));

		MatIO.exportMat(mats, filePath);

		Map<String, Mat> mats_ = MatIO.loadMat(filePath);
		mats_.forEach((name, mat) -> System.out.println(name));
	}

}

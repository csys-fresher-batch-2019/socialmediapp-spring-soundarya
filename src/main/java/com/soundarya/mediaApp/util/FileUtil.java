package com.soundarya.mediaApp.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileUtil {

		public static void WriteFile(String fname,String content, StandardOpenOption append) throws IOException
		{
			Path path=Paths.get(fname);
			byte [] bytes=content.getBytes();
			Files.write(path, bytes);
			
	}

}




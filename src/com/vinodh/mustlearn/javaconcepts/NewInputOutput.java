package com.vinodh.mustlearn.javaconcepts;

import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NewInputOutput {

	public static void main(String[] args) throws IOException {
		/**
		 * Path : Location of file or directory
		 * 
		 */

		Path defaultPath = Paths.get(System.getProperty("user.dir"));
		Path samedefaultPath = FileSystems.getDefault().getPath(System.getProperty("user.dir"));
		//Path commandLineArgs = Paths.get(args[0]);
		//Path uriPath = Paths.get(URI.create("C:\\Users\\Pavan\\git\\Java"));
		System.out.println(defaultPath + " ===== " + samedefaultPath);
			// selecting next folder structure from the paths
		Path nexttoDefaultPath = Paths.get(System.getProperty("user.dir"), "nextFolder","nextnextFolder","fileName");
		System.out.println("nexttoDefaultPath====="+nexttoDefaultPath);
		
		
		Path path = Paths.get(System.getProperty("user.home"));
		System.out.format("toString: %s%n", path.toString());
		System.out.format("getFileName: %s%n", path.getFileName());
		System.out.format("getName(0): %s%n", path.getName(0));
		System.out.format("getNameCount: %d%n", path.getNameCount());
		System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
		System.out.format("getParent: %s%n", path.getParent());
		System.out.format("getRoot: %s%n", path.getRoot());
		
		// convert to path
		path.toUri();
		path.toAbsolutePath();
		// removes any reduntant like . && /. directories in the path
		path.toRealPath(LinkOption.NOFOLLOW_LINKS);
		
		// join two paths
		path.resolve("joiningtheFiletoPath");
		
		// paths b/w two paths :: siblings
		defaultPath.relativize(nexttoDefaultPath);
		
		// comparing
		
		if(defaultPath.equals(samedefaultPath)){
			System.out.println(defaultPath + " ===== " + samedefaultPath);
				
		}
		
		if(defaultPath.startsWith(samedefaultPath)){
			System.out.println(defaultPath + " ===starts with== " + samedefaultPath);
			
		}
		
		if(defaultPath.endsWith(samedefaultPath)){
			System.out.println(defaultPath + " ==ends with === " + samedefaultPath);
			
		}
		
		
		/***
		 * File opertaions java.nio.Files :::
		  * 
		 */
	 // check file esistence and validity
		System.out.println("Is file exists ===>"+Files.isRegularFile(defaultPath, LinkOption.NOFOLLOW_LINKS));
		// two paths have same file
		System.out.println("same file/directory in different paths ==>"+Files.isSameFile(defaultPath, samedefaultPath));
		// Deletin a file
		//Files.delete("pathTODelete");
		// Files.deleteIfExists("deleteIfFileExistsinPath");
	
		
		// copy/move file/dir(no files inside dir are copied) && 
		// copy supports ==> input stream to file 
		//Files.copy("copyFrom", "copyTO", LinkOption.NOFOLLOW_LINKS);
			//Files.move(source, target, options);
	}
	
	
	// Meta Data : Data about other Data

}

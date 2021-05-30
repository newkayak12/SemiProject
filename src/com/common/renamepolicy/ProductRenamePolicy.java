package com.common.renamepolicy;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class ProductRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File oldFile) {
		
		File newFile = null;
		
		do {
			
			long currentTime = System.currentTimeMillis();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd_hh_mmssSSS");
			int randomN = (int)(Math.random()*1000000+1);
			
			
			String originalName = oldFile.getName();
			String ext = "";
			int dot = originalName.lastIndexOf(".");
			
					if(dot != -1) {
						ext = originalName.substring(dot);
					}
					
			String newName = "product_"+sdf.format(new Date(currentTime))+"_"+randomN+ext;
			newFile = new File(oldFile.getParent(),newName);
		}while( !createNewFile(newFile) );
		
		return newFile;
	} 
	
	
	
	private boolean createNewFile(File newFile) {
		
		try {
			return newFile.createNewFile();
		} catch (IOException e) {
			
		}
		
		return false;
	}

}

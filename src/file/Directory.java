package file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Directory {
	private String path;
	
	public Directory(String path) {
		this.path = path;
	}
	
	public List<File> getFiles(){
		return this.walkPath(this.path);
	}
	
    protected static List<File> walkPath( String path ) {   	
        List<File> fileList = new ArrayList<File>();
        for ( File f : new File(path).listFiles() ) {
            if (f.isDirectory()) {
            	fileList.addAll(walkPath(f.getAbsolutePath()));
            }
            else {
            	fileList.add(f);
            }
        }
        return fileList;
    }
}

package file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ArchiveDirectory {
	private String path;
	
	public ArchiveDirectory(String path) {
		this.path = path;
	}
	
	public List<ArchiveFile> getFiles(){
		return this.walkPath(this.path);
	}
	
    protected static List<ArchiveFile> walkPath(String path) {   	
        List<ArchiveFile> fileList = new ArrayList<ArchiveFile>();
        for (File f : new File(path).listFiles()) {
            if (f.isDirectory()) {
            	fileList.addAll(walkPath(f.getAbsolutePath()));
            } else {
            	fileList.add(new ArchiveFile(f));
            }
        }
        return fileList;
    }
}

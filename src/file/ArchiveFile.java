package file;

import java.io.File;

public class ArchiveFile {
	File systemFile;
	public ArchiveFile(File file) {
		this.systemFile = file;
	}
	public String getStringPath() {
		return this.systemFile.getAbsolutePath();
	}
}

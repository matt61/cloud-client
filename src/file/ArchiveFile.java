package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

public class ArchiveFile {
	File file;
	public ArchiveFile(File file) {
		this.file = file;
	}
	public String getStringPath() {
		return this.file.getAbsolutePath();
	}
	public String getMd5() throws IOException {
		FileInputStream fis = new FileInputStream(this.file);
		return DigestUtils.md5Hex(fis);
	}
}

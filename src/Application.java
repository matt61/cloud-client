import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Application {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		Configuration config = new Configuration("config.properties");
		file.ArchiveStore store = new file.ArchiveStore();
		String[] dirs = config.getConfig().getStringArray("backup.dirs");
		for (int i = 0; i < dirs.length; i++){
			file.ArchiveDirectory fileGroup = new file.ArchiveDirectory(dirs[i]);
			System.out.println(dirs[i]);
			for (file.ArchiveFile f : fileGroup.getFiles() ) {
				store.addArchiveFile(f);
				System.out.println(f.getStringPath());
			}
		}
		try {
			store.save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(dirs.length);	
	}
}

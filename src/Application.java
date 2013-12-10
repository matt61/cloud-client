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
		
		
        File raid5_disk1 = new File("raid5.disk1");
        File raid5_disk2 = new File("raid5.disk2");
        File raid5_disk3 = new File("raid5.disk3");
        long count = 0;
        try {
	        file.RaidStream raid5Stream = new file.RaidStream(new File[]{raid5_disk1, raid5_disk2, raid5_disk3});
	        FileInputStream in = new FileInputStream("/dev/random");
	        BufferedInputStream bis = new BufferedInputStream(in);
	        BufferedOutputStream raid5bos = new BufferedOutputStream(raid5Stream);
	        while(count < 1024*1024*2){
	            raid5bos.write(bis.read());
	            count++;
	        }
	        raid5bos.close();
	        bis.close();
        } catch (Exception e){
        	e.printStackTrace();
        }		
	}
}

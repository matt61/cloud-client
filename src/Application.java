import java.io.File;

public class Application {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		Configuration config = new Configuration("config.properties");
		Integer id = config.getConfig().getInt("number");
		String[] dirs = config.getConfig().getStringArray("backup.dirs");
		for (int i = 0; i < dirs.length; i++){
			file.ArchiveDirectory fileGroup = new file.ArchiveDirectory(dirs[i]);
			System.out.println(dirs[i]);
			for (file.ArchiveFile f : fileGroup.getFiles() ) {
				System.out.println(f.getStringPath());
			}
		}
		System.out.println(dirs.length);
	}
}

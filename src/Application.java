public class Application {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		Configuration config = new Configuration("config.properties");
		file.FileLoader fw = new file.FileLoader();
		fw.walk("/usr/local/polls-rails");
	}
}

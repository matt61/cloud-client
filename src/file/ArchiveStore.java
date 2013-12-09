package file;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public class ArchiveStore {
	private List<ArchiveFile> files = new ArrayList<ArchiveFile>();
	
	public void addArchiveFile(ArchiveFile file){
		this.files.add(file);
	}
	
	public void save() throws ParserConfigurationException{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document doc = docBuilder.newDocument();
	}
}

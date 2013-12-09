package file;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ArchiveStore {
	private List<ArchiveFile> files = new ArrayList<ArchiveFile>();
	
	public void addArchiveFile(ArchiveFile file){
		this.files.add(file);
	}
	
	public void save() throws ParserConfigurationException, TransformerException{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document doc = docBuilder.newDocument();
		
		Element rootElement = doc.createElement("archive");
		doc.appendChild(rootElement);

		for(ArchiveFile f : this.files){
			Element fileNode = doc.createElement("file");
			fileNode.appendChild(doc.createTextNode("100000"));
			rootElement.appendChild(fileNode);
		}
		
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		StreamResult result =  new StreamResult(new File("/tmp/test.xml"));
		transformer.transform(source, result);
	}
}

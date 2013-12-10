package file;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ArchiveStore {
	private List<ArchiveFile> files = new ArrayList<ArchiveFile>();
	
	public void addArchiveFile(ArchiveFile file){
		this.files.add(file);
	}
	
	public void save() throws ParserConfigurationException, TransformerException, DOMException, IOException{
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
		Element rootElement = doc.createElement("archive");
		doc.appendChild(rootElement);

		for(ArchiveFile f : this.files){
			Element fileNode = doc.createElement("file");
			Element pathNode = doc.createElement("path");
			Element hashNode = doc.createElement("hash");
			
			pathNode.appendChild(doc.createTextNode(f.file.getAbsolutePath()));
			hashNode.appendChild(doc.createTextNode(f.getMd5()));
			
			fileNode.appendChild(pathNode);
			fileNode.appendChild(hashNode);
			
			rootElement.appendChild(fileNode);
		}
		
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		StreamResult result =  new StreamResult(new File("/tmp/test.xml"));
		transformer.transform(source, result);
	}
}

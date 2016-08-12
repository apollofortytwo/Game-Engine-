package tools;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {

	Document document;

	public XMLReader(String path) {
		DocumentBuilderFactory bFactory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder dBuilder = bFactory.newDocumentBuilder();
			document = dBuilder.parse(XMLReader.class.getResourceAsStream(path));
			document.normalize();

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	public String getValueString(String elementTagName, String attribute) {
		NodeList rootNodes = document.getElementsByTagName(elementTagName);
		Node rootNode = rootNodes.item(0);
		Element noteElement = (Element) rootNode;

		return noteElement.getAttribute(attribute);
	}

	public int[][] getLayerArray(String elementTagName, String name) {
		NodeList rootNodes = document.getElementsByTagName(elementTagName);
		int i = 0;
		Element noteElement;
		while (true) {
			Node rootNode = rootNodes.item(i);
			noteElement = (Element) rootNode;
			//System.out.println(noteElement.getAttribute("name"));
			if (noteElement.getAttribute("name").equals(name)) {
				break;
			} else {
				i++;
			}
		}
		int col = Integer.valueOf(noteElement.getAttribute("width"));
		int row = Integer.valueOf(noteElement.getAttribute("height"));
		
		String data = noteElement.getTextContent();
		//System.out.println(data);
		int[][] table = new int[col][row];
		data = data.replaceAll(" ", "");
		data = data.replaceAll("\n", "");

		System.out.println(data);

		for (int x = 0; x < col; x++) {
			for (int y = 0; y < row; y++) {
				table[x][y] = Integer.valueOf((data.split(",")[(x * col) + y]));
			}
		}

		return table;
	}

	public int getValueInt(String elementTagName, String attribute) {
		NodeList rootNodes = document.getElementsByTagName(elementTagName);
		Node rootNode = rootNodes.item(0);
		Element noteElement = (Element) rootNode;

		return Integer.valueOf((noteElement.getAttribute(attribute)));
	}
}

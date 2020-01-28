import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;

public class DomWriteXml
{
    public static void main(String[] args) throws Exception
    {

        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder b = f.newDocumentBuilder();
        Document doc = b.newDocument();

        Element rooElement = doc.createElement("Students");
        Element studElement = doc.createElement("Student");
        Element namElement = doc.createElement("name");
        Element mailElement = doc.createElement("mail");
        Element idElement = doc.createElement("id");


        Text t1= doc.createTextNode("Siva");
        Text t2= doc.createTextNode("siva@pph.com");
        Text t3= doc.createTextNode("PPH-131");


        namElement.appendChild(t1);
        mailElement.appendChild(t2);
        idElement.appendChild(t3);


        studElement.appendChild(namElement);
        studElement.appendChild(mailElement);
        studElement.appendChild(idElement);

        rooElement.appendChild(studElement);
        doc.appendChild(rooElement);
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.transform(new DOMSource(doc),new StreamResult(new FileOutputStream("/home/siva_ganesh/java/xml/out.xml")));
    }
}

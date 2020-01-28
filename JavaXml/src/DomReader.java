import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;

public class DomReader
{
    public static void main(String[] args) throws Exception
    {
        File file = new File("/home/siva_ganesh/java/xml/cars.xml");
        DocumentBuilderFactory f= DocumentBuilderFactory.newInstance();
        DocumentBuilder b = f.newDocumentBuilder();
        Document doc = b.parse(file);
        System.out.print("Root Element: ");
        System.out.println(doc.getDocumentElement().getNodeName());
        NodeList list = doc.getElementsByTagName("supercars");
        System.out.println("Supercars presented are: "+list.getLength());
        for(int i=0;i<list.getLength();i++)
        {
            Node node = list.item(i);
            System.out.println("Cuurent Element: "+node.getNodeName());
            if(node.getNodeType()==Node.ELEMENT_NODE)
            {
                Element ele =(Element)node;
                System.out.println("Attribute is: "+ele.getAttribute("company"));
                NodeList nList = ele.getElementsByTagName("carname");
                System.out.println("Child nodes are: " +nList.getLength());
                for(int j=0;j<nList.getLength();j++)
                {
                    Node node1 = nList.item(j);
                    if(node1.getNodeType()==Node.ELEMENT_NODE)
                    {
                        Element ele1 = (Element)node1;
                        System.out.println("CarName is : "+ele1.getTextContent());
                        System.out.println("Attribute is :"+ ele1.getAttribute("type"));
                    }
                }
            }
        }

        NodeList list2 = doc.getElementsByTagName("luxurycars");
        System.out.println(list2.getLength());
        Element node2 = (Element) list2.item(0);
        System.out.println(node2.getAttribute("company"));
        NodeList list3 = node2.getElementsByTagName("carname");
        System.out.println(list3.getLength());
        for(int i=0;i<list3.getLength();i++)
        {
            Node n =list3.item(i);
            if(n.getNodeType()==Node.ELEMENT_NODE)
            {
                Element ele3 =(Element)n;
                System.out.println(n.getTextContent());
            }
        }
    }
}

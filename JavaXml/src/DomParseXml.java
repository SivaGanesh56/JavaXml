import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.List;

public class DomParseXml
{
    public static void main(String[] args) throws Exception
    {
        File fxmlFile = new File("/home/siva_ganesh/java/xml/college.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(fxmlFile);

        System.out.println(doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("staff");
        System.out.println(nList.getLength());
        for(int i=0;i<nList.getLength();i++)
        {
            Node node = nList.item(i);
            System.out.println(node.getNodeName());
            if(node.getNodeType()==Node.ELEMENT_NODE)
            {
                Element ele = (Element) node;
                System.out.println(ele.getAttribute("id"));
                System.out.println(ele.getElementsByTagName("name").item(0).getNodeName());
                System.out.println(ele.getElementsByTagName("age").item(0).getNodeName());
                System.out.println(ele.getElementsByTagName("salary").item(0).getNodeName());

            }
        }
    }
}

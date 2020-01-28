import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.FileHandler;

public class DomModify
{
    public static void main(String[] args) throws Exception
    {
        File file = new File("/home/siva_ganesh/java/xml/carInput.xml");
        DocumentBuilderFactory f= DocumentBuilderFactory.newInstance();
        DocumentBuilder b = f.newDocumentBuilder();
        Document doc = b.parse(file);

        Node supercar = doc.getElementsByTagName("supercars").item(0);
        NamedNodeMap attr = supercar.getAttributes();
        Node attrNode = attr.getNamedItem("company");
        attrNode.setTextContent("Honda");
        NodeList list = supercar.getChildNodes();
        for(int i=0;i<list.getLength();i++)
        {
            Node node = list.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE)
            {
                Element ele = (Element)node;
                if("carname".equals(ele.getNodeName()))
                {
                    if("Ferrari 101".equals(ele.getTextContent()))
                    {
                        ele.setTextContent("Honda 50");
                    }
                    if("Ferrari 202".equals(ele.getTextContent()))
                    {
                        ele.setTextContent("Honda Shine");
                    }
                }
            }
        }

        Node car = doc.getFirstChild();
        NodeList cars = car.getChildNodes();
        System.out.println(cars.getLength());
        for(int i=0;i<cars.getLength();i++)
        {
            Node node1 = cars.item(i);
            if("luxurycars".equals(node1.getNodeName()))
            {
                car.removeChild(node1);
            }
        }

        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.transform(new DOMSource(doc),new StreamResult(new FileOutputStream("/home/siva_ganesh/java/xml/carOutput.xml")));
    }
}

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;

public class JaxbMarsh2
{
    public static void main(String[] args) throws Exception
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        Student st = new Student(131,"Siva",20);
        marshaller.marshal(st,new FileOutputStream("/home/siva_ganesh/java/xml/StudentOut.xml"));
        System.out.println("Done!!!");
    }
}

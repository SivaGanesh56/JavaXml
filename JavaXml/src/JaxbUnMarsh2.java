import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbUnMarsh2
{
    public static void main(String[] args) throws Exception
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("/home/siva_ganesh/java/xml/StudentOut.xml");
        Student student = (Student)unmarshaller.unmarshal(file);
        System.out.println(student.getId()+" "+student.getName()+" "+student.getAge());
    }
}

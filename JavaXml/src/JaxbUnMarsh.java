import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbUnMarsh
{
    public static void main(String[] args) throws Exception
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("/home/siva_ganesh/java/xml/EmployeeOut.xml");
        Employee e = (Employee) unmarshaller.unmarshal(file);
        System.out.println(e.getId()+ " "+ e.getName()+" "+ e.getSalary());
    }
}

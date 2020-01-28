import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class JaxbMarsh3
{
    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Exam.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        List<Answer>list = new ArrayList<>();
        Answer ans1 = new Answer(10,"Java is Powerful Langauge","siva");
        Answer ans2 = new Answer(10,"AI is evolution in  modern era","Ganesh");
        list.add(ans1);
        list.add(ans2);
        Exam e = new Exam(131,"IT",list);
        marshaller.marshal(e,new FileOutputStream("/home/siva_ganesh/java/xml/Exam.xml"));
        System.out.println("Done!!!!");
    }
}

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JaxbUnMarsh3
{
    public static void main(String[] args) throws Exception
    {
        File file = new File("/home/siva_ganesh/java/xml/Exam.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Exam.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Exam e = (Exam) unmarshaller.unmarshal(file);
        List<Answer> ans = e.getAnswers();
        for(Answer answer : ans)
        {
            System.out.println(answer.getMarks()+" Marks==>"+ answer.getSolution()+" Posted by "+answer.getPostedBy());
        }
    }
}

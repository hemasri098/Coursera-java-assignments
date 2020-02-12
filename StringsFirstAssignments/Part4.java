
/**
 * Write a description of class Part4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part4
{
    
    public void callUrl()
    {
        //FileResource fr = new FileResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String s : ur.lines()) {
            String lowerCaseString = s.toLowerCase();
            int index = lowerCaseString.indexOf("youtube");
            
            if(index != -1) {
                //System.out.println(s);
                int startIndex = s.lastIndexOf("\"", index);
                int endIndex = s.indexOf("\"", index + 1);
                //System.out.println(startIndex);
                //System.out.println(endIndex);
                System.out.println(s.substring(startIndex, endIndex + 1));
            }
            /* for(String word:line) {
                System.out.println(word);
            } */
         }
    }
    public void testing() {
        callUrl();
    }
}

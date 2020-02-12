
/**
 * Write a description of class Part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part2
{
    
    public int howMany(String a, String b)
    {
        // put your code here
        int count = 0;
        int index = b.indexOf(a);
        while(index != -1) {
            count += 1;
            index = b.indexOf(a, index + a.length());
        }
        return count;
    }
    public void testHowMany() {
        System.out.println(howMany("GAA", "ATGAACGAATTGAAT"));
        System.out.println(howMany("AA", "ATAAAA"));
        
    }
}

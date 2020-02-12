
/**
 * Write a description of class Part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part2
{
    
    
    public float cgratio(String dna)
    {
        // put your code here
        int cgCount = 0;
        for(int i = 0 ; i < dna.length() ; i++) {
            char ch = dna.charAt(i);
            if(ch == 'C' || ch == 'G')
                cgCount += 1;
        }
        return (float)cgCount / dna.length();
    }
    public int countCTG(String dna) {
        int index = dna.indexOf("CTG");
        int count = 0;
        while(index != -1) {
            count += 1;
            dna = dna.substring(index + 1, dna.length());
            index = dna.indexOf("CTG");
        }
        return count;
    }
    public void testCountCTG() {
        System.out.println(countCTG("CTGCTGCTG"));
    }
}

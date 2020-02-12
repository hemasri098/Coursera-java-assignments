
/**
 * Write a description of class Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part1
{
 
    public String findSimpleGene(String dna)
    {
        // put your code here
        String gene = "";
        int startCodon = dna.indexOf("ATG");
        int stopCodon = dna.indexOf("TAA");
        if(startCodon == -1 || stopCodon == -1) {
            return gene;
        }
        else if((stopCodon - startCodon) % 3 == 0){
            gene = dna.substring(startCodon, stopCodon + 3);
        }
        return gene;
    }
    public void testSimpleGene() {
        String testcase1 = "AACTGTAA";
        String testcase2 = "AACATG";
        String testcase3 = "AACATTCCG";
        String testcase4 = "AACATGCTTTAA";
        String testcase5 = "AACATGCTTAA";
        System.out.println("without ATG for " + testcase1 + " = " + findSimpleGene(testcase1));
        System.out.println("without TAA for " + testcase2 + " = " + findSimpleGene(testcase2));
        System.out.println("without ATG and TAA for " + testcase3 + " = " + findSimpleGene(testcase3));
        System.out.println("with multiple of 3 between ATG and TAA for " + testcase4 + " = " + findSimpleGene(testcase4));
        System.out.println("without multiple of 3 between ATG and TAA for " + testcase5+ " = " + findSimpleGene(testcase1));
        
    }
}

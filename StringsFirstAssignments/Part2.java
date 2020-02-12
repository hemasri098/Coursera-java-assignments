
/**
 * Write a description of class Part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part2
{ 
    public String findSimpleGene(String dna, String startCodon, String stopCodon)
    {
        // put your code here
        String gene = "";
        int startIndex= dna.indexOf(startCodon);
        int stopIndex = dna.indexOf(stopCodon);
        if(startIndex == -1 || stopIndex == -1) {
            return gene;
        }
        else if((stopIndex - startIndex) % 3 == 0){
            gene = dna.substring(startIndex, stopIndex + 3);
        }
        if(Character.isUpperCase(dna.charAt(0)))
            return gene.toLowerCase();
        else
            return gene.toUpperCase();
    }
    public void testSimpleGene() {
        String testcase1 = "AACTGTAA";
        String testcase2 = "AACATG";
        String testcase3 = "AACATTCCG";
        String testcase4 = "aacttatgcctccttaa";
        String testcase5 = "AACATGCTTAA";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        System.out.println("without ATG for " + testcase1 + " = " + findSimpleGene(testcase1, startCodon, stopCodon));
        System.out.println("without TAA for " + testcase2 + " = " + findSimpleGene(testcase2, startCodon, stopCodon));
        System.out.println("without ATG and TAA for " + testcase3 + " = " + findSimpleGene(testcase3, startCodon, stopCodon));
        System.out.println("with multiple of 3 between ATG and TAA for " + testcase4 + " = " + findSimpleGene(testcase4, "atg", "taa"));
        System.out.println("without multiple of 3 between ATG and TAA for " + testcase5+ " = " + findSimpleGene(testcase5, startCodon, stopCodon));
        
    }

}

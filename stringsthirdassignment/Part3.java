import edu.duke.*;

/**
 * Write a description of class Part3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part3
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
    public void processGenes(StorageResource sr)
    {
        int charcount = 0;
        int cgcount = 0;
        int length = 0;
        String str = "";
        for(String s : sr.data()) {
            if(s.length() > length) {
                length = s.length();
                str = s;
            }
            if(s.length() > 9) {
                charcount += 1;
                System.out.println(s);
            }
            if(cgratio(s) > 0.35) {
                cgcount += 1;
                System.out.println(s);
            }
        }
        System.out.println(charcount);
        System.out.println(cgcount);
        System.out.println(str);
    }
    public int findStopCodon(String dna, int startIndex, String stopCodon)
    {
        // put your code here
        String gene = "";
        int stopIndex = dna.indexOf(stopCodon, startIndex);
        if(stopIndex != -1 && (stopIndex - startIndex) % 3 == 0)
            return stopIndex;
        return dna.length();
        
    }
    public String findGene(String dna) {
        String gene = "";
        String taa_gene = dna;
        String tag_gene = dna;
        String tga_gene = dna;
        int startCodon = dna.indexOf("ATG");
        
        if(startCodon != -1) {
            int index = findStopCodon(dna, startCodon + 3, "TAA");
            //System.out.println(index);
            if(index != dna.length() && ((index - startCodon) % 3 == 0)) {
                taa_gene = dna.substring(startCodon, index + 3);
                
            }
        }
        if(startCodon != -1) {
            int index = findStopCodon(dna, startCodon + 3, "TAG");
            if(index != dna.length() && ((index - startCodon) % 3 == 0)) {
                tag_gene =  dna.substring(startCodon, index + 3);
                
            }
        }
        
        if(startCodon != -1) {
            int index = findStopCodon(dna, startCodon + 3, "TGA");
            if(index != dna.length() && ((index - startCodon) % 3 == 0)) {
                tga_gene = dna.substring(startCodon, index + 3);
                
            }
        }
        
        
        if(taa_gene.length() < tag_gene.length()) {
            if(taa_gene.length() < tga_gene.length())
               gene = taa_gene;
            else
               gene = tga_gene;
            }
        else {
            if(tag_gene.length() < tga_gene.length()) 
               gene = tag_gene;
            else 
               gene = tga_gene;
        }
        
        return gene;
    }
   
    public StorageResource getAllGenes(String dna) {
        //int index = 0;
        StorageResource sr = new StorageResource();
        while(true) {
            int startIndex = dna.indexOf("ATG");
            //System.out.println(startIndex);
            if(startIndex == -1)
                break;
            else {
                //System.out.println(dna);
                
                sr.add(findGene(dna));
                if(startIndex + 3 < dna.length())
                   dna = dna.substring(startIndex + 3, dna.length());
                else
                    break;
            }
        }
        return sr;
    }
    public void testProcessGenes()
    {
        //StorageResource sr = new StorageResource("ATGTTTTAA");
        // FileResource fr = new FileResource("brca1line.fa");
        //String dna = fr.asString();
        //processGenes(getAllGenes(dna));
        processGenes(getAllGenes("ATGTTATATTAAATGATGTAATAATGATGATAGATGGTTATAAT"));
    }
}

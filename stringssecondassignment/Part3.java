
/**
 * Write a description of class Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part3
{
    
   
    public int findStopCodon(String dna, int startIndex, String stopCodon)
    {
        // put your code here
        String gene = "";
        int stopIndex = dna.indexOf(stopCodon, startIndex);
        if(stopIndex != -1 && (stopIndex - startIndex) % 3 == 0)
            return stopIndex;
        return dna.length();
        
    }
    
    public void testFindStopCodon () {
        System.out.println(findStopCodon("ATGATAGTAATGAATAA", 0, "TAA"));
        System.out.println(findStopCodon("ATGATAGTAATGAATAA", 0, "TAG"));
        System.out.println(findStopCodon("ATGATAGTAATGAATAA", 0, "TGA"));
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
    public void testFindGene() {
        System.out.println(findGene("ATTGATAGTAATGAATAATAGTGA"));
        System.out.println(findGene("ATGATATAAGTAATGAATAA"));
        System.out.println(findGene("ATGATAGGATTAGTAATGAATAA"));
    }
    public void printAllGenes(String dna) {
        //int index = 0;
        while(true) {
            int startIndex = dna.indexOf("ATG");
            //System.out.println(startIndex);
            if(startIndex == -1)
                break;
            else {
                //System.out.println(dna);
                System.out.println(findGene(dna));
                if(startIndex + 3 < dna.length())
                   dna = dna.substring(startIndex + 3, dna.length());
                else
                    break;
            }
        }
    }
    public int countGenes(String dna) {
        int count = 0;
        while(true) {
            int startIndex = dna.indexOf("ATG");
            //System.out.println(startIndex);
            if(startIndex == -1)
                break;
            else {
                //System.out.println(dna);
                count += 1;
                findGene(dna);
                if(startIndex + 3 < dna.length())
                   dna = dna.substring(startIndex + 3, dna.length());
                else
                    break;
            }
        }
        return count;
    }
    public void ex() {
        String dna = "CTGCCTGCATGATCGTA";
        int pos = dna.indexOf("TG");
        int count = 0;
        while (pos >= 0) {
          count = count + 1;
          pos = dna.indexOf("TG",pos);
        }
        System.out.println(count);
    }
    public void testCountGenes() {
        System.out.println(countGenes("ATGTAAGATGCCCTAGT"));
    }
}

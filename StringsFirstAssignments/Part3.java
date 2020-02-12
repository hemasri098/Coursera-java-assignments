
/**
 * Write a description of class Part3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part3
{
    public boolean twoOccurences(String stringa, String stringb) {
        int firstIndex = stringb.indexOf(stringa);
        int secondIndex = stringb.indexOf(stringa, firstIndex + stringa.length());
        if(firstIndex != -1 && secondIndex != -1) {
            return true;
        }
        return false;
    }
    public String lastPart(String stringa, String stringb) {
        int firstIndex = stringb.indexOf(stringa);
        //int secondIndex = stringb.indexOf(stringa, firstIndex + stringa.length());
        if(firstIndex != -1) {
            return stringb.substring(firstIndex + stringa.length());
        }
        return stringb;
    }
    public void testing() {
        String stringa = "an";
        String stringb = "banana";
        System.out.println(twoOccurences("ab", "aabbbbab"));
        System.out.println(twoOccurences("ab", "aabbbbabab"));
        System.out.println(twoOccurences("ab", "aabbbb"));
        System.out.println(twoOccurences("ab", "bbbb"));
        System.out.println("The part of the string after " + stringa + " in " + stringb +" is " + lastPart(stringa, stringb));
        System.out.println("The part of the string after zoo in forest is " + lastPart("zoo", "forest"));

    }
}

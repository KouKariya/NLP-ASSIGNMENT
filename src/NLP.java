import java.io.File;
import java.util.HashMap;

public class NLP {

    public File file;
    public In input;
    public String word;                 //String that holds the cleaned up word before and after splitting trigrams
    public String trigram;              //String that holds trigram
    private int totalTrigramCount = 0; //create method to return this number
    private int frequency = 1;         //frequency of trigram that appears in a text

    public HashMap hm = new HashMap();
    String[] words;
    String[] cleanWords;


    public NLP(String filename){
        file = new File(filename);
        input = new In(file);

    }

    public void start(){
        words = input.readAllStrings();
        cleanWords = new String[words.length];

        //For loop to clean up text from input
        //strips all non letter chars, ignores caps and delimits by spaces
        for (int i = 0; i <words.length ; i++) {
            String s = words[i].toLowerCase();
            s = s.replaceAll("\\W+","");
//          Test to iterate through strings without punctuation
            cleanWords[i] = s;
//            System.out.println(cleanWords[i]);
        }
        int j = 0;
        try {
            while (getNextWord(cleanWords[j]) == true) {
//                System.out.println("Original Word: "+word);
                totalTrigramCount += word.length() - 2; //Add the original amount of trigrams onto value.
                                                        //V   alue will be needed when calculating probability.
                try{
                    while (getNextTrigram(word) == true) {
                        //System.out.println(trigram);    //add the trigram to the node w/ frequency
                        if(hm.containsKey(trigram)){
                            int t = (int) hm.get(trigram);
                            hm.remove(trigram);
                            int temp = t+1;
                            hm.put(trigram,temp);
                        }
                        else{
                            hm.put(trigram,frequency);
                        }

//                        System.out.println("After trigram split: " + word);
                    }
                }
                catch (NullPointerException n){}
//                System.out.println("---------------------"); //splits stuff up
                j++; //Iterates through the String[] of words within the text
            }
        }
        catch (ArrayIndexOutOfBoundsException e){}
    }

    public boolean getNextWord(String w){
        if(!w.equals(null)){
            word = " "+w+" ";
            return true;
        }
        else
            return false;
    }
    public boolean getNextTrigram(String w){
        if(w.length() == 0)
            return false;

        if(w.length() -2 == 1){
            trigram = w;
            word = null;
            return true;
        }
        if(w.length() - 2 == 2){
            trigram = w.substring(0,2);
            word = w.substring(1);
        }

        if((w.length() - 2) > 2){
            trigram = w.substring(0,3);
            word =  w.substring(1);
            return true;
        }
        else
            return false;
    }
    public int getTotalTrigramCount(){
        return totalTrigramCount;
    }
    public int getFrequency(String t){
        if(hm.containsKey(t)){
            return (int) hm.get(t);
        }
        else
            return 0;
    }
    public HashMap<String,Integer> getHashMap(){
        HashMap<String, Integer> subMap = new HashMap<String,Integer>();
        subMap.putAll(hm);
        return subMap;
    }
    public int returnNumOfWords(){
        return cleanWords.length;
    }
}

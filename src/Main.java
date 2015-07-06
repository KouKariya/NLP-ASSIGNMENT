/*

Move things around so that it goes thru a file and scans thru the trigrams the way they're intended.

 */
import java.util.*;

public class Main {

    /*
     * Class that stores the trigram with its associated frequency within the Node class.
     */
    public static class Tri {
        String t;
        int i;

        public Tri(String t, int i) {
            this.t = t;
            this.i = i;
        }

        public String getTri() {
            return t;
        }

        public int getFreq() {
            return i;
        }
    }

    private static LinkedList ll;
    private static HashMap hmp;
    private static Node first = null;
    private static Node last = null;
    private static Tri tri;
    private static int totalTrigramCount;

    public static void main(String[] args) {
        String input1 = args[0];

        NLP nlp = new NLP(input1);
        nlp.start();
        //System.out.println(nlp.getTotalTrigramCount());
        totalTrigramCount = nlp.getTotalTrigramCount();
        StringBuilder strB = new StringBuilder();  //
        //System.out.println(nlp.getFrequency("her"));
        System.out.println();
        //System.out.println(nlp.getHashMap());   //Test
        hmp = nlp.getHashMap(); //Test
        ll = new LinkedList();

        Iterator<Map.Entry<String, Integer>> itr = hmp.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            tri = new Tri(entry.getKey(), entry.getValue());
            Node n = new Node(tri);
            ll.add(n);
            first = n;
            last = first;
        }
        System.out.println();
        Collections.sort(ll, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.getTrigramWord().compareTo(o2.getTrigramWord()) > 0) {
                    return -1;
                }
                if (o1.getTrigramWord().compareTo(o2.getTrigramWord()) < 0) {
                    return 1;
                } else
                    return 0;
            }
        });


        System.out.println("Trigram-----Frequency--Probability");

        while(!ll.isEmpty()){
            Node top = (Node) ll.remove();
            float probability = (float) top.getFreqNum() / totalTrigramCount;
            System.out.printf("%s   %.8f\n", top, probability);
        }


    }
}

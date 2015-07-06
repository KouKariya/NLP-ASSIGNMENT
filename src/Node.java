public class Node {
    public Main.Tri trigram;
    public Node next;
    public Node(Main.Tri trigram){
        this.trigram = trigram;
        next = null;
    }
    public Node(Main.Tri trigram, Node next){
        this.trigram = trigram;
        this.next = next;
    }
    public String toString(){
        return "["+trigram.getTri()+"]"+"       "+trigram.getFreq()+"       ";
    }
    public String getTrigramWord(){
        return trigram.getTri();
    }
    public int getFreqNum(){
        return trigram.getFreq();
    }
}

package iterator;

public class Client {
    public static void main(String[] args) {
    	String names[] = {"Robert" , "John" ,"Julie" , "Lora"};
        NameCollection nameCollection = new NameCollection(names);
        for (Iterator iter = nameCollection.getIterator(); iter.hasMore();) {
            String name = (String) iter.getNext();
            System.out.println("Name : " + name);
        }
    }
}
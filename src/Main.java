
import trie.TriePure;

public class Main {
    public static void main(String[] args) {
        TriePure trie = new TriePure();

       
        trie.insert("casa");
        trie.insert("corro");
        trie.insert("cachorro");
        trie.insert("caminho");
        trie.insert("cantar");
        trie.insert("cafe");
        trie.insert("casa");

        
        System.out.println("search(casa): " + trie.search("casa"));
        System.out.println("search(cachorro): " + trie.search("cachorro"));
        System.out.println("search(cafeteria): " + trie.search("cafeteria"));
        
        

        System.out.println("startsWith(ca): " + trie.startsWith("ca"));
        System.out.println("startsWith(cb): " + trie.startsWith("cb"));

        
        String[] sug = trie.suggestions("ca", 10);
        System.out.println("Sugestões para 'ca':");
        for (String suggestion : sug) {
            System.out.println(" - " + suggestion);
        }
    }
}

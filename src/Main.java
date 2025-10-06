
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

        System.out.println("\n=== TESTES DE REMOÇÃO ===");
        
        System.out.println("Removendo 'casa': " + trie.remove("casa"));
        System.out.println("search(casa) após remoção: " + trie.search("casa"));
        System.out.println("search(cachorro) ainda existe: " + trie.search("cachorro"));
        
        System.out.println("Removendo 'cachorro': " + trie.remove("cachorro"));
        System.out.println("search(cachorro) após remoção: " + trie.search("cachorro"));
        
        System.out.println("Tentando remover palavra inexistente 'inexistente': " + trie.remove("inexistente"));
        
        System.out.println("\nSugestões para 'ca' após remoções:");
        String[] sug2 = trie.suggestions("ca", 10);
        for (String suggestion : sug2) {
            System.out.println(" - " + suggestion);
        }
    }
}

import java.util.List;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.addConnection("Alice", "Bob");
        socialNetwork.addConnection("Alice", "Charlie");
        socialNetwork.addConnection("Alice", "Kevin");
        socialNetwork.addConnection("Bob", "Alice");
        socialNetwork.addConnection("Bob", "David");
        socialNetwork.addConnection("Charlie", "Alice");
        socialNetwork.addConnection("David", "Bob");

        List<String> aliceConnections = socialNetwork.getConnections("Alice");
        System.out.println(aliceConnections); // Output: [Bob, Charlie]

        List<String> bobConnections = socialNetwork.getConnections("Bob");
        System.out.println(bobConnections);   // Output: [Alice, David]

        System.out.println(socialNetwork.areConnected("Alice", "Bob")); // Output: false
        

        String graphvizContent = socialNetwork.toGraphviz();
        System.out.println(graphvizContent);
    }
}

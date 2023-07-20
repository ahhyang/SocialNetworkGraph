import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SocialNetwork {
    private Map<String, List<String>> connections;

    public SocialNetwork() {
        this.connections = new HashMap<>();
    }

    public void addConnection(String user, String connection) {
        connections.computeIfAbsent(user, k -> new ArrayList<>()).add(connection);
    }

    public List<String> getConnections(String user) {
        return connections.getOrDefault(user, new ArrayList<>());
    }

    public boolean areConnected(String user1, String user2) {
        List<String> user1Connections = getConnections(user1);
        return user1Connections.contains(user2);
    }

    public String toGraphviz() {
        StringBuilder x1 = new StringBuilder();
        x1.append("graph theConnections {\n"); 

        for (String user : connections.keySet()) {
            List<String> userConnections = connections.get(user);
            for (String connection : userConnections) {
                x1.append("    ").append(user).append(" -- ").append(connection).append(";\n");
            }
        }

        x1.append("}");
        return x1.toString();
    }
}

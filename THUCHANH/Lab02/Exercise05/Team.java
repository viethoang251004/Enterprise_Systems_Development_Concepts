import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String teamName;
    private ArrayList<String> players;

    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new ArrayList<>();
    }

    public void addPlayer(String player) {
        players.add(player);
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    public void printTeamInfo() {
        System.out.println("Team Name: " + teamName);
        System.out.println("Players: " + players);
    }
}

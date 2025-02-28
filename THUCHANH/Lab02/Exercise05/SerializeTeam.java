import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeTeam {
    public static void main(String[] args) {
        Team team = new Team("Dream Team");
        team.addPlayer("Cristiano Ronaldo");
        team.addPlayer("Lionel Messi");
        team.addPlayer("M3BAPPE");

        try {
            FileOutputStream fileOut = new FileOutputStream("team.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(team);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in team.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}

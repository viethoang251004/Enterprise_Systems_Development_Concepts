import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeTeam {
    public static void main(String[] args) {
        Team team = null;

        try {
            FileInputStream fileIn = new FileInputStream("team.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            team = (Team) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Team class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Team:");
        team.printTeamInfo();
    }
}

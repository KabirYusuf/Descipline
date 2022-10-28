package archeryGameOOP;

import java.security.SecureRandom;

public class Player {

    private final int playerNumber;

    private static int count = 0;

    public Player(){
        playerNumber = count + 1;
        count++;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public int shoot() {
        SecureRandom secureRandom = new SecureRandom();
        int point = secureRandom.nextInt(11);
        return point;
    }

    public boolean isAValidPoint() {
        if(shoot() >= 0 && shoot() <= 10)return true;
        else return false;
    }
}

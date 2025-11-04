package rosa.ribeiro.jonas.status;

public class CombatStatus {
    private int attackPower;
    private int defensePower;
    private int magicPower;
    private int speed;
    private int accuracy;
    private int evasion;

    public CombatStatus(int attackPower, int defensePower, int magicPower, int speed, int accuracy, int evasion) {
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.magicPower = magicPower;
        this.speed = speed;
        this.accuracy = accuracy;
        this.evasion = evasion;
    }


}

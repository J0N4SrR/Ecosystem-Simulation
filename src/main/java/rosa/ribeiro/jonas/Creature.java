package rosa.ribeiro.jonas;

public class Creature {
    private String nickname;
    private int hp;
    private int hungry;
    private int stamina;
    private int staminaMax;
    private int thirst;
    private int thirstMax;
    private Coordinate position;

    public Creature(String nickname, int hp, int hungry, int staminaMax, int thirstMax, Coordinate position) {
        this.nickname = nickname;
        this.hp = hp;
        this.hungry = hungry;
        this.stamina = staminaMax;
        this.staminaMax = staminaMax;
        this.thirst = 0;
        this.thirstMax = thirstMax;
        this.position = position;
    }



    public Creature() {
    }



    public String getNickname() {
        return nickname;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHungry() {
        return hungry;
    }

    public void setHungry(int hungry) {
        this.hungry = hungry;
    }

    public int getStamina() { return stamina;}

    public int getStaminaRatio() { return (int)((stamina * 100)/staminaMax) ;}

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getThirst() {
        return thirst;
    }

    public int getThirstDangerZone() { return (int) (thirstMax * 0.6); }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("""
            🧬 Creature: %s
              • HP: %d
              • Fome: %d
              • Stamina: %d
              • Sede: %d
              • Posição: %s
            """, nickname, hp, hungry, stamina, thirst, position);
    }

}

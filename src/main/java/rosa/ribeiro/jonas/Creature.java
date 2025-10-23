package rosa.ribeiro.jonas;

public class Creature {
    private int hp;
    private int hungry;
    private int stamina;
    private int thirst;
    private Coordinate position;

    public Creature(int hp, int hungry, int stamina, int thirst, Coordinate position) {
        this.hp = hp;
        this.hungry = hungry;
        this.stamina = stamina;
        this.thirst = thirst;
        this.position = position;
    }

    public Creature() {
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

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }
}

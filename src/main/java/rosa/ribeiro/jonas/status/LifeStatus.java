package rosa.ribeiro.jonas.status;

import rosa.ribeiro.jonas.world.Coordinate;

public class LifeStatus {

    private int hp;
    private int hungry;
    private final int hungryMax;
    private int stamina;
    private final int staminaMax;
    private int thirst;
    private final int thirstMax;

    public LifeStatus(int hp, int hungryMax, int staminaMax, int thirstMax) {
        this.hp = hp;
        this.hungry = 0;
        this.hungryMax = hungryMax;
        this.stamina = staminaMax;
        this.staminaMax = staminaMax;
        this.thirst = 0;
        this.thirstMax = thirstMax;
    }

    public int getHungryMax() {
        return hungryMax;
    }

    public int getStaminaMax() {
        return staminaMax;
    }

    public int getThirstMax() {
        return thirstMax;
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
        this.hungry = Math.min(hungry, hungryMax);
    }

    public int getStamina() { return stamina;}


    public void setStamina(int stamina) {
        this.stamina = Math.min(stamina, staminaMax);
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }



    @Override
    public String toString() {
        return String.format("""            
              • HP: %d
              • Fome: %d
              • Stamina: %d
              • Sede: %d
            """, hp, hungry, stamina, thirst);
    }
}

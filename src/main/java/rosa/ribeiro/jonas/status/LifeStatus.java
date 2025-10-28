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
    private Coordinate position;

    public LifeStatus(int hp, int hungryMax, int staminaMax, int thirstMax, Coordinate position) {
        this.hp = hp;
        this.hungry = 0;
        this.hungryMax = hungryMax;
        this.stamina = staminaMax;
        this.staminaMax = staminaMax;
        this.thirst = 0;
        this.thirstMax = thirstMax;
        this.position = position;
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

    public int getStaminaRatio() { return (int)((stamina * 100)/staminaMax) ;}

    public void setStamina(int stamina) {
        this.stamina = Math.min(stamina, staminaMax);
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
              • HP: %d
              • Fome: %d
              • Stamina: %d
              • Sede: %d
              • Posição: %s
            """, hp, hungry, stamina, thirst, position);
    }
}

package rosa.ribeiro.jonas.creatures;

import rosa.ribeiro.jonas.status.CombatStatus;
import rosa.ribeiro.jonas.status.LifeStatus;
import rosa.ribeiro.jonas.world.Coordinate;

public class Creature {
    private final String nickname;
    private CreatureCategory creatureCategory;
    private LifeStatus lifeStatus;
    private Coordinate position;


    public Creature(String nickname, LifeStatus lifeStatus, CreatureCategory creatureCategory, Coordinate position) {
        this.lifeStatus = lifeStatus;
        this.nickname = nickname;
        this.creatureCategory =  creatureCategory;
        this.position = position;
    }


    public LifeStatus getLifeManager() {
        return lifeStatus;
    }


    public String getNickname() {
        return nickname;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "nickname='" + nickname + '\'' +
                ", creatureCategory=" + creatureCategory +
                ", lifeStatus=" + lifeStatus +
                ", position=" + position +
                '}';
    }
}

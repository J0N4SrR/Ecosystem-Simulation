package rosa.ribeiro.jonas.creatures;

import rosa.ribeiro.jonas.status.CombatStatus;
import rosa.ribeiro.jonas.status.LifeStatus;

public class Creature {
    private String nickname;
    private CreatureCategory creatureCategory;
    private LifeStatus lifeStatus;

    public Creature(String nickname, LifeStatus lifeStatus, CreatureCategory creatureCategory) {
        this.lifeStatus = lifeStatus;
        this.nickname = nickname;
        this.creatureCategory =  creatureCategory;
    }

    public Creature() {
    }


    public LifeStatus getLifeManager() {
        return lifeStatus;
    }

    public void setLifeManager(LifeStatus lifeStatus) {
        this.lifeStatus = lifeStatus;
    }

    public String getNickname() {
        return nickname;
    }



}

package rosa.ribeiro.jonas;

import rosa.ribeiro.jonas.creatures.Creature;
import rosa.ribeiro.jonas.creatures.CreatureCategory;
import rosa.ribeiro.jonas.creatures.LifeManager;
import rosa.ribeiro.jonas.resouces.Resource;
import rosa.ribeiro.jonas.resouces.Water;
import rosa.ribeiro.jonas.status.LifeStatus;
import rosa.ribeiro.jonas.world.Coordinate;
import rosa.ribeiro.jonas.world.TimeController;
import rosa.ribeiro.jonas.world.WorldEngine;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!\n\n");

        final List<LifeManager> lifeManagers = new ArrayList<>();
        final List<Resource> resources = new ArrayList<>();

        // Testando
        Creature grifoAlpha = new Creature("Grifo Alpha", new LifeStatus(15, 10, 10,15), CreatureCategory.HUNTER, new Coordinate(0, 0));
        Creature grifoBeta  = new Creature("Grifo Beta", new LifeStatus(12,10, 15, 10),CreatureCategory.HUNTER, new Coordinate(2, 1));
        Creature lobo       = new Creature("Lobo", new LifeStatus(10, 15, 10, 6), CreatureCategory.HUNTER, new Coordinate(5, -2));
        Creature coelho     = new Creature("Coelho", new LifeStatus(4, 15, 6, 10),CreatureCategory.PREY, new Coordinate(-3, 1));
        Creature coelho1     = new Creature("Coelho01", new LifeStatus(4, 15, 6, 10),CreatureCategory.PREY, new Coordinate(-3, 1));
        Creature coelho2     = new Creature("Coelho02", new LifeStatus(1, 4, 6, 10),CreatureCategory.PREY, new Coordinate(-3, 1));
        Creature coelho3    = new Creature("Coelho03", new LifeStatus(1, 5, 6, 10),CreatureCategory.PREY, new Coordinate(-3, 1));
        Creature coelho4     = new Creature("Coelho04", new LifeStatus(4, 5, 6, 10),CreatureCategory.PREY, new Coordinate(-3, 1));
        Creature cervo      = new Creature("Cervo", new LifeStatus(8,10, 6, 8), CreatureCategory.PREY,  new Coordinate(1, -4));

        LifeManager engineGrifoAlpha = new LifeManager(grifoAlpha);
        LifeManager engineGrifoBeta  = new LifeManager(grifoBeta);
        LifeManager engineLobo       = new LifeManager(lobo);
        LifeManager engineCoelho    = new LifeManager(coelho);
        LifeManager engineCoelho1      = new LifeManager(coelho1);
        LifeManager engineCoelho2      = new LifeManager(coelho2);
        LifeManager engineCoelho3      = new LifeManager(coelho3);
        LifeManager engineCoelho4      = new LifeManager(coelho4);
        LifeManager engineCervo      = new LifeManager(cervo);


        lifeManagers.add(engineGrifoAlpha);
        lifeManagers.add(engineGrifoBeta);
        lifeManagers.add(engineLobo);
        lifeManagers.add(engineCoelho);
        lifeManagers.add(engineCoelho1);
        lifeManagers.add(engineCoelho2);
        lifeManagers.add(engineCoelho3);
        lifeManagers.add(engineCoelho4);
        lifeManagers.add(engineCervo);

        Resource lago       = new Water("Lago", new Coordinate(4, 4));
        Resource riacho     = new Water("Riacho", new Coordinate(-2, 3));
        Resource lagoa      = new Water("Lagoa", new Coordinate(0, -3));
        resources.add(lago);
        resources.add(riacho);
        resources.add(lagoa);

        WorldEngine world = new WorldEngine(lifeManagers, resources);
        TimeController timeController = new TimeController(world);
        timeController.run();



    }
}
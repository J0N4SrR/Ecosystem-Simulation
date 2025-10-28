package rosa.ribeiro.jonas;

import rosa.ribeiro.jonas.resouces.Resource;
import rosa.ribeiro.jonas.resouces.ResourceType;
import rosa.ribeiro.jonas.resouces.Water;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!\n\n");

        final List<CreatureEngine> creatureEngines = new ArrayList<>();
        final List<Resource> resources = new ArrayList<>();

        // Testando
        Creature grifoAlpha = new Creature("Grifo Alpha", 12, 0, 10,15, new Coordinate(0, 0));
        Creature grifoBeta  = new Creature("Grifo Beta", 10,0, 15, 10, new Coordinate(2, 1));
        Creature lobo       = new Creature("Lobo", 6, 0, 10, 6, new Coordinate(5, -2));
        Creature raposa     = new Creature("Raposa", 8, 0, 6, 10, new Coordinate(-3, 1));
        Creature cervo      = new Creature("Cervo", 9,0, 6, 8,  new Coordinate(1, -4));

        CreatureEngine engineGrifoAlpha = new CreatureEngine(grifoAlpha);
        CreatureEngine engineGrifoBeta  = new CreatureEngine(grifoBeta);
        CreatureEngine engineLobo       = new CreatureEngine(lobo);
        CreatureEngine engineRaposa     = new CreatureEngine(raposa);
        CreatureEngine engineCervo      = new CreatureEngine(cervo);


        creatureEngines.add(engineGrifoAlpha);
        creatureEngines.add(engineGrifoBeta);
        creatureEngines.add(engineLobo);
        creatureEngines.add(engineRaposa);
        creatureEngines.add(engineCervo);

        Resource lago       = new Water(new Coordinate(4, 4));
        Resource riacho     = new Water(new Coordinate(-2, 3));
        Resource lagoa      = new Water(new Coordinate(0, -3));
        resources.add(lago);
        resources.add(riacho);
        resources.add(lagoa);

        WorldEngine world = new WorldEngine(creatureEngines, resources);
        TimeController timeController = new TimeController(world);
        List<CreatureEngine> before = creatureEngines;
        timeController.run();



    }
}
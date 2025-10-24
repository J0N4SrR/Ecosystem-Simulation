package rosa.ribeiro.jonas;

import rosa.ribeiro.jonas.resouces.Resource;

import java.util.List;

//implementando o padrão de projetos Command
public interface Action {
    public Coordinate getCoordinate();
    public int getActionPriority();
    public ActionType getActionType();
    public void execute();

}

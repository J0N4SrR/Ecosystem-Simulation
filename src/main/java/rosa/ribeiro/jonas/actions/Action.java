package rosa.ribeiro.jonas.actions;

import rosa.ribeiro.jonas.Coordinate;

//implementando o padrão de projetos Command
public interface Action {
    public Coordinate getCoordinate();
    public int getActionPriority();
    public ActionType getActionType();
    public void execute();

}

package View;

import java.util.ArrayList;

public class View {

    InitialFrame inf;


    public View() {
        inf = new InitialFrame();
    }

    public void layout(int col, int row){

        inf.getMjp().getCp().layout(row,col);
    }

    public void CenterInitialSetup(int linesBeingDisplayed, int n) {
        inf.getMjp().getCp().headerButtons(n);
        inf.getMjp().getCp().playerButtons(linesBeingDisplayed,n);

        getInf().validate();
        getInf().repaint();

    }
    public void CenterUpdate(ArrayList<ArrayList<String>> lines, ArrayList<String> FBs){
        inf.getMjp().getCp().writeDataOnButtons(FBs);
        inf.getMjp().getCp().playerDataOnButtons(lines);


    }


    public InitialFrame getInf() {
        return inf;
    }

    public void setInf(InitialFrame inf) {
        this.inf = inf;
    }
}

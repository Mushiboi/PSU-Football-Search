package View;


import Model.FootballPlayerData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CenterPanel extends JPanel {

    private final ArrayList<JButton> bts;
    private final ArrayList<JButton> fbts;


    public CenterPanel() {
        bts = new ArrayList<>();
        fbts = new ArrayList<>();

       // setLayout(new GridLayout(0, 7));
    }

public void layout(int col,int row){
    setLayout(new GridLayout(col+1,row));
}

    public void headerButtons(int n) {
        for (int i = 0; i < n; i++) {

            JButton b = new JButton(i + "");

            bts.add(b);
                add(b);
        }
        this.validate();
        this.repaint();
    }

    public void playerButtons(int linesBeingDisplayed,int n) {
        for (int j = 0; j < linesBeingDisplayed; j++) {
            for (int i = 0; i < n; i++) {
                JButton b = new JButton(j + "" + i);
                fbts.add(b);
                this.add(b);
            }
            this.validate();
            this.repaint();
        }
    }


    void writeDataOnButtons(ArrayList<String> fb) {
        for (int i = 0; i < fb.size(); i++) {
            bts.get(i).setText(fb.get(i));
            bts.get(i).setForeground(Color.black);
            bts.get(i).setBackground(Color.LIGHT_GRAY);
            bts.get(i).setOpaque(true);
        }
        this.validate();
        this.repaint();
    }

    void playerDataOnButtons(ArrayList<ArrayList<String>> lines) {
       // System.out.println(lines);
        ArrayList<String> footBData = new ArrayList<>();

        for (List<String> data : lines) {
            footBData.addAll(data);
        }
        for (int i = 0; i < footBData.size() && i <fbts.size(); i++) {
            fbts.get(i).setText(footBData.get(i));
        }
//        System.out.println(footBData.size());
//        System.out.println(fbts.size());
        this.validate();
        this.repaint();
    }
    public void lineToHighlight(int n)
    {
        for(int x = 0; x < 6; x++)
        {
            fbts.get(x).setBackground(Color.RED);
        }
    }

    public ArrayList<JButton> getBts () {
        return bts;
    }
    public ArrayList<JButton> getFbts () {
        return fbts;
    }
    }



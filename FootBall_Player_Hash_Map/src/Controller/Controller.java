package Controller;

import Model.Model;
import View.View;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Controller {

    Model model;
    View view;


    public Controller(View v, Model m) {
        model = m;
        view = v;

        view.layout(model.getFpData().getHeaders().size(), model.getFpData().getLinesBeingDisplayed());

        view.CenterInitialSetup(model.getFpData().getLinesBeingDisplayed(), model.getFpData().getHeaders().size());

        view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());

        addListeners();


    }

    private void addListeners() {
        view.getInf().getMjp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int unitsToScroll = e.getUnitsToScroll();
                int wheelRotation = e.getWheelRotation();

                model.getFpData().setFirstLineToDisplay(wheelRotation + model.getFpData().getFirstLineToDisplay());
                view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());

                // System.out.println(unitsToScroll + "<-->" + wheelRotation + model.getFpData().getFirstLineToDisplay());
            }
        });
        for (int i = 0; i <= 6; i++) {
            view.getInf().getMjp().getCp().getBts().get(i).addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton y = (JButton) e.getSource();
                    for (int x = 0; x <= 6; x++) {

                        if (y.getText().equals("number")) {
                            model.getFpData().sort(0);

                            view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
                            y.setBackground(Color.DARK_GRAY);
                            y.setForeground(Color.white);
                            view.getInf().getMjp().getCp().getBts().get(x).setBackground(Color.LIGHT_GRAY);
                            view.getInf().getMjp().getCp().getBts().get(x).setForeground(Color.black);
                        }
                        if (y.getText().equals("position")) {
                            model.getFpData().sort(1);
                            view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
                            y.setBackground(Color.DARK_GRAY);
                            y.setForeground(Color.white);
                            view.getInf().getMjp().getCp().getBts().get(x).setBackground(Color.LIGHT_GRAY);
                            view.getInf().getMjp().getCp().getBts().get(x).setForeground(Color.black);

                        }
                        if (y.getText().equals("name")) {
                            model.getFpData().sort(2);
                            view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
                            y.setBackground(Color.DARK_GRAY);
                            y.setForeground(Color.white);
                            view.getInf().getMjp().getCp().getBts().get(x).setBackground(Color.LIGHT_GRAY);
                            view.getInf().getMjp().getCp().getBts().get(x).setForeground(Color.black);
                        }
                        if (y.getText().equals("height")) {
                            model.getFpData().sort(3);
                            view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
                            y.setBackground(Color.DARK_GRAY);
                            y.setForeground(Color.white);
                            view.getInf().getMjp().getCp().getBts().get(x).setBackground(Color.LIGHT_GRAY);
                            view.getInf().getMjp().getCp().getBts().get(x).setForeground(Color.black);
                        }
                        if (y.getText().equals("weight")) {
                            model.getFpData().sort(4);
                            view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
                            y.setBackground(Color.DARK_GRAY);
                            y.setForeground(Color.white);
                            view.getInf().getMjp().getCp().getBts().get(x).setBackground(Color.LIGHT_GRAY);
                            view.getInf().getMjp().getCp().getBts().get(x).setForeground(Color.black);
                        }
                        if (y.getText().equals("hometown")) {
                            model.getFpData().sort(5);
                            view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
                            y.setBackground(Color.DARK_GRAY);
                            y.setForeground(Color.white);
                            view.getInf().getMjp().getCp().getBts().get(x).setBackground(Color.LIGHT_GRAY);
                            view.getInf().getMjp().getCp().getBts().get(x).setForeground(Color.black);
                        }
                        if (y.getText().equals("highschool")) {
                            model.getFpData().sort(6);
                            view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
                            y.setBackground(Color.DARK_GRAY);
                            y.setForeground(Color.white);
                            view.getInf().getMjp().getCp().getBts().get(x).setBackground(Color.LIGHT_GRAY);
                            view.getInf().getMjp().getCp().getBts().get(x).setForeground(Color.black);
                        }
                    }
                }
            });
        }
        view.getInf().getMjp().getNp().getSearchText().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String s = view.getInf().getMjp().getNp().getSearchText().getText();
            model.getFpData().search(s);
               // System.out.println(s+ "was typed");
                if(!model.getFpData().search(s))
                {
                    view.getInf().getMjp().getNp().getSearchText().setOpaque(true);
                    view.getInf().getMjp().getNp().getSearchText().setBackground(Color.RED);
                }
                else{
                    view.getInf().getMjp().getNp().getSearchText().setBackground(Color.blue);
                    int highlight = model.getFpData().getLineToHighlight();
                    view.getInf().getMjp().getCp().lineToHighlight(highlight);

                }

            }
        });
        }

}




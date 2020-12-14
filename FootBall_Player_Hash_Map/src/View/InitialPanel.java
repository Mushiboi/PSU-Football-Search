package View;

import javax.swing.*;
import java.awt.*;

public class InitialPanel extends JPanel  {

    private CenterPanel cp;
    private NorthPanel np;

    public InitialPanel() {
            super();
            setBackground(Color.white);

            cp = new CenterPanel();
            add(cp);
            BorderLayout border = new BorderLayout();
            setLayout(border);
            add(cp,BorderLayout.CENTER);
            np = new NorthPanel();
            add(np, BorderLayout.NORTH);
        }

    public CenterPanel getCp() {
        return cp;
    }

    public void setCp(CenterPanel cp) {
        this.cp = cp;
    }

    public NorthPanel getNp() {
        return np;
    }

    public void setNp(NorthPanel np) {
        this.np = np;
    }
}



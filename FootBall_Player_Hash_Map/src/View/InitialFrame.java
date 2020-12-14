package View;

import javax.swing.*;

public class InitialFrame extends JFrame {

    InitialPanel mjp;

    public InitialFrame(){
        super();
        mjp = new InitialPanel();
        this.add(mjp);
        setSize(1280,960);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public InitialPanel getMjp() {
        return mjp;
    }

    public void setMjp(InitialPanel mjp) {
        this.mjp = mjp;
    }
}

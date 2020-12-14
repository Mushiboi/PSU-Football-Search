package View;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NorthPanel extends JPanel{
    private JTextField  searchText;



    public NorthPanel()
    {
        super();

         searchText = new JTextField(20);
        add(searchText);

    }

    public JTextField getSearchText() {
        return searchText;
    }

    public void setSearchText(JTextField searchText) {
        this.searchText = searchText;
    }

}

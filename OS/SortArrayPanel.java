package OS;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class SortArrayPanel extends JPanel {
    private Dimension area; //indicates area taken up by graphics
    private SortArray sortarray;

    public SortArrayPanel(int size, int width, int height) {
        super(new BorderLayout());

        area = new Dimension(0,0);

        //Set up the drawing area.
        sortarray = new SortArray(size);

        //Put the drawing area in a scroll pane.
        JScrollPane scroller = new JScrollPane(sortarray);
        scroller.setPreferredSize(new Dimension(width,height));
        add(scroller, BorderLayout.CENTER);

        area.width = (25 * (size+1));
        area.height = (10 * (size+4));
        sortarray.setPreferredSize(area);
        sortarray.revalidate();
        sortarray.repaint();
    }

    public SortArray getArray() {
        return sortarray;
    }
}

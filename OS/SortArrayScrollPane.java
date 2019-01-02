package OS;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class SortArrayScrollPane extends JPanel {
    private Dimension area; //indicates area taken up by graphics
    private SortArray sortarray;
    private JScrollPane scroller;

    public SortArrayScrollPane(int size, int width, int height) {
        super(new BorderLayout());

        area = new Dimension(0,0);

        //Set up the drawing area.
        sortarray = new SortArray(size);

        //Put the drawing area in a scroll pane.
        scroller = new JScrollPane(sortarray);
        scroller.setPreferredSize(new Dimension(width,height));
        add(scroller, BorderLayout.CENTER);

        resize(size);
    }

    public SortArray getArray() {
        return sortarray;
    }

    public void setArray(SortArray sortarray) {
        this.sortarray = sortarray;
        this.scroller.setViewportView(this.sortarray);
        resize(sortarray.length());
    }

    private void resize(int size) {
        if ((size <= 0) || (this.sortarray == null)) {
            return;
        }
        area.width = (25 * (size+1));
        area.height = (10 * (size+4));
        this.sortarray.setPreferredSize(area);
        this.sortarray.revalidate();
        this.sortarray.repaint();
    }
}

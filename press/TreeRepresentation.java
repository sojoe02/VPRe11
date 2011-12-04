/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package press;

/**
 *
 * @author sojoe
 */
 
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/* ScrollDemo2.java requires no other files. */
public class TreeRepresentation extends JPanel
        implements MouseListener {

    private Dimension area; //indicates area taken up by graphics    
    private JPanel drawingPane;
    private final Color colors[] = {
        Color.red, Color.blue, Color.green, Color.orange,
        Color.cyan, Color.magenta, Color.darkGray, Color.yellow};
    private final int color_n = colors.length;

    public TreeRepresentation() {
        super(new BorderLayout());
        area = new Dimension(0, 0);


        //Set up the instructions.
        JLabel instructionsLeft = new JLabel(
                "This is the tree representation");
        JPanel instructionPanel = new JPanel(new GridLayout(0, 1));
        instructionPanel.setFocusable(true);
        instructionPanel.add(instructionsLeft);

        //Set up the drawing area.
        drawingPane = new DrawingPane();
        drawingPane.setBackground(Color.white);
        drawingPane.addMouseListener(this);

        //Put the drawing area in a scroll pane.
        JScrollPane scroller = new JScrollPane(drawingPane);
        scroller.setPreferredSize(new Dimension(200, 200));

        //Lay out this demo.
        add(instructionPanel, BorderLayout.PAGE_START);
        add(scroller, BorderLayout.CENTER);
    }

    /** The component inside the scroll pane. */
    public class DrawingPane extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

        }
    }

    //Handle mouse events.
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ScrollDemo2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new TreeRepresentation();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

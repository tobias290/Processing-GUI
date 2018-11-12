package processing_gui;

import processing.core.PApplet;
import processing_gui.controls.Button;
import processing_gui.controls.Node;
import processing_gui.event.ActionEvent;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Controls all the nodes and displays them all.
 */
public class Pane {
    /**
     * Array of all the nodes.
     */
    private ArrayList<Node> nodes = new ArrayList<>();

    /**
     * Represents the parent class (space_invaders.SpaceInvaders) so we can access all the methods and variables declared is the PApplet class.
     */
    private PApplet parent;

    /**
     * Pane constructor.
     *
     * @param parent Represents the parent class (space_invaders.SpaceInvaders) so we can access all the methods and variables declared is the PApplet class.
     * @param nodes Array of all the nodes.
     */
    public Pane(PApplet parent, Node ...nodes) {
        this.parent = parent;
        this.addNodes(nodes);
    }

    /**
     * Pane constructor.
     *
     * @param parent Represents the parent class (space_invaders.SpaceInvaders) so we can access all the methods and variables declared is the PApplet class.
     */
    public Pane(PApplet parent) {
       this(parent, new Node[]{});
    }

    /**
     * Adds a node to the list of nodes which will be displayed.
     *
     * @param node Node instance to add.
     */
    public void addNode(Node node) {
        node.setParent(parent);
        nodes.add(node);
    }

    /**
     * Adds multiple nodes to the list of nodes which will be displayed.
     *
     * @param nodes Node instances to add.
     */
    public void addNodes(Node ... nodes) {
        for (Node node : nodes) {
            node.setParent(parent);
            this.nodes.add(node);
        }
    }

    /**
     * Displays all the nodes.
     */
    public void show() {
        nodes.forEach(Node::display);
    }

    /**
     * Checks if the mouse has pressed within the bounds of a button and call their action listener.
     */
    public void checkMousePressed() {
        nodes.stream()
                .filter(node -> node instanceof Button && node.mousePressWithinBounds())
                .forEach(node -> ((Button) node).getOnActionListener().onClick(new ActionEvent(node)));
    }
}

package processing_gui.controls;

import processing.core.PApplet;

/**
 * Base class for any GUI node/control
 */
public abstract class Node {
    /**
     * Represents the parent class (space_invaders.SpaceInvaders) so we can access all the methods and variables declared is the PApplet class.
     */
    PApplet parent;

    /**
     * Node's X coordinates.
     */
    int x;

    /**
     * Node's Y coordinates.
     */
    int y;

    /**
     * Height of the node in pixels.
     */
    int height;

    /**
     * Width of the node in pixels.
     */
    int width;

    /**
     * Node constructor.
     *
     * @param x Node's X coordinates.
     * @param y Node's Y coordinates.
     * @param width Height of the node in pixels.
     * @param height Width of the node in pixels.
     */
    Node(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Set's the PApplet (parent) class.
     *
     * @param parent PApplet instance.
     */
    public void setParent(PApplet parent) {
        this.parent = parent;
    }

    /**
     * @return Returns the X coordinated
     */
    public int getX() {
        return x;
    }

    /**
     * Set the node's X coordinates.
     *
     * @param x X coordinates
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return Returns the Y coordinated
     */
    public int getY() {
        return y;
    }

    /**
     * Set the node's Y coordinates.
     *
     * @param y Y coordinates
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return Returns the width of the node.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the node's width.
     *
     * @param width Width of the node.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return Returns the height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the node's height.
     *
     * @param height Width of the node.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return Returns true if the mouse click is within the bounds of the node.
     */
    public boolean mousePressWithinBounds() {
        return  parent.mouseX > x - (width / 2)  &&
                parent.mouseX < x + (width / 2)  &&
                parent.mouseY > y - (height / 2) &&
                parent.mouseY < y + (height / 2);
    }

    /**
     * Displays the actual node/control.
     */
    abstract public void display();
}

package processing_gui.controls;

import processing.core.PApplet;

/**
 * Image node which displays an image.
 */
public class Image extends Node {
    /**
     * Path of the image's location.
     */
    private String imagePath;

    /**
     * Sets image mode to CENTER meaning the origin of the coordinates in in the centre of the rectangle.
     */
    private int imageMode = 3;

    /**
     * Image constructor.
     *
     * @param imagePath Path of the image's location.
     * @param x Image's X coordinates.
     * @param y Image's Y coordinates.
     * @param width Image's width.
     * @param height Image's height.
     */
    public Image(String imagePath, int x, int y, int width, int height) {
        super(x, y, width, height);

        this.imagePath = imagePath;
    }

    /**
     * Image constructor.
     *
     * @param parent Represents the parent class (space_invaders.SpaceInvaders) so we can access all the methods and variables declared is the PApplet class.
     * @param imagePath Path of the image's location.
     * @param x Image's X coordinates.
     * @param y Image's Y coordinates.
     * @param width Image's width.
     * @param height Image's height.
     */
    public Image(PApplet parent, String imagePath, int x, int y, int width, int height) {
        this(imagePath, x, y, width, height);

        this.parent = parent;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void display() {
        parent.imageMode(imageMode);
        parent.image(parent.loadImage(imagePath), x, y, width, height);
    }

    /**
     * Sets the image's path.
     *
     * @param imagePath Location of the image.
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Set's the image mode.
     *
     * @param imageMode - Image mode.
     */
    public void setImageMode(int imageMode) {
        this.imageMode = imageMode;
    }
}

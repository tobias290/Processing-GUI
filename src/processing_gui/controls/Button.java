package processing_gui.controls;

import processing.core.PApplet;
import processing_gui.event.ActionListener;

/**
 * Button node which displays text and can call an action when clicked.
 */
public class Button extends Node {
    /**
     * Button's text.
     */
    private String text;

    /**
     * Sets rect mode to CENTER meaning the origin of the coordinates in in the centre of the rectangle.
     */
    private int rectMode = 3;

    /**
     * Represent what type of animation should happen then the mouse is over the button
     */
    private HoverAnimation hoverAnimation = HoverAnimation.NONE;

    /**
     * Background colour of the button in RGB form.
     */
    private int[] backgroundColour = new int[]{255, 255, 255};

    /**
     * Colour of the button's text in RGB form.
     */
    private int[] textColour = new int[]{0, 0, 0};

    /**
     * Background colour of the button when hovered over in RGB form.
     */
    private int[] onHoverColour = new int[]{255, 255, 255};

    /**
     * Font size of the button's text.
     */
    private int fontSize = 14;

    /**
     * Button's action listener which is called when the button is clicked.
     */
    private ActionListener actionListener;

    /**
     * Button constructor.
     *
     * @param text Text of the button.
     * @param x Button's X coordinates.
     * @param y Button's Y coordinates.
     * @param width Button's width.
     * @param height Button's height.
     */
    public Button(String text, int x, int y, int width, int height) {
        super(x, y, width, height);

        this.text = text;
    }

    /**
     * Button constructor.
     *
     * @param parent Represents the parent class so we can access all the methods and variables declared is the PApplet class.
     * @param text Text of the button.
     * @param x Button's X coordinates.
     * @param y Button's Y coordinates.
     * @param width Button's width.
     * @param height Button's height.
     */
    public Button(PApplet parent, String text, int x, int y, int width, int height) {
        this(text, x, y, width, height);

        this.parent = parent;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void display() {
        if (isMouseOver())
            displayHover();
         else
            displayNormal();

    }

    /**
     * @return Gets the button's text.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the button's text.
     *
     * @param text Text for the button.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Sets the rectangle mode of the button, which decided where the origin is.
     *
     * @param rectMode - Rectangle mode.
     */
    public void setRectMode(int rectMode) {
        this.rectMode = rectMode;
    }

    /**
     * Sets the background colour of the button.
     *
     * @param r Red value (0-255)
     * @param g Green value (0-255)
     * @param b Blue value (0-255)
     */
    public void setBackgroundColour(int r, int g, int b) {
        backgroundColour[0] = r;
        backgroundColour[1] = b;
        backgroundColour[2] = g;
    }

    /**
     * Sets the colour of the label's text.
     *
     * @param r Red value (0-255)
     * @param g Green value (0-255)
     * @param b Blue value (0-255)
     */
    public void setTextColour(int r, int g, int b) {
        textColour[0] = r;
        textColour[1] = b;
        textColour[2] = g;
    }

    /**
     * Set's the background colour of the button when the hover effect is called. (When the mouse is over the button).
     *
     * @param r Red value (0-255)
     * @param g Green value (0-255)
     * @param b Blue value (0-255)
     */
    public void setOnHoverColour(int r, int g, int b) {
        onHoverColour[0] = r;
        onHoverColour[1] = b;
        onHoverColour[2] = g;
    }

    /**
     * Set's the label's font size.
     *
     * @param fontSize Font size of the label.
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * Set' the hover animation of the button.
     *
     * @param hoverAnimation Hover animation from the button. (Used value from 'HoverAnimation' enum).
     */
    public void setHoverAnimation(HoverAnimation hoverAnimation) {
        this.hoverAnimation = hoverAnimation;
    }

    /**
     * @return Gets the buttons action listener.
     */
    public ActionListener getOnActionListener() {
        return actionListener;
    }

    /**
     * Set's the buttons action listener which is called when the button is clicked.
     *
     * @param actionListener Button's action listener.
     */
    public void setOnActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    /**
     * @return Returns true if the mouse if over the button.
     */
    private boolean isMouseOver() {
        return parent.mouseX > x - (width / 2) &&
               parent.mouseX < x + (width / 2) &&
               parent.mouseY > y - (height / 2) &&
               parent.mouseY < y + (height / 2);
    }

    /**
     * Display the button when it is in the normal mode.
     */
    private void displayNormal() {
        parent.fill(backgroundColour[0], backgroundColour[1], backgroundColour[2]);
        parent.rectMode(rectMode);
        parent.noStroke();
        parent.rect(x, y, width, height);

        parent.fill(textColour[0], textColour[1], textColour[2]);
        parent.textSize(fontSize);
        parent.text(text, x - (parent.textWidth(text) / 2), y + (parent.textAscent() / 2) - (parent.textDescent() / 2));
    }

    /**
     * Display the button when it is in the hover mode (Mouse is over the button).
     */
    private void displayHover() {
        int _width = width;
        int _height = height;
        int _fontSize = fontSize;
        int[] _backgroundColour = backgroundColour.clone();

        // Depending on the hover menu will decide how to display the button
        switch (hoverAnimation) {
            case NONE:
                break;
            case ENLARGE:
                _width = width + 10;
                _height = height + 10;
                _fontSize = fontSize + 1;
                break;
            case SHRINK:
                _width = width - 10;
                _height = height - 10;
                _fontSize = fontSize - 1;
                break;
            case HOVER_COLOUR:
               _backgroundColour[0] = onHoverColour[0];
               _backgroundColour[1] = onHoverColour[1];
               _backgroundColour[2] = onHoverColour[2];
                break;
        }

        parent.fill(_backgroundColour[0], _backgroundColour[1], _backgroundColour[2]);
        parent.rectMode(rectMode);
        parent.noStroke();
        parent.rect(x, y, _width, _height);

        parent.fill(textColour[0], textColour[1], textColour[2]);
        parent.textSize(_fontSize);
        parent.text(text, x - (parent.textWidth(text) / 2), y + (parent.textAscent() / 2) - (parent.textDescent() / 2));
    }

    /**
     * Different hover animations the button can have.
     */
    public enum HoverAnimation {
        NONE,
        ENLARGE,
        SHRINK,
        HOVER_COLOUR,
    }
}

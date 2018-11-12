package processing_gui.controls;

import processing.core.PApplet;

/**
 * Label node which displays text.
 */
public class Label extends Node {
    /**
     * Text of the label.
     */
    private String text;

    /**
     * Label's font size.
     */
    private float fontSize = 14;

    /**
     * Colour of the text in RGB form.
     */
    private int[] textColour = new int[]{0, 0, 0};

    /**
     * Label constructor.
     *
     * @param text Text of the label.
     * @param x Label's X coordinates.
     * @param y Label's Y coordinates.
     */
    public Label(String text, int x, int y) {
        super(x, y, 0, 0);

        this.text = text;
    }

    /**
     * Label constructor.
     *
     * @param text Text of the label.
     * @param x Label's X coordinates.
     * @param y Label's Y coordinates.
     * @param fontSize Font size of the label's text.
     */
    public Label(String text, int x, int y, float fontSize) {
        this(text, x, y);

        this.fontSize = fontSize;
    }

    /**
     * Label constructor.
     *
     * @param text Text of the label.
     * @param x Label's X coordinates.
     * @param y Label's Y coordinates.
     * @param textColour Colour of the text in RGB form.
     */
    public Label(String text, int x, int y, int[] textColour) {
        this(text, x, y);

        this.textColour = textColour;
    }

    /**
     * Label constructor.
     *
     * @param text Text of the label.
     * @param x Label's X coordinates.
     * @param y Label's Y coordinates.
     * @param fontSize Font size of the label's text.
     * @param textColour Colour of the text in RGB form.
     */
    public Label(String text, int x, int y, float fontSize, int[] textColour) {
        this(text, x, y, fontSize);

        this.textColour = textColour;
    }

    /**
     * Label constructor.
     *
     * @param parent Represents the parent class (space_invaders.SpaceInvaders) so we can access all the methods and variables declared is the PApplet class.
     * @param text Text of the label.
     * @param x Label's X coordinates.
     * @param y Label's Y coordinates.
     * @param fontSize Font size of the label's text.
     * @param textColour Colour of the text in RGB form.
     */
    public Label(PApplet parent, String text, int x, int y, int[] textColour, float fontSize) {
        this(text, x, y, fontSize, textColour);

        this.parent = parent;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void display() {
        parent.fill(textColour[0], textColour[1], textColour[2]);
        parent.textSize(fontSize);
        parent.text(text, x, y);
    }

    /**
     * @return Returns the label's text.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the label's text.
     *
     * @param text Text to give the label.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Set's the label's font size.
     *
     * @param fontSize Font size of the label.
     */
    public void setFontSize(float fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * Sets the colour of the labels. text.
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
     * @inheritDoc
     */
    @Override
    public int getWidth() {
        return (int)parent.textWidth(text);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int getHeight() {
        return (int)fontSize;
    }
}

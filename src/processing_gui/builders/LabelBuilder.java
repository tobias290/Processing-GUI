package processing_gui.builders;

import processing.core.PApplet;
import processing_gui.controls.Label;
import processing_gui.controls.Node;

public class LabelBuilder extends NodeBuilder<Label, LabelBuilder> {
    private String text;

    private float fontSize = 14;
    private int[] textColour = new int[]{0, 0, 0};

    public LabelBuilder(PApplet parent) {
        super(parent);

        this.x(0);
        this.y(0);
    }

    public LabelBuilder text(String text) {
        this.text = text;
        return this;
    }

    public LabelBuilder fontSize(float fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public LabelBuilder textColour(int r, int g, int b) {
        textColour[0] = r;
        textColour[1] = b;
        textColour[2] = g;
        return this;
    }

    @Override
    public Label build() {
        return new Label(parent, text, x, y, textColour, fontSize);
    }

    @Override
    protected LabelBuilder getThis() {
        return this;
    }
}

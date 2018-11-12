package processing_gui.builders;

import processing.core.PApplet;
import processing_gui.controls.Button;
import processing_gui.controls.Node;
import processing_gui.event.ActionListener;

public class ButtonBuilder extends NodeBuilder<Button, ButtonBuilder> {
    private String text;

    private int rectMode = 3;

    private Button.HoverAnimation hoverAnimation = Button.HoverAnimation.NONE;

    private int[] backgroundColour = new int[]{255, 255, 255};
    private int[] textColour = new int[]{0, 0, 0};
    private int[] onHoverColour = new int[]{255, 255, 255};

    private int fontSize = 14;

    private ActionListener actionListener;

    public ButtonBuilder(PApplet parent) {
        super(parent);
    }

    public ButtonBuilder text(String text) {
        this.text = text;
        return this;
    }

    public ButtonBuilder rectMode(int rectMode) {
        this.rectMode = rectMode;
        return this;
    }

    public ButtonBuilder backgroundColour(int r, int g, int b) {
        backgroundColour[0] = r;
        backgroundColour[1] = b;
        backgroundColour[2] = g;
        return this;
    }

    public ButtonBuilder textColour(int r, int g, int b) {
        textColour[0] = r;
        textColour[1] = b;
        textColour[2] = g;
        return this;
    }

    public ButtonBuilder onHoverColour(int r, int g, int b) {
        onHoverColour[0] = r;
        onHoverColour[1] = b;
        onHoverColour[2] = g;
        return this;
    }

    public ButtonBuilder fontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public ButtonBuilder hoverAnimation(Button.HoverAnimation hoverAnimation) {
        this.hoverAnimation = hoverAnimation;
        return this;
    }


    public ButtonBuilder onActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
        return this;
    }

    @Override
    public Button build() {
        Button btn = new Button(parent, text, x, y, width, height);
        btn.setRectMode(rectMode);
        btn.setBackgroundColour(backgroundColour[0], backgroundColour[1], backgroundColour[2]);
        btn.setTextColour(textColour[0], textColour[1], textColour[2]);
        btn.setFontSize(fontSize);
        btn.setHoverAnimation(hoverAnimation);
        btn.setOnHoverColour(onHoverColour[0], onHoverColour[1], onHoverColour[2]);
        btn.setOnActionListener(actionListener);
        return btn;
    }

    @Override
    protected ButtonBuilder getThis() {
        return this;
    }
}

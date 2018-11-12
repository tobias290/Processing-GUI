package test;

import processing.core.PApplet;
import processing_gui.builders.ButtonBuilder;
import processing_gui.controls.Button;
import processing_gui.controls.Image;
import processing_gui.controls.Label;
import processing_gui.Pane;
import processing_gui.event.ActionEvent;
import processing_gui.event.ActionListener;

public class Test extends PApplet implements ActionListener {
    private Pane pane;

    private Button btn, btn_2;

    public static void main(String[] args) {
        PApplet.main("test.Test");
    }

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        pane = new Pane(this);

        Label label = new Label("Test", (int)(width / 2 - textWidth("Test")), 20);
        label.setFontSize(30);

        btn = new Button("Button", width / 2, height / 2, 200,80);
        btn.setFontSize(30);
        btn.setHoverAnimation(Button.HoverAnimation.ENLARGE);
        btn.setOnActionListener(this);

        btn_2 = new Button("Button 2", width/2, height/2 + 100, 200,80);
        btn_2.setFontSize(30);
        btn_2.setOnHoverColour(200, 200, 200);
        btn_2.setHoverAnimation(Button.HoverAnimation.HOVER_COLOUR);
        btn_2.setOnActionListener(this);

        Image img = new Image(System.getProperty("user.dir") + "\\src\\test\\code.png", width/2, height/2 + 200, 100, 100);

        pane.addNodes(label, btn, btn_2, img);
    }

    public void draw() {
        background(0);
        pane.show();
    }

    public void mousePressed() {
        pane.checkMousePressed();
    }

    @Override
    public void onClick(ActionEvent event) {
        if (event.getSource() == btn) {
            System.out.println("Button clicked with text: " + ((Button)event.getSource()).getText());
        } else if (event.getSource() == btn_2) {
            System.out.println("Button clicked with text: " + ((Button)event.getSource()).getText());
        }
    }
}

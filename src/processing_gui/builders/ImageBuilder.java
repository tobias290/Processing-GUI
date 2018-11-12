package processing_gui.builders;

import processing.core.PApplet;
import processing.core.PImage;
import processing_gui.controls.Image;

public class ImageBuilder extends NodeBuilder<Image, ImageBuilder> {
    private String imagePath;

    private int imageMode = 3;

    public ImageBuilder(PApplet parent) {
        super(parent);
    }

    public ImageBuilder imagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public ImageBuilder imageMode(int imageMode) {
        this.imageMode = imageMode;
        return this;
    }

    @Override
    public Image build() {
        Image img = new Image(parent, imagePath, x, y, width, height);
        img.setImageMode(imageMode);
        return img;
    }

    @Override
    protected ImageBuilder getThis() {
        return this;
    }
}

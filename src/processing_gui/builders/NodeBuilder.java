package processing_gui.builders;

import processing.core.PApplet;
import processing_gui.controls.Node;
import sun.security.action.PutAllAction;

public abstract class NodeBuilder<Child, ChildBuilder extends NodeBuilder<Child, ChildBuilder>> {
    PApplet parent;

    int x;
    int y;
    int width;
    int height;

    NodeBuilder(PApplet parent) {
        this.parent = parent;
    }

    public ChildBuilder x(int x) {
        this.x = x;
        return getThis();
    }

    public ChildBuilder location(int x, int y) {
        this.x = x;
        this.y = y;
        return getThis();
    }

    public ChildBuilder dimensions(int width, int height) {
        this.width = width;
        this.height = height;
        return getThis();
    }

    public ChildBuilder y(int y) {
        this.y = y;
        return getThis();
    }

    public ChildBuilder width(int width) {
        this.width = width;
        return getThis();
    }

    public ChildBuilder height(int height) {
        this.height = height;
        return getThis();
    }

    abstract protected ChildBuilder getThis();

    abstract public Child build();
}

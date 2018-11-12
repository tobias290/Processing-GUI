package processing_gui.event;

import processing_gui.controls.Node;

/**
 * Created when an event was called and is used to store the source of the action event.
 */
public class ActionEvent {
    /**
     * Node which the action event was called from.
     */
    private Node source;

    /**
     * ActionEvent constructor.
     *
     * @param source Node which the action event was called from.
     */
    public ActionEvent(Node source) {
        this.source = source;
    }

    /**
     * @return Returns the source of the action event.
     */
    public Node getSource() {
        return source;
    }
}

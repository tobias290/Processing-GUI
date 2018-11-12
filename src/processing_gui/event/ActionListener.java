package processing_gui.event;

/**
 * Action listener interface which needs to be implemented when adding an action listener for a button.
 */
public interface ActionListener {
    /**
     * Called when the node is clicked.
     *
     * @param event Event which holds information such as the source of the event.
     */
    void onClick(ActionEvent event);
}

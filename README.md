# Processing GUI Framework

> __Note__: For more details documentation check out the java doc located [here](documentation). 

Simple GUI framework built with Java and the [Processing][0] library. 
This simple framework allows the user to use simple widgets such as Images, Labels and Buttons in their processing application with little hassle.

[0]: https://processing.org/

## Widgets

Each widget has a basic constructor which takes its X and Y position and its width and height.
Each widget also has a builder available to help create a widget with less code.
If you do not know what a builder is check [here](https://dzone.com/articles/design-patterns-the-builder-pattern).

### Button
Simple button widget which can be placed using x, y coordinates. 
The button has 4 hover animations:

* __None__: No animation occurs.
* __Enlarge__: Increases the size of the button
* __Shrink__: Decreases the size of the button
* __Hover Color__: Change the color of the button

Each button can have a on action listener which listens for when the button is clicked.
This can be used either as a lambda function or via a interface.

### Label

Simple label for display text only. No events.

### Image

Simple wrapper to display a image.

## Widget Manager 

### Pane

A simple way to manage multiple widgets under one class. A pane takes multiple widgets which already have dimensions and a position.

#

___For example use check the [test](src/test/Test.java) file.___
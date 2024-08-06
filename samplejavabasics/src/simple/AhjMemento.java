package simple;

import java.util.Stack;

public class AhjMemento {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory();

        textEditor.setText("Apple");
        history.save(textEditor);
        System.out.println("Text: " + textEditor.getText());

        textEditor.setText("Banana");
        history.save(textEditor);
        System.out.println("Text: " + textEditor.getText());

        textEditor.setText("Cactus");
        System.out.println("Text: " + textEditor.getText());

        history.undo(textEditor);
        System.out.println("Undo: " + textEditor.getText());
        System.out.println("Undo: " + textEditor.getText());

        history.undo(textEditor);
        System.out.println("Undo: " + textEditor.getText());
        
        history.save(textEditor);
        System.out.println("Text: " + textEditor.getText());
    }
}
class TextEditorHistory {
    private Stack<Memento> history = new Stack<>();

    public void save(TextEditor textEditor) {
        history.push(textEditor.save());
    }

    public void undo(TextEditor textEditor) {
        if (!history.isEmpty()) {
        	textEditor.restore(history.pop());
        }
    }
}
class TextEditor {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void restore(Memento memento) {
        this.text = memento.getState();
    }
}
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

package generative_patterns.factory_method;

public class FactoryMethod {
    public static void main(String[] args) {
        Person person = Person.create();
        System.out.println(person);



        Dialog dialog = new WindowsDialog();
        dialog.renderWindow();

    }
}

class Person {
    private Person() {}

    public static Person create() {
        return new Person();
    }
}




interface Button {
    void render();
    void onClick();
}

class HtmlButton implements Button {

    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}

class WindowsButton implements Button {

    public void render() {
        System.out.println("rendering..");
        onClick();
    }

    public void onClick() {
        System.out.println("Click! Button says - 'Bye World!'");
    }
}



abstract class Dialog {
    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}


class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}

class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
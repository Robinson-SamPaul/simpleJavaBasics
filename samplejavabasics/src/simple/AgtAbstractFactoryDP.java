package simple;

public class AgtAbstractFactoryDP {
	public static void main(String[] args) {
		GUIFactory factory = new DarkThemeFactory();
		Button button = factory.createButton();
		TextBox textBox = factory.createTextBox();

		button.click();
		textBox.type();

		factory = new LightThemeFactory();
		button = factory.createButton();
		textBox = factory.createTextBox();

		button.click();
		textBox.type();
	}
}
/***********************************************************************************************************************/
interface Button {
	void click();
}
class DarkButton implements Button {
	@Override
	public void click() {
		System.out.println("Dark themed button clicked!");
	}
}
class LightButton implements Button {
	@Override
	public void click() {
		System.out.println("Light themed button clicked!");
	}
}
/***********************************************************************************************************************/
interface TextBox {
	void type();
}
class DarkTextBox implements TextBox {
	@Override
	public void type() {
		System.out.println("Typing in dark themed text box.");
	}
}
class LightTextBox implements TextBox {
	@Override
	public void type() {
		System.out.println("Typing in light themed text box.");
	}
}
/***********************************************************************************************************************/
interface GUIFactory {
	Button createButton();
	TextBox createTextBox();
}
class DarkThemeFactory implements GUIFactory {
	@Override
	public Button createButton() {
		return new DarkButton();
	}
	@Override
	public TextBox createTextBox() {
		return new DarkTextBox();
	}
}
class LightThemeFactory implements GUIFactory {
	@Override
	public Button createButton() {
		return new LightButton();
	}

	@Override
	public TextBox createTextBox() {
		return new LightTextBox();
	}
}
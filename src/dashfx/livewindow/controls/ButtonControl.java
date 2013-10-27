/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dashfx.livewindow.controls;
import dashfx.controls.bases.BooleanControlBase;
import dashfx.lib.controls.Category;
import dashfx.lib.controls.Designable;
import javafx.beans.property.StringProperty;
import javafx.scene.control.ToggleButton;
/**
 *
 * @author Sam
 */
public class ButtonControl extends BooleanControlBase
{
	private final ToggleButton button = new ToggleButton();
	public ButtonControl()
	{
		super();
		button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		button.selectedProperty().bindBidirectional(valueProperty());
		setUi(button);
	}
	// nice wrapper
	@Designable(value = "Text", description = "What to label the button")
	@Category("Basic")
	public StringProperty textProperty()
	{
		return button.textProperty();
	}
	public String getText()
	{
		return textProperty().get();
	}
	public void setText(String text)
	{
		textProperty().set(text);
	}
}

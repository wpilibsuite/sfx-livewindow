/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dashfx.livewindow.controls;

import dashfx.controls.bases.BooleanControlBase;
import javafx.scene.control.ToggleButton;

/**
 *
 * @author Sam
 */
public class ButtonControl extends BooleanControlBase {

	private final ToggleButton button = new ToggleButton();

	public ButtonControl() {
		super();
		button.textProperty().bind(labelProperty());
		button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		button.selectedProperty().bindBidirectional(valueProperty());
		setUi(button);
	}
	
}

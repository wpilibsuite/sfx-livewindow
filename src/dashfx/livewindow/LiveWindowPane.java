/*
 * Copyright (C) 2013 patrick
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package dashfx.livewindow;

import dashfx.controls.DataFlowLayoutPane;
import dashfx.lib.data.DataCoreProvider;
import dashfx.lib.data.SmartValue;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author patrick
 */
public class LiveWindowPane extends DataFlowLayoutPane implements ChangeListener<Object>
{
	private SmartValue enabled;
	private StackPane sp = new StackPane();
	private Label lbl = new Label("LiveWindow Mode is not enabled.\n"
								  + "Please switch to Test Mode on the DriverStation to enable LiveWindow Mode");
	private FocusRunnable focusRequester;

	public LiveWindowPane()
	{
		super();
		ui.setOrientation(Orientation.VERTICAL);
		lbl.setFont(new Font("System", 20));
		lbl.setTextFill(Paint.valueOf("#990000"));
		lbl.setTextAlignment(TextAlignment.CENTER);
		lbl.setAlignment(Pos.CENTER);
		ui.setVisible(false);
		sp.getChildren().addAll(lbl, ui);
		ui.setStyle(""); //Remove border
	}

	@Override
	public void registered(DataCoreProvider provider)
	{
		super.registered(provider);
		if (provider != null)
		{
			if (enabled != null)
				enabled.removeListener(this);
			enabled = provider.getObservable("/LiveWindow/~STATUS~/LW Enabled");
			enabled.addListener(this);
			try
			{
				changed(null, null, enabled.getData().asBoolean());
			}
			catch (Throwable t)
			{
			}
		}
	}

	@Override
	public void changed(ObservableValue<? extends Object> ov, Object t, Object t1)
	{
		boolean visit = (Boolean) t1;
		lbl.setVisible(!visit);
		ui.setVisible(visit);
		if (focusRequester != null)
		{
			focusRequester.preferFocus(visit);
		}
	}

	@Override
	public Node getUi()
	{
		return sp;
	}

	public void onFocusRequest(FocusRunnable r)
	{
		focusRequester = r;
		if (enabled != null)
			r.preferFocus(enabled.getData().asBoolean());
	}
}

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

import dashfx.controls.bases.PaneControlBase;
import dashfx.lib.controls.Category;
import dashfx.lib.controls.Control;
import dashfx.lib.controls.DashFXProperties;
import dashfx.lib.controls.Designable;
import dashfx.lib.controls.ResizeDirections;
import dashfx.lib.data.DataCoreProvider;
import dashfx.lib.data.DataPaneMode;
import dashfx.lib.data.SmartValue;
import dashfx.lib.data.ZPositions;
import java.util.EnumSet;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 *
 * @author patrick
 */
@Designable(value = "LW Box", description = "Live Window VBox Grouping with title", image = "/dashfx/livewindow/res/LW box.png")
@Category("LiveWindow")
@DashFXProperties("Sealed: false, Save Children: true")
public class GroupBox extends PaneControlBase<VBox>
{
	TitledPane tp;
	private EventHandler<Event> slurper;
	private Node nestedChild;
	private Runnable exitRequest;
	private ChangeListener nameChanged = new ChangeListener() {

		@Override
		public void changed(ObservableValue ov, Object t, Object t1)
		{
			String[] bits = t1.toString().split("/");
			tp.setText(bits[bits.length-1]);
		}
	};

	public GroupBox()
	{
		super(new VBox());
		gbInit();
	}

	private void gbInit()
	{
		ui.setStyle("");
		tp = new TitledPane("", ui);
		tp.getStyleClass().add("group-box");
		tp.getStylesheets().add(getClass().getResource("/dashfx/livewindow/GroupBox.css").toString());
		tp.setCollapsible(false);
		setDataMode(DataPaneMode.Nested);
		slurper = new EventHandler<Event>()
		{
			@Override
			public void handle(Event t)
			{
				Node tpar = (Node) t.getTarget();
				while (tpar != null && tpar != nestedChild)
				{
					tpar = tpar.getParent();
				}
				if (tpar == nestedChild)
					return;
				// schluuurp!
				t.consume();
				if (t.getEventType() == MouseEvent.MOUSE_CLICKED)
				{
					if (((MouseEvent) t).getClickCount() > 1)
					{
						//exit
						exitRequest.run();
					}
				}
			}
		};
		nameProperty().addListener(nameChanged);
	}

	@Override
	public Node getUi()
	{
		return tp;
	}

	@Override
	public EnumSet<ResizeDirections> getSupportedOps()
	{
		return EnumSet.of(ResizeDirections.UpDown);
	}

	@Override
	public boolean isJumps()
	{
		return true;
	}

	@Override
	public boolean isAppendable()
	{
		return true;
	}

	@Override
	public void BeginDragging(Node[] overlays, Region[] childs, double x, double y, double sizeX, double sizeY, double posX, double posY)
	{
		//TODO: fixme
	}

	@Override
	public void ContinueDragging(double dx, double dy)
	{
		//TODO: fixme
	}

	@Override
	public void FinishDragging()
	{
		//TODO: fixme
	}

	@Override
	public void addChildAt(Node child, double x, double y)
	{
		getChildren().add(child);
	}

	@Override
	public void editNested(Node overlay, Runnable onExitRequest)
	{
		if (nestedChild == null)
		{
			nestedChild = overlay;
			exitRequest = onExitRequest;
			getUi().addEventFilter(EventType.ROOT, slurper);
		}
	}

	@Override
	public void exitNested()
	{
		if (nestedChild != null)
		{
			getUi().removeEventFilter(EventType.ROOT, slurper);
			nestedChild = null;
			exitRequest = null;
		}
	}

	@Override
	public void zEdit(Node child, ZPositions diff)
	{
		//TODO: fixme
	}
}

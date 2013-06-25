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
import dashfx.lib.controls.Designable;
import dashfx.lib.controls.ResizeDirections;
import dashfx.lib.data.DataPaneMode;
import dashfx.lib.data.ZPositions;
import java.util.EnumSet;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 *
 * @author patrick
 */
@Designable(value = "LW Box", description = "Live Window VBox Grouping with title")
public class GroupBox extends PaneControlBase<VBox>
{
	TitledPane tp;

	public GroupBox()
	{
		super(new VBox());
		gbInit();
	}

	private void gbInit()
	{
		tp = new TitledPane("", ui);
		tp.getStyleClass().add("group-box");
		tp.getStylesheets().add(getClass().getResource("/dashfx/livewindow/GroupBox.css").toString());
		tp.textProperty().bind(nameProperty());
		setDataMode(DataPaneMode.Nested);
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
		//TODO: fixme
	}

	@Override
	public void exitNested()
	{
		//TODO: fixme
	}

	@Override
	public void zEdit(Node child, ZPositions diff)
	{
		//TODO: fixme
	}
}

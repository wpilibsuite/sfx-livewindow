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

import dashfx.lib.controls.Category;
import dashfx.lib.controls.Designable;
import javafx.scene.Node;
import javafx.scene.control.TitledPane;

/**
 *
 * @author patrick
 */
@Category("Grouping")
@Designable
public class GroupBox extends TitledPane
{

	public GroupBox()
	{
		gbInit();
	}

	public GroupBox(String string, Node node)
	{
		super(string, node);
		gbInit();
	}

	private void gbInit()
	{
		setSkinClassName("group-box");
		getStylesheets().add(getClass().getResource("/dashfx/livewindow/GroupBox.css").toString());
	}

}

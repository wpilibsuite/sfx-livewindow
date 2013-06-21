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

import dashfx.lib.controls.DesignablePane;
import javafx.collections.ObservableList;
import javafx.scene.Node;

/**
 *
 * @author patrick
 */
public class LiveWindowViewController
{
	private Node tab;
	private LiveWindowPane lwp = new LiveWindowPane();
	private LayoutManager layoutManager = new LayoutManager(lwp);

	public LiveWindowViewController()
	{
	}

	public String getName()
	{
		return "LiveWindow";
	}

	public DesignablePane getPane()
	{
		return lwp;
	}

	public Node getUi()
	{
		return lwp.getUi();
	}

	public boolean isShouldAdd(String name, ObservableList<String> all)
	{
		//TODO: not this easy, need to avoid certain things like enabled
		return name.startsWith("LiveWindow") && !name.contains("~STATUS~");
	}

	/**
	 * @return the tab
	 */
	public Node getTab()
	{
		return tab;
	}

	/**
	 * @param tab the tab to set
	 */
	public void setTab(Node tab)
	{
		this.tab = tab;
	}

	/**
	 * @return the layoutManager
	 */
	public LayoutManager getLayoutManager()
	{
		return layoutManager;
	}
}

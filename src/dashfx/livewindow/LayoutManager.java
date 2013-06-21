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

import java.util.Map;
import javafx.scene.Node;

/**
 *
 * @author patrick
 */
public class LayoutManager
{
	private final LiveWindowPane root;

	public LayoutManager(LiveWindowPane lwp)
	{
		root = lwp;
	}

	public void layoutControls(Map<Node, Object> maps)
	{
		for (Node node : maps.keySet())
		{
			root.addChildAt(node, -1, -1);
		}
	}
}

/**
 * Copyright [2014] Gaurav Gupta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.netbeans.modeler.specification.model.document;

import java.awt.Image;
import org.netbeans.api.visual.model.ObjectState;
import org.netbeans.modeler.widget.edge.IEdgeWidget;
import org.netbeans.modeler.widget.edge.IPEdgeWidget;
import org.netbeans.modeler.widget.node.IPNodeWidget;
import org.netbeans.modeler.widget.pin.IPinSeperatorWidget;
import org.netbeans.modeler.widget.pin.IPinWidget;

public interface IColorScheme {

    String getId();

    String getName();

    /**
     * Called to install UI to a node widget.
     *
     * @param widget the node widget
     *
     */
    public abstract void installUI(IPNodeWidget widget);

    /**
     * Called to update UI of a node widget. Called from
     * AbstractPNodeWidget.notifyStateChanged method.
     *
     * @param widget the node widget
     * @param previousState the previous state
     * @param state the new state
     *
     */
    public abstract void updateUI(IPNodeWidget widget, ObjectState previousState, ObjectState state);

    /**
     * Returns whether the node minimize button is on the right side of the node
     * header.
     *
     * @param widget the node widget
     * @return true, if the button is on the right side; false, if the button is
     * on the left side
     *
     */
    public abstract boolean isNodeMinimizeButtonOnRight(IPNodeWidget widget);

    /**
     * Returns an minimize-widget image for a specific node widget.
     *
     * @param widget the node widget
     * @return the minimize-widget image
     *
     */
    public abstract Image getMinimizeWidgetImage(IPNodeWidget widget);

    /**
     * Called to create a pin-category widget.
     *
     * @param widget the node widget
     * @param categoryDisplayName the category display name
     * @return the pin-category widget
     *
     */
    public abstract IPinSeperatorWidget createPinCategoryWidget(IPNodeWidget widget, String categoryDisplayName);

    /**
     * Called to install UI to a connection widget.
     *
     * @param widget the connection widget
     *
     */
    public abstract void installUI(IPEdgeWidget widget);

    /**
     * Called to update UI of a connection widget. Called from
     * PConnectionWidget.notifyStateChanged method.
     *
     * @param widget the connection widget
     * @param previousState the previous state
     * @param state the new state
     *
     */
    public abstract void updateUI(IPEdgeWidget widget, ObjectState previousState, ObjectState state);

    /**
     * Called to install UI to a pin widget.
     *
     * @param widget the pin widget
     *
     */
    public abstract void installUI(IPinWidget widget);

    public abstract void installUI(IPinSeperatorWidget widget);

    public abstract void installUI(IModelerScene widget);

    /**
     * Called to update UI of a pin widget. Called from
     * PinWidget.notifyStateChanged method.
     *
     * @param widget the pin widget
     * @param previousState the previous state
     * @param state the new state
     *
     */
    public abstract void updateUI(IPinWidget widget, ObjectState previousState, ObjectState state);

    public abstract void highlightUI(IPNodeWidget widget);

    public abstract void highlightUI(IEdgeWidget widget);

    public abstract void highlightUI(IPinWidget widget);

}
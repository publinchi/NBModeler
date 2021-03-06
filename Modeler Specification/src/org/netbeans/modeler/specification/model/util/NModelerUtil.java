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
package org.netbeans.modeler.specification.model.util;

import org.netbeans.modeler.specification.model.document.IModelerScene;
import org.netbeans.modeler.widget.edge.IEdgeWidget;
import org.netbeans.modeler.widget.node.INodeWidget;

public interface NModelerUtil<S extends IModelerScene> extends IModelerUtil<S> {

    public void dettachEdgeSourceAnchor(S scene, IEdgeWidget edgeWidget, INodeWidget sourceNodeWidget);

    public void dettachEdgeTargetAnchor(S scene, IEdgeWidget edgeWidget, INodeWidget targetNodeWidget);

}

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
package org.netbeans.modeler.specification.model.document.widget;

import org.netbeans.modeler.core.exception.InvalidElmentException;
import org.netbeans.modeler.specification.model.document.core.IBaseElement;

public interface IArtifactEdgeWidget extends IArtifactWidget {

    public IBaseElementWidget getSourceElementWidget();

    public void setSourceElementWidget(IBaseElementWidget sourceNode);

    public IBaseElementWidget getTargetElementWidget();

    public void setTargetElementWidget(IBaseElementWidget targetNode);
}

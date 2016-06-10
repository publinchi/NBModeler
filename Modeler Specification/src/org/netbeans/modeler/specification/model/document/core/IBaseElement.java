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
package org.netbeans.modeler.specification.model.document.core;

import java.io.Serializable;
import java.util.Map;

public interface IBaseElement extends Serializable {

    public String getId();

    public void setId(String id);

    public Map<String, String> getCustomAttributes();

    public void setCustomAttributes(Map<String, String> customAttributes);

    public Object getRootElement();

    public void setRootElement(Object rootElement);
}

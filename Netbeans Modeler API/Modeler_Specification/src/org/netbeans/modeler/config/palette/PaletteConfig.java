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
package org.netbeans.modeler.config.palette;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.netbeans.modeler.config.document.IModelerDocument;
import org.netbeans.modeler.file.IModelerFileDataObject;

/**
 *
 *
 */
@XmlRootElement(name = "palette-config")
@XmlAccessorType(XmlAccessType.NONE)
public class PaletteConfig implements IPaletteConfig {

    private String id;
    private String name;

    @XmlElement(name = "category-node")
    private List<CategoryNodeConfig> categoryNodeConfigs = new ArrayList<CategoryNodeConfig>();

    /**
     * @return the categoryNodeConfigs
     */
    @Override
    public List<CategoryNodeConfig> getCategoryNodeConfigs() {
        return categoryNodeConfigs;
    }

    /**
     * @param categoryNodeConfigs the categoryNodeConfigs to set
     */
    public void setCategoryNodeConfigs(List<CategoryNodeConfig> categoryNodeConfigs) {
        this.categoryNodeConfigs = categoryNodeConfigs;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public SubCategoryNodeConfig findSubCategoryNodeConfig(IModelerDocument modelerDocument) {
        for (CategoryNodeConfig categoryNodeConfig : categoryNodeConfigs) {
            for (SubCategoryNodeConfig subCategoryNodeConfig : categoryNodeConfig.getSubCategoryNodeConfigs()) {
                if (subCategoryNodeConfig.getModelerDocument() == modelerDocument) {
                    return subCategoryNodeConfig;
                }
            }
        }
        return null;

    }

}
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
package org.netbeans.modeler.specification.export;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.netbeans.modeler.specification.model.document.IModelerScene;

public class DefaultExportManager implements IExportManager<IModelerScene> {

    @Override
    public void export(IModelerScene scene, FileType format, File file) {
    }

    private static List<FileType> filetypes;

    @Override
    public List<FileType> getExportType() {
        if (filetypes == null) {
            filetypes = new ArrayList<>();
        }
        return filetypes;
    }
}

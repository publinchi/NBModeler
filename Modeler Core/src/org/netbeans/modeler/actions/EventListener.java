/**
 * Copyright [2016] Gaurav Gupta
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
package org.netbeans.modeler.actions;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import org.netbeans.modeler.core.ModelerFile;
import org.netbeans.modeler.core.NBModelerUtil;

/**
 * @author Gaurav Gupta
 */
public class EventListener implements IEventListener {

    protected ModelerFile modelerFile;

    @Override
    public void registerEvent(JComponent component, ModelerFile modelerFile) {
        this.modelerFile = modelerFile;
        component.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, InputEvent.CTRL_MASK), "SAVE_FILE");
        component.getActionMap().put("SAVE_FILE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelerFile.save();
            }
        });
        component.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, 0), "DELETE_ITEM");
        component.getActionMap().put("DELETE_ITEM", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelerFile.deleteSelectedElements();
                NBModelerUtil.hideContextPalette(modelerFile.getModelerScene());
            }
        });
    }
}
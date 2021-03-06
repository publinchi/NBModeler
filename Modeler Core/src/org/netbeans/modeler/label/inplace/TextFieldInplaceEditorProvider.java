/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2007 Sun
 * Microsystems, Inc. All Rights Reserved.
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 */
package org.netbeans.modeler.label.inplace;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EnumSet;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.api.visual.action.InplaceEditorProvider;
import org.netbeans.api.visual.action.TextFieldInplaceEditor;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.modeler.specification.model.document.IModelerScene;

/**
 * @author David Kaspar
 */
public final class TextFieldInplaceEditorProvider implements InplaceEditorProvider<JTextField> {

    private TextFieldInplaceEditor editor;
    private EnumSet<InplaceEditorProvider.ExpansionDirection> expansionDirections;

    private KeyListener keyListener;
    private FocusListener focusListener;
    private DocumentListener documentListener;

    public TextFieldInplaceEditorProvider(TextFieldInplaceEditor editor, EnumSet<InplaceEditorProvider.ExpansionDirection> expansionDirections) {
        this.editor = editor;
        this.expansionDirections = expansionDirections;
    }

    @Override
    public JTextField createEditorComponent(EditorController controller, Widget widget) {
        if (!editor.isEnabled(widget)) {
            return null;
        }
        final JTextField field = new JTextField(editor.getText(widget));
//        field.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.WHITE),new EmptyBorder(0,0,0,0)));
        field.selectAll();
        Scene scene = widget.getScene();
        double zoomFactor = scene.getZoomFactor();
        if (zoomFactor > 1.0) {
            Font font = scene.getDefaultFont();
            font = font.deriveFont((float) (font.getSize2D() * zoomFactor));
            field.setFont(font);
        }
        return field;
    }

    @Override
    public void notifyOpened(final EditorController controller, final Widget widget, JTextField editor) {
        editor.setMinimumSize(new Dimension(64, 19));
        keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                IModelerScene modelerScene = (IModelerScene) widget.getScene();
                switch (e.getKeyChar()) {
                    case KeyEvent.VK_ESCAPE:
                        e.consume();
                        controller.closeEditor(false);
                        modelerScene.getView().requestFocus();
                        break;
                    case KeyEvent.VK_ENTER:
                        e.consume();
                        controller.closeEditor(true);
                        modelerScene.getView().requestFocus();
                        break;
                }
            }
        };
        focusListener = new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                controller.closeEditor(true);
                widget.getScene().getView().requestFocusInWindow();
            }
        };
        documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                controller.notifyEditorComponentBoundsChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                controller.notifyEditorComponentBoundsChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                controller.notifyEditorComponentBoundsChanged();
            }
        };
        editor.addKeyListener(keyListener);
        editor.addFocusListener(focusListener);
        editor.getDocument().addDocumentListener(documentListener);
        editor.selectAll();
    }

    @Override
    public void notifyClosing(EditorController controller, Widget widget, JTextField editor, boolean commit) {
        editor.getDocument().removeDocumentListener(documentListener);
        editor.removeFocusListener(focusListener);
        editor.removeKeyListener(keyListener);
        if (commit) {
            this.editor.setText(widget, editor.getText());
            if (widget != null) {
                widget.getScene().validate();
            }
        }
    }

    @Override
    public Rectangle getInitialEditorComponentBounds(EditorController controller, Widget widget, JTextField editor, Rectangle viewBounds) {
        return null;
    }

    @Override
    public EnumSet<ExpansionDirection> getExpansionDirections(EditorController controller, Widget widget, JTextField editor) {
        return expansionDirections;
    }

}

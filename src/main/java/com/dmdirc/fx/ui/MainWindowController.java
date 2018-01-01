//<editor-fold desc="License">
/*
Copyright (c) 2006-2017 DMDirc Developers

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
//</editor-fold>

package com.dmdirc.fx.ui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;

public class MainWindowController extends AbstractFXMLViewController {
  private FXUI ui;

  @Inject
  public MainWindowController(FXUI ui) {
    this.ui = ui;
  }

  @FXML
  public void exitButtonAction(final ActionEvent actionEvent) {
    Platform.exit();
  }

  @FXML
  public void handleAboutDialog(final ActionEvent actionEvent) {
    final AboutDialogController c = ui.aboutDialogController().get().get();
    final Parent parent = c.loadFxml();
    final Stage stage = new Stage();
    c.setDialogStage(stage);
    final Scene scene = new Scene(parent);
    stage.setScene(scene);
    stage.show();
  }

  @Override
  protected URL getFxmlResourceUrl() {
    return getClass().getClassLoader().getResource("MainWindow.fxml");
  }

  @Override
  protected ResourceBundle getFxmlResourceBundle() {
    return null;
  }
}

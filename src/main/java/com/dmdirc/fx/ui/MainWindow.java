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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainWindow {

  private Stage primaryStage;

  @FXML
  public void exitButtonAction(final ActionEvent actionEvent) {
    Platform.exit();
  }

  @FXML
  public void handleAboutDialog(final ActionEvent actionEvent) throws IOException {
    FXMLLoader fl = new FXMLLoader();
    fl.setLocation(getClass().getClassLoader().getResource("AboutDialog.fxml"));
    fl.load();
    Parent root = fl.getRoot();

    Stage modal_dialog = new Stage(StageStyle.DECORATED);
    modal_dialog.initModality(Modality.WINDOW_MODAL);
    modal_dialog.initOwner(primaryStage);
    Scene scene = new Scene(root);

    AboutDialog t1 = (AboutDialog)fl.getController();
    t1.setDialogStage(modal_dialog);
    modal_dialog.setScene(scene);
    modal_dialog.show();
  }
}

package com.dmdirc.fx.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

abstract class AbstractFXMLViewController {

  private Parent fxmlRoot;

  /**
   * Gets the URL to the FXML file describing the view presented by this controller.<br/>
   *
   * A default implementation would look like this:<br/>
   * <code>
   * 	return getClass().getResource("/myView.fxml");
   * </code>
   *
   * @return FXML resource URL
   */
  protected abstract URL getFxmlResourceUrl();

  /**
   * @return Localization bundle for the FXML labels or <code>null</code>.
   */
  protected abstract ResourceBundle getFxmlResourceBundle();

  /**
   * Creates a FXML loader used in {@link #loadFxml()}. This method can be overwritten for further loader customization.
   *
   * @return Configured loader ready to load.
   */
  protected FXMLLoader createFxmlLoader() {
    final URL fxmlUrl = getFxmlResourceUrl();
    final ResourceBundle rb = getFxmlResourceBundle();
    final FXMLLoader loader = new FXMLLoader(fxmlUrl, rb);
    loader.setController(this);
    return loader;
  }

  /**
   * Loads the view presented by this controller from the FXML file return by {@link #getFxmlResourceUrl()}. This method can only be invoked once.
   *
   * @return Parent view element.
   */
  protected final synchronized Parent loadFxml() {
    if (fxmlRoot == null) {
      final FXMLLoader loader = createFxmlLoader();
      try {
        fxmlRoot = loader.load();
      } catch (IOException e) {
        throw new IllegalStateException("Could not load FXML file from location: " + loader.getLocation(), e);
      }
    }
    return fxmlRoot;
  }
}

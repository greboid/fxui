package com.dmdirc.fx.ui;

import dagger.Module;
import dagger.Provides;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.stage.Stage;

import javax.inject.Named;

@Module
public class FXUIModule {
  private final Application application;
  private Stage primaryStage;

  public FXUIModule(final Application application, final Stage primaryStage) {
    this.application = application;
    this.primaryStage = primaryStage;
  }

  @Provides
  public Application getApplication() {
    return application;
  }

  @Provides
  public HostServices getHostServices() {
    return application.getHostServices();
  }

  @Provides
  @Named("primary")
  public Stage getPrimaryStage() {
    return primaryStage;
  }
}

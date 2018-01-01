package com.dmdirc.fx.ui;

import dagger.Module;
import dagger.Provides;
import javafx.application.Application;
import javafx.application.HostServices;

@Module
public class FXUIModule {
  private final Application application;

  public FXUIModule(final Application application) {
    this.application = application;
  }

  @Provides
  public Application getApplication() {
    return application;
  }

  @Provides
  public HostServices getHostServices() {
    return application.getHostServices();
  }
}

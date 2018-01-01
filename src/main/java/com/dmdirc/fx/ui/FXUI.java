package com.dmdirc.fx.ui;

import dagger.Component;
import dagger.Lazy;

import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@Component(modules = FXUIModule.class)
interface FXUI {
  Provider<MainWindowController> mainWindowController();
  Provider<Lazy<AboutDialogController>> aboutDialogController();
}

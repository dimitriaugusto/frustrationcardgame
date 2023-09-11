package com.dimiaug.frustration.common.di;

import static org.koin.core.parameter.ParametersHolderKt.parametersOf;
import static org.koin.java.KoinJavaComponent.inject;

import com.dimiaug.frustration.common.entrypoints.MainActivity;
import com.dimiaug.frustration.common.ui.controllers.MainController;
import com.dimiaug.frustration.common.domain.interfaces.CommonInjection;
import com.dimiaug.frustration.common.ui.presenters.MainPresenter;

import kotlin.Lazy;

public class CommonInjectionImpl implements CommonInjection {
    @Override
    public MainPresenter getMainPresenter(MainActivity mainActivity) {
        Lazy<MainPresenter> presenter =
                inject(MainPresenter.class, null, () -> parametersOf(mainActivity));
        return presenter.getValue();
    }

    @Override
    public MainController getMainController(MainActivity mainActivity, MainPresenter presenter) {
        Lazy<MainController> controller =
                inject(MainController.class, null,
                        () -> parametersOf(mainActivity, presenter));
        return controller.getValue();
    }
}

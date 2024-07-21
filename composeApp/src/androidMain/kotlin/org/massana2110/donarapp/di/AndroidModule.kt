package org.massana2110.donarapp.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.massana2110.donarapp.auth.ui.viewmodels.LoginViewModel

val appModule = module {
    // view models here
    viewModel { LoginViewModel(get()) }
}
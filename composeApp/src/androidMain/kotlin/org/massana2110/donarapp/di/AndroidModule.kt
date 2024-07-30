package org.massana2110.donarapp.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.massana2110.donarapp.features.auth.ui.viewmodels.LoginViewModel
import org.massana2110.donarapp.features.home.viewmodels.ProfileViewModel

val appModule = module {
    // view models here
    viewModel { LoginViewModel(get(), get()) }
    viewModel { ProfileViewModel(get()) }
}
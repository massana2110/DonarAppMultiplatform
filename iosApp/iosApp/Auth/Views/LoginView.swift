//
//  LoginView.swift
//  iosApp
//
//  Created by David Massana on 13/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct LoginView: View {
    @State var email: String = ""
    @State var password: String = ""
    
    var body: some View {
        VStack {
            LoginHeaderView()
            LoginDivider()
            Spacer().frame(height: 16)
            LoginForm(email: $email, password: $password)
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}

struct LoginHeaderView: View {
    var body: some View {
        Image("DonarAppIcon")
        Text("Bienvenido a Donar App")
            .font(.title)
            .bold()
            .foregroundColor(.blue)
            .padding(.top, 16)
        Spacer().frame(height: 16)
        Text("Crea una cuenta o inicia sesión para convertirte en un agente de cambio")
            .font(.subheadline)
            .padding(.horizontal, 24)
            .multilineTextAlignment(.center)
        LoginSocialButtonsView()
    }
}

struct LoginSocialButtonsView: View {
    var body: some View {
        HStack(alignment: .center, spacing: 32) {
            Button(action: {}) {
                Image("IcApple")
                    .resizable()
                    .frame(width: 48, height: 48)
            }
            Button(action: {}) {
                Image("IcGoogle")
                    .resizable()
                    .frame(width: 48, height: 48)
            }
            Button(action: {}) {
                Image("IcFacebook")
                    .resizable()
                    .frame(width: 48, height: 48)
            }
        }
        .frame(maxWidth: .infinity)
        .padding()
    }
}

struct LoginDivider: View {
    var body: some View {
        HStack {
            line
            Text("O si lo prefieres").font(.subheadline)
            line
        }.padding(.horizontal, 16)
    }
    
    var line: some View {
        VStack { Divider().background(.gray) }
    }
}

struct LoginForm: View {
    
    @Binding var email: String
    @Binding var password: String
    
    var body: some View {
        VStack(alignment: .leading) {
            LoginInput(label: "Correo electronico", placeHolder: "example@correo.com", inputValue: $email)
            Spacer().frame(height: 16)
            LoginInput(label: "Contraseña", placeHolder: "●●●●●●●●●", textFieldType: "password", inputValue: $password)
            Spacer().frame(height: 16)
            Button(action: {}) {
                Text("Olvidaste tu contraseña?")
                    .font(.subheadline)
                    .foregroundColor(Color("GrayPrimary"))
                    .frame(maxWidth: .infinity)
            }
            Spacer().frame(height: 24)
            Button(action: {}) {
                Text("Continuar")
                    .bold()
                    .foregroundColor(Color("GrayPrimary"))
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(Color("YellowPrimary"))
                    .clipShape(RoundedRectangle(cornerRadius: 8))
            }
            Spacer().frame(height: 16)
            HStack {
                Text("No tienes cuenta?")
                Button(action: {}) {
                    Text("Crear cuenta")
                }
            }.frame(maxWidth: .infinity)
        }
        .frame(maxWidth: .infinity)
        .padding(.horizontal, 16)
    }
}

struct LoginInput: View {
    let label: String
    let placeHolder: String
    var textFieldType: String = "email"
    @Binding var inputValue: String
    
    var body: some View {
        Text(label)
        if textFieldType == "email" {
            TextField(placeHolder, text: $inputValue)
                .keyboardType(.emailAddress)
                .padding(16)
                .background(Color("GrayInput"))
                .clipShape(RoundedRectangle(cornerRadius: 8))
                .onChange(of: inputValue) { oldValue, newValue in
                    inputValue = newValue
                }
        } else {
            SecureField(placeHolder, text: $inputValue)
                .keyboardType(.emailAddress)
                .font(.caption)
                .padding(16)
                .background(Color("GrayInput"))
                .clipShape(RoundedRectangle(cornerRadius: 8))
                .onChange(of: inputValue) { oldValue, newValue in
                    inputValue = newValue
                }
        }
    }
    
}

#Preview {
    LoginView()
}

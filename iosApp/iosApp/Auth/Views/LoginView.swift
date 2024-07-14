//
//  LoginView.swift
//  iosApp
//
//  Created by David Massana on 13/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct LoginView: View {
    var body: some View {
        VStack {
            Image("DonarAppIcon")
            Text("Bienvenido a Donar App")
                .font(.title)
                .bold()
                .foregroundColor(/*@START_MENU_TOKEN@*/.blue/*@END_MENU_TOKEN@*/)
        }
    }
}

#Preview {
    LoginView()
}

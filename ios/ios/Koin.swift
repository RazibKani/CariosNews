//
//  Koin.swift
//  ios
//
//  Created by Razib Kani Maulidan on 22/11/20.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import shared

func startKoin() {
        
    let koinApplication = KoinIOSKt.doInitKoinIos {
        NSLog("Hello from iOS")
    }
    _koin = koinApplication.koin
}

private var _koin: Koin_coreKoin? = nil
var koin: Koin_coreKoin {
    return _koin!
}

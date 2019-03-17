//
//  RNMasterCardModule.h
//  RNMasterCardModule
//
//  Created by Erik Poort on 17/03/2019.
//  Copyright (c) 2019 Erik Poort. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <React/RCTBridgeModule.h>
#import <React/RCTUtils.h>
#import <MCCMerchant/MCCMerchant.h>

@interface RNMasterCardModule : NSObject <RCTBridgeModule, MCCMerchantDelegate>

@end

//
//  RNMasterCardModule.m
//  RNMasterCardModule
//
//  Created by Erik Poort on 17/03/2019.
//  Copyright (c) 2019 Erik Poort. All rights reserved.
//

#import "RNMasterCardModule.h"

static NSString *const kRejectCode = @"MasterCardModule";

@implementation RNMasterCardModule {
}

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(
    merchantUrlScheme: (NSString *)merchantUrlScheme
    merchantName: (NSString *)merchantName
    merchantUniversalLink: (NSString *)merchantUniversalLink
    merchantUserId: (NSString *)merchantUserId
    expressCheckoutEnabled: (NSNumber *)expressCheckoutEnabled
    resolver:(RCTPromiseResolveBlock)resolve
    rejecter:(RCTPromiseRejectBlock)reject
) {
    MCCConfiguration *configuration = [[MCCConfiguration alloc] init];
    configuration.merchantUrlScheme = merchantUrlScheme;
    configuration.merchantName = merchantName;
    configuration.merchantUniversalLink = merchantUniversalLink;
    configuration.merchantUserId = merchantUserId;
    configuration.locale = [NSLocale currentLocale];
    configuration.expressCheckoutEnabled = expressCheckoutEnabled.boolValue;
    
    [MCCMerchant
     initializeSDKWithConfiguration:configuration
     onStatusBlock:^(NSDictionary * _Nonnull status, NSError * _Nullable error) {
         resolve(status[kInitializeStateKey]);
    }];
}

#pragma mark - MCCMerchantDelegate

- (void)didFinishCheckout:(MCCCheckoutResponse * _Nonnull)checkoutResponse {
    
}

- (void)didGetAddPaymentMethodRequest:(nullable void (^)(NSSet<MCCCardType *> * _Nonnull, NSString * _Nonnull))completionBlock {
    
}

- (void)didGetCheckoutRequest:(nullable BOOL (^)(MCCCheckoutRequest * _Nonnull))completionBlock {
    
}

- (void)didReceiveCheckoutError:(NSError * _Nonnull)error {
    
}

- (MCCPaymentMethod * _Nonnull)loadPaymentMethod {
    return [[MCCPaymentMethod alloc] init];
}

@end

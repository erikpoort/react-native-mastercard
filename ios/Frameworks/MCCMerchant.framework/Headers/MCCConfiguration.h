//
//  MCCConfiguration.h
//  MCCMerchant
//
//  Created by Adeyenuwo, Paul on 4/27/16.
//  Copyright © 2016 MasterCard. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "MCCMerchantConstants.h"
#import "MCCUserDetail.h"

/**
 
 Overview:
 
 MCCConfiguration is a model that represents the framework configuration passed by the client app to the framework.
 
 Subclassing Notes:
 
 Do not subclass MCCConfiguration.
 
 */

@interface MCCConfiguration : NSObject

/**
 * Locale Information
 */
@property (nonatomic, copy, nonnull) NSLocale *locale;

/**
 *The merchantName to be used for display on checkout screen of wallet application
 */
@property (nonatomic, copy, nonnull) NSString * merchantName;

/**
 * The merchant express checkout enable sign
 */
@property (nonatomic, assign) BOOL expressCheckoutEnabled;

#pragma mark -
#pragma mark Optional

/**
 * The merchantUserId to be used for register user and for express pairing
 * The merchantUserId must be set if expressCheckoutEnabled is true
 */
@property (nonatomic, copy, nullable) NSString * merchantUserId;

/**
 *  The merchant URL scheme as redirect address Only the protocol part of the URLScheme
 *  is expected, the framework will do necessary formatting as required.
 *  For example, in "http://mydomain.com", "http" is the protocol, the framework will
 *  add "://" etc... while using the scheme.
 */
@property (nonatomic, copy, nullable) NSString *merchantUrlScheme;

/**
 * Merchant Universal Link: for app to app transition
 */
@property (nonatomic, copy, nullable) NSString *merchantUniversalLink;

/**
 * The merchantUserDetail is used to represents the user details available
 */
@property (nonatomic, strong, nullable) MCCUserDetail *merchantUserDetail;

/**
 * Returns a string that describes the current configuration state.
 */
@property (nonatomic, readonly, copy) NSString * _Nonnull description;

@end

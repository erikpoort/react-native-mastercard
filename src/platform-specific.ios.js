/**
 * Initialize masterpass
 */
function _initialize(Module, merchantUrlScheme, merchantName, merchantUniversalLink, merchantUserId, expressCheckoutEnabled) {
  return Module.initialize(merchantUrlScheme, merchantName, merchantUniversalLink, merchantUserId, expressCheckoutEnabled);
}

module.exports = {
  _initialize,
}

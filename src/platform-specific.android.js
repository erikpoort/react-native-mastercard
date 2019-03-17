/**
 * Initialize masterpass
 */
function _initialize(Module, merchantName, checkoutId, signature, expressCheckoutEnabled) {
  return Module.initialize(merchantName, checkoutId, signature, expressCheckoutEnabled);
}

module.exports = {
  _initialize,
}

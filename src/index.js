import { NativeModules } from 'react-native';
const { RNMasterCardModule } = NativeModules;
import { _initialize } from './platform-specific';

/**
 * Initialize masterpass
 * @param See platform specific files to find correct parameters
 */
function initialize() {
  return _initialize(RNMasterCardModule, arguments);
}

module.exports = {
  initialize,
}

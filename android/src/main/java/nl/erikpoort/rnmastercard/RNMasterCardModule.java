package nl.erikpoort.rnmastercard;

import android.app.Application;
import android.location.Address;
import android.os.Bundle;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.mastercard.mp.checkout.Amount;
import com.mastercard.mp.checkout.CheckoutSummaryItem;
import com.mastercard.mp.checkout.MasterpassCheckoutCallback;
import com.mastercard.mp.checkout.MasterpassCheckoutRequest;
import com.mastercard.mp.checkout.MasterpassError;
import com.mastercard.mp.checkout.MasterpassInitCallback;
import com.mastercard.mp.checkout.MasterpassMerchant;
import com.mastercard.mp.checkout.MasterpassMerchantConfiguration;
import com.mastercard.mp.checkout.ShippingSummaryItem;

import java.util.List;
import java.util.Locale;

/**
 * Created by erik on 17/03/2019.
 * Erik Poort 2019
 */

class RNMasterCardModule extends ReactContextBaseJavaModule implements MasterpassInitCallback, MasterpassCheckoutCallback {
    private static final String MASTERCARD = "MasterCardModule";

    private final Application _application;
    private Promise _initializePromise;

    RNMasterCardModule(ReactApplicationContext reactContext, Application application) {
        super(reactContext);

        this._application = application;
    }

    @Override
    public String getName() {
        return MASTERCARD;
    }

    @ReactMethod
    public void initialize(final String merchantName, final String checkoutId, final String signature, final Promise promise) {
        MasterpassMerchantConfiguration configuration = new MasterpassMerchantConfiguration.Builder()
                .setContext(_application)
                .setEnvironment(MasterpassMerchantConfiguration.PRODUCTION)
                .setMerchantName(merchantName)
                .setLocale(Locale.getDefault())
                .setCheckoutId(checkoutId)
                .setSignature(signature)
                .setExpressCheckoutEnabled(true)
                .build();

        _initializePromise = promise;
        MasterpassMerchant.initialize(configuration, this);
    }

    @Override
    public void onInitSuccess() {
        if (_initializePromise != null) {
            _initializePromise.resolve(true);
        }
    }

    @Override
    public void onInitError(MasterpassError masterpassError) {
        if (_initializePromise != null) {
            _initializePromise.reject(MASTERCARD, masterpassError.message());
        }
    }

    @Override
    public MasterpassCheckoutRequest getCheckoutRequest() {
        return null;
    }

    @Override
    public void onCheckoutComplete(Bundle bundle) {

    }

    @Override
    public void onCheckoutError(MasterpassError masterpassError) {

    }

    @Override
    public MasterpassCheckoutRequest getUpdatedCheckoutData(List<CheckoutSummaryItem> list, List<ShippingSummaryItem> list1, ShippingSummaryItem shippingSummaryItem, Address address, Amount amount) {
        return null;
    }
}

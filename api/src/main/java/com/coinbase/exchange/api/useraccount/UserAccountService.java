package com.coinbase.exchange.api.useraccount;

import java.util.List;

public interface UserAccountService {
    List<UserAccountData> getTrailingVolume();
}

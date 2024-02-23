package com.tradeflow.models;

import com.tradeflow.enums.CoinName;

public class Coin {
    private CoinName coinName;

    public CoinName getCoinName() {
        return coinName;
    }

    public void setCoinName(CoinName coinName) {
        this.coinName = coinName;
    }
}

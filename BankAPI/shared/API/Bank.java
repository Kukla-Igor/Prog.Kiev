package ua.kiev.prog.shared.API;

import java.util.Arrays;

public class Bank {

    private String date;
    private String bank;
    private int baseCurrency;
    private String baseCurrencyLit;
    private ExchangeRate[] exchangeRate;


    public Bank() {
    }

    public Bank(String date, String bank, int baseCurrency, String baseCurrencyLit, ExchangeRate[] exchangeRate) {
        this.date = date;
        this.bank = bank;
        this.baseCurrency = baseCurrency;
        this.baseCurrencyLit = baseCurrencyLit;
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "date='" + date + '\'' +
                ", bank='" + bank + '\'' +
                ", baseCurrency=" + baseCurrency +
                ", baseCurrencyLit='" + baseCurrencyLit + '\'' +
                ", exchangeRate=" + Arrays.toString(exchangeRate) +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(int baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getBaseCurrencyLit() {
        return baseCurrencyLit;
    }

    public void setBaseCurrencyLit(String baseCurrencyLit) {
        this.baseCurrencyLit = baseCurrencyLit;
    }

    public ExchangeRate[] getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(ExchangeRate[] exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}

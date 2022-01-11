package ua.kiev.prog.shared.API;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class CourseArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date date;
    private String bank;
    private String baseCurrency;
    private String currency;
    private float saleRateNB;
    private float purchaseRateNB;


    public CourseArchive() {
    }


    public CourseArchive(Date date, String bank, String baseCurrency, String currency, float saleRateNB, float purchaseRateNB) {
        this.date = date;
        this.bank = bank;
        this.baseCurrency = baseCurrency;
        this.currency = currency;
        this.saleRateNB = saleRateNB;
        this.purchaseRateNB = purchaseRateNB;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return "CourseArchive{" +
                "id=" + id +
                ", date=" + dateFormat.format(date) +
                ", bank='" + bank + '\'' +
                ", baseCurrency=" + baseCurrency +
                ", currency='" + currency + '\'' +
                ", saleRateNB=" + saleRateNB +
                ", purchaseRateNB=" + purchaseRateNB +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getSaleRateNB() {
        return saleRateNB;
    }

    public void setSaleRateNB(float saleRateNB) {
        this.saleRateNB = saleRateNB;
    }

    public float getPurchaseRateNB() {
        return purchaseRateNB;
    }

    public void setPurchaseRateNB(float purchaseRateNB) {
        this.purchaseRateNB = purchaseRateNB;
    }
}

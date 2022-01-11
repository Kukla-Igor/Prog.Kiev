package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.kiev.prog.shared.API.Bank;
import ua.kiev.prog.shared.API.CourseArchive;
import ua.kiev.prog.shared.API.ExchangeRate;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class APIPB {
    private final Gson gson;

    public APIPB() {
        this.gson = new GsonBuilder().create();
    }


    public CourseArchive getAPI(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        CourseArchive archive = new CourseArchive();
        try {
            URL url = new URL("https://api.privatbank.ua/p24api/exchange_rates?json&date=" + dateFormat.format(date));
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            InputStream is = http.getInputStream();

            byte[] buf = responseBodyToArray(is);
            String strBuf = new String(buf, StandardCharsets.UTF_8);
            Bank bank = gson.fromJson(strBuf, Bank.class);
            ExchangeRate[] exchangeRates = bank.getExchangeRate();
            for (int i = 1;i< exchangeRates.length; i++ ){
                if (exchangeRates[i].getCurrency().equals("USD")){
                    archive.setDate(dateFormat.parse(bank.getDate()));
                    archive.setBank(bank.getBank());
                    archive.setBank(bank.getBank());
                    archive.setBaseCurrency(exchangeRates[i].getBaseCurrency());
                    archive.setCurrency(exchangeRates[i].getCurrency());
                    archive.setSaleRateNB(exchangeRates[i].getSaleRateNB());
                    archive.setPurchaseRateNB(exchangeRates[i].getPurchaseRateNB());
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return archive;
    }


        private byte[] responseBodyToArray(InputStream is) throws IOException {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[10240];
            int r;

            do {
                r = is.read(buf);
                if (r > 0) bos.write(buf, 0, r);
            } while (r != -1);

            return bos.toByteArray();
        }
    }

package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    public static void main(String[] args) {

        String JSON_TEXT =  """
                 {
                    "books": [
                       {
                          "name": "…",
                          "pages": 100,
                          "author": "xxx"
                       },
                       {
                          "name": "…",
                          "pages": 200,
                          "author": "yyyy"
                       }
                    ]
                  }
                """;




        Gson gson = new GsonBuilder().create();
        Books books = gson.fromJson(JSON_TEXT, Books.class);
        System.out.println(books);
    }
}

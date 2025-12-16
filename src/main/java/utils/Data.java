package utils;

import java.util.Random;

public class Data {

    Random random = new Random();

    public String forProduct(){
        String[] product = {"Winter", "Blue"};
        return (product[random.nextInt(product.length)]);
    }
}

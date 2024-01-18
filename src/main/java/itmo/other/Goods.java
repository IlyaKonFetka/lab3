package itmo.other;

import itmo.enums.Country;

public abstract class Goods {
    public int price;
    public int vendorCode;

    public Goods(int price, int vendorCode) {
        this.price = price;
        this.vendorCode = vendorCode;
    }

    public static class PostageStamp extends Goods{
        public String postalСompany;
        public Country country;

        public PostageStamp(int price, int vendorCode, String postalСompany, Country country) {
            super(price, vendorCode);
            this.postalСompany = postalСompany;
            this.country = country;
        }
    }
    public static class BottleOfJam extends Goods{
        public int volume;

        public BottleOfJam(int price, int vendorCode, int volume) {
            super(price, vendorCode);
            this.volume = volume;
        }
    }

    public static class TV extends Goods{
        public Human humanIn;

        public TV(int price, int vendorCode, Human humanIn) {
            super(price, vendorCode);
            this.humanIn = humanIn;
        }
    }
}

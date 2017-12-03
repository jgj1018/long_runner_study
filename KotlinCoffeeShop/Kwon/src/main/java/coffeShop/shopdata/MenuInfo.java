package coffeShop.shopdata;

import java.util.HashMap;

public enum MenuInfo {
    esspresso {
        @Override
        public int getPrice() {
            return 200;
        }
    },
    americano {
        @Override
        public int getPrice() {
            return 300;
        }
    },
    capuchino {
        @Override
        public int getPrice() {
            return 400;
        }
    },
    cafelatte {
        @Override
        public int getPrice() {
            return 410;
        }
    };

    public abstract int getPrice();

}


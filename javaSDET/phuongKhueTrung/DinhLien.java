package phuongKhueTrung;

import phuongHoaXuan.DinhBoLinh;

public class DinhLien extends DinhBoLinh {
    public static void main(String[] args) {
        DinhLien dinhLien = new DinhLien();
//        dinhLien..getEspresso(); Access modifiers... : private access
        dinhLien.setEspresso("Espresso");
        dinhLien.getCherry();
        dinhLien.setCherry("Cherry");
    }
}

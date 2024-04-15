package phuongHoaXuan;

public class DinhBoLinh {
    private String espresso;
    private String getEspresso(){
        return espresso;
    }
    public void setEspresso(String espresso){
        this.espresso = espresso;
    }
    //Variable with value default
    String capuchino;

    public String getCapuchino() {
        return capuchino;
    }

    //Protected (Class kế thừa moi được phép truy cập)
    protected String Cherry;
    protected String getCherry() {return Cherry;}
    protected void setCherry(String cherry) {
        this.capuchino = Cherry;
    }

    protected static String static_demo;

    public static void main(String[] args) {
        DinhBoLinh dinhBoLinh = new DinhBoLinh();
        dinhBoLinh.setEspresso("Espresso");
        System.out.println(dinhBoLinh.getEspresso());
        dinhBoLinh.setCherry("Cherry");
        System.out.println(dinhBoLinh.getCherry());
        static_demo="dem";

    }

    static void defaultMethod(){
        System.out.println("defaultMethod");
    }

}

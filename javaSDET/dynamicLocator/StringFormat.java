package dynamicLocator;

public class StringFormat {
    public static void main(String[] args) {

        String dynamicText ="dynamicText";
        String dynamicText1 ="dynamicText1";
        String dynamicText2 ="dynamicText2";
        String dynamicLocator ="dynamicLocator : %s";
        clickDynamicElement(dynamicLocator,dynamicText);

    }
    protected  static  void clickDynamicElement(String dynamicText, String dynamicLocator){
         System.out.println("Clicking on dynamic element : "+ String.format(dynamicLocator, dynamicText));
     }

    private  static  void clickDynamicElement( String dynamicLocator,String dynamicText1,String dynamicText2){
        System.out.println("Clicking on dynamic element : "+ String.format(dynamicLocator, dynamicText1, dynamicText2));
    }

    private  static  void resParameters( String dynamicLocator,String ...resParameter){
        System.out.println("Clicking on dynamic element : "+ String.format(dynamicLocator, (Object) resParameter));
    }



}

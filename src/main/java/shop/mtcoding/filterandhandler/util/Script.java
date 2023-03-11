package shop.mtcoding.filterandhandler.util;

public class Script {

    public static String href(String uri){
        String sc = "";
        sc += "<script>";
        sc += "location.href='"+uri+"';";
        sc += "</script>";
        return sc;
    }

    public static String href(String uri, String msg){
        String sc = "";
        sc += "<script>";
        sc += "alert('"+msg+"');";
        sc += "location.href='"+uri+"';";
        sc += "</script>";
        return sc;
    }

    public static String back(String msg){
        String sc = "";
        sc += "<script>";
        sc += "alert('"+msg+"');";
        sc += "history.back();";
        sc += "</script>";
        return sc;
    }
}

package utils;

public class HTMLHelper {

    public static String generateHyperlink(String hyperLink, String innerText) {
        String link = "<a href=\"" + hyperLink + "\" class=\"pagination__link\">" + innerText + "</a>";
        return link;
    }

    public static String pagger(int currentIndex, int totalPage, String returnServlet) throws Exception {
        if (currentIndex > totalPage) {
            Exception e = new Exception("Customer accesses page out of range");
            throw e;
        }
        
        String link = "";
        for (int i = 1; i < currentIndex; i++) {
            link += generateHyperlink(returnServlet + "?page=" + i, "" + i);
        }
        
        link += "<a class=\"pagination__link pagination--active\">" + currentIndex + "</a>";
        for (int i = currentIndex + 1; i <= totalPage; i++) {
            link += generateHyperlink(returnServlet + "?page=" + i, "" + i);
        }
        return link;
    }
}

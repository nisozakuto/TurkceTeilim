package zakuto.tehilimtr;

import android.util.ArrayMap;

public class TehilimClass {
    private static ArrayMap<String, String> TehilimMap = new ArrayMap<String, String>();
    public TehilimClass() {
        TehilimMap.put("tr1","Teilim 1\n" + "\\n1 Aşre aiş aşer│ lo alah baatsat reşaim, uvdereh hataim lo amad, uvmoşav letsim lo yaşav.\\n2 Ki im beTorat Adonay heftso, uvTorato yege yomam valayla.\\n3 Veaya keets şatul al palge mayim; aşer piryo│ yiten beito, vealeu lo yibol, vehol aşer yaase yatsliah.\\n4 Lo hen areşaim, ki im kamots aşer tidefenu ruah.\\n5 Al ken│ lo yakumu reşaim bamişpat, vehataim baadat tsadikim.\\n6 Ki yodea Adonay dereh tsadikim, vedereh reşaim toved.\\n\n");
    }
    public static String getTehilim(String tehilimnumber) {
        return TehilimMap.get(tehilimnumber);
    }
}
package zakuto.tehilimtr;

public class Tehilim {
    private String latin;
    private String hebrew;
    private String latinAndHebrew;


    public Tehilim(String latin, String hebrew) {
        this.latin = latin;
        this.hebrew = hebrew;
        this.latinAndHebrew = latinAndHebrew;
    }

    public String getLatin() {
        return latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
    }

    public String getHebrew() {
        return hebrew;
    }

    public void setHebrew(String hebrew) {
        this.hebrew = hebrew;
    }

    public String getLatinAndHebrew() {
        return latinAndHebrew;
    }

    public void setLatinAndHebrew(String latinAndHebrew) {
        this.latinAndHebrew = latinAndHebrew;
    }
}

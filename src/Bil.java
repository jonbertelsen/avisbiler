public class Bil {

    // Attributter

    private String regNr;
    private String maerke;
    private String model;
    private int aargang;

    // Metoder

    // Constructor

    public Bil(){
        this.regNr = "";
        this.maerke = "";
        this.model = "";
        this.aargang = 0;
    }

    public Bil(String regNr, String maerke, String model, int aargang){
        this.regNr = regNr;
        this.maerke = maerke;
        this.model = model;
        this.aargang = aargang;
    }
    
    // Gettere og settere


    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getMaerke() {
        return maerke;
    }

    public void setMaerke(String maerke) {
        this.maerke = maerke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAargang() {
        return aargang;
    }

    public void setAargang(int aargang) {
        this.aargang = aargang;
    }

    public String visBil(){
        return String.format("%s %s %s %d",regNr,maerke,model,aargang);
    }
}

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static final int BRIK_REGNR = 1;
    public static final int BRIK_MAERKE = 2;
    public static final int BRIK_MODEL = 3;
    public static final int BRIK_AARGANG = 4;

    public static void main(String[] args) {

        ArrayList<Bil> garage = new ArrayList<Bil>();
        ArrayList<Bil> kopigarage = new ArrayList<Bil>();

//        garage.add(new Bil("TD32634","Volvo","V70",2016));
//        garage.add(new Bil("AP33634","VW","Beetle II",1970));
//        garage.add(new Bil("RE12634","Skoda","Octavia",2010));
//        garage.add(new Bil("AP33636","Ford","A",1910));
//        garage.add(new Bil("YE12631","BMW","320",2013));
//        garage.add(new Bil("LP33638","Tesla","P85",2017));

        //gemGarage(garage);
        System.out.println("Fyld garage");
        fyldGarage(kopigarage);
        visGarage(kopigarage);

    }

    private static void fyldGarage(ArrayList<Bil> garage) {

        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("garagefil.txt"));
            String l;
            int brik = BRIK_REGNR;
            Bil nyBil = null;

            while ((l = inputStream.readLine()) != null) {
                switch (brik){
                    case BRIK_REGNR:{
                        nyBil = new Bil();
                        nyBil.setRegNr(l);
                        brik = BRIK_MAERKE;
                        break;
                    }
                    case BRIK_MAERKE: {
                        nyBil.setMaerke(l);
                        brik = BRIK_MODEL;
                        break;
                    }
                    case BRIK_MODEL: {
                        nyBil.setModel(l);
                        brik = BRIK_AARGANG;
                        break;
                    }
                    case BRIK_AARGANG: {
                        nyBil.setAargang(Integer.parseInt(l));
                        brik = BRIK_REGNR;
                        garage.add(nyBil);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Hey makker - der mangler en fil");
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private static void visGarage(ArrayList<Bil> garage)  {
        for (int i = 0; i < garage.size() ; i++) {
            System.out.println(garage.get(i).visBil());
        }
    }

    private static void gemGarage(ArrayList<Bil> garage){

        PrintWriter outputStream = null;

        try {

            outputStream = new PrintWriter(new FileWriter("garagefil.txt"));

            for (int i = 0; i < garage.size(); i++) {
                outputStream.println(garage.get(i).getRegNr());
                outputStream.println(garage.get(i).getMaerke());
                outputStream.println(garage.get(i).getModel());
                outputStream.println(garage.get(i).getAargang());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

}

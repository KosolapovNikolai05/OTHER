package Kosolapov.Nikolai;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void findUniqueSymptom (String userInputValue , HashSet<String>[] diseases) {
        HashSet<String> firstDiseaseWithUserSymptom = new HashSet<>();
        for (int inDisease = 0; inDisease < diseases.length; inDisease++) {
            if (diseases[inDisease].contains(userInputValue)) {
                if (firstDiseaseWithUserSymptom.size() == 0) {
                    firstDiseaseWithUserSymptom = diseases[inDisease];
                }
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
        Iterator <String> findUniqueIterator = firstDiseaseWithUserSymptom.iterator();
        while (findUniqueIterator.hasNext()) {
            for (HashSet<String> disease : diseases) {
                if (disease != firstDiseaseWithUserSymptom) {
                    if (disease.contains(findUniqueIterator.next())) {
                        findUniqueIterator.next();
                    }
                }
            }
            System.out.println("У вас есть " + findUniqueIterator.next() + " ?");
        }
    }


    public static void main(String[] args) {

        System.out.print("Введите симптом: ");
        Scanner userInput = new Scanner(System.in);
        String userInputValue = userInput.nextLine();

        HashSet<String> Flu = new HashSet<>();
        Flu.add("Головная боль");
        Flu.add("Насморк");
        Flu.add("Боль в мышцах");
        Flu.add("Нестабильное сердцебиение");
        Flu.add("Учащение дыхания");

        HashSet <String> SarsCov19 = new HashSet<>();
        SarsCov19.add("Головная боль");
        SarsCov19.add("Насморк");
        SarsCov19.add("Боль в мышцах");
        SarsCov19.add("Бледность кожи");
        SarsCov19.add("Тяжесть в грудной клетке");

        HashSet <String> ORVI = new HashSet<>();
        ORVI.add("Головная боль");
        ORVI.add("Насморк");
        ORVI.add("Боль в мышцах");
        ORVI.add("Учащение дыхания");
        ORVI.add("Головокружение");
        ORVI.add("Тошнота");
        ORVI.add("Диарея");

        HashSet[] symptoms = {Flu , SarsCov19 , ORVI};

        findUniqueSymptom(userInputValue , symptoms);
    }
}

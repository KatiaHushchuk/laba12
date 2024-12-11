package ua.edu.ucu.apps.task1;

public class ATM {

    Section first;

    public ATM() {
        this.first = new Section_500();

        Section_200 section_200 = new Section_200();
        Section_100 section_100 = new Section_100();
        Section_50 section_50 = new Section_50();
        Section_10 section_10 = new Section_10();
        Section_5 section_5 = new Section_5();
        first.setNext(section_200.setNext(section_100.setNext(section_50.setNext(section_10.setNext(section_5)))));
    }

    public void getMeMoney(int amount) {
        first.process(amount);
    }
    
}

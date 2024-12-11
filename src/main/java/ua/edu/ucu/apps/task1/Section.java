package ua.edu.ucu.apps.task1;

public abstract class Section {
    private int denamination;
    private Section next;

    public Section(int denamination) {
        this.denamination = denamination;
    }
    
    public Section setNext(Section next) {
        this.next = next;
        return this;
    }

    private boolean hasNext() {
        return next != null;
    }

    public void process(int amount) {
        int left = amount % denamination;
        if (left != 0) {
            if (hasNext()) {
                next.process(left);
            }
        }
        if (amount/denamination > 0) {
            System.out.println("Denomination: " + denamination + 
                                " Quantity: " + amount/denamination);
        }
    }
}

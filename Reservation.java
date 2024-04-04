import java.util.ArrayList;

public class Reservation implements Comparable<Reservation>{
    private String guestName;
    private String phoneNumber;
    private int totPersons;
    private Day dateDine;
    private Day dateRequest;
    private int ticketCode;
    private boolean status;

    public Reservation(String guestName, String phoneNumber, int totPersons, String sDateDine) {
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.totPersons = totPersons;
        this.dateDine = new Day(sDateDine);
        this.dateRequest = SystemDate.getInstance().clone();
        this.ticketCode = BookingTicketController.takeTicket(this.dateDine);
        this.status = false;
    }


    public static void list(ArrayList<Reservation> reservations) {
        
        //Learn: "-" means left-aligned
        System.out.printf("%-13s%-11s%-14s%-12s%-12s%-10s%s\n", "Guest Name", "Phone", "Request Date", "Dining Date", "and Ticket", "#Persons", "Status");
        for (Reservation r: reservations) {
            String ticket = "(Ticket " + r.getTicketCode() + ")";
            String status;
            if (!r.status) {
                status = "Pending";
            }
            else {
                status = "Confirmed";
            }
            System.out.printf("%-13s%-11s%-14s%-12s%-12s%5d%s\n", 
            r.guestName, r.phoneNumber, r.dateRequest, r.dateDine, ticket, r.totPersons);
        }
    }

    @Override
    public int compareTo(Reservation another) {
        //return dateDine.toString().compareTo(r.dateDine.toString());
        if (this.guestName.equals(another.guestName)) {
            return 0;
        }
        else if (this.guestName.compareTo(another.guestName) > 0) {
            return 1;
        }
        else {
            return -1;
        }
    
    
    }

    public int getTicketCode() {
        return ticketCode;
    }

    public Day getDateDine() {
        return dateDine;
    }

    public void setStatus() {
        status = true;
    }
}


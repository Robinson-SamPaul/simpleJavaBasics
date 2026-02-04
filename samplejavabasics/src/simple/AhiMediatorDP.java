package simple;

import java.util.ArrayList;
import java.util.List;

/*
 * Pattern “type” (Structural / Behavioral / Creational) is NOT decided by code shape.
 * It is decided by what problem the pattern addresses.
 * 
 * Composite answers:
 * 		How do I represent part–whole relationships? → Structural
 * Mediator answers:
 * 		How do objects communicate without tight coupling? → Behavioral
 */
public class AhiMediatorDP {
    public static void main(String[] args) {
        WhatsAppMediator whatsAppMediator = new WhatsApp();

        MobilePhone mobile1 = new ConcreteMobile(whatsAppMediator, "Alice's MobilePhone");
        MobilePhone mobile2 = new ConcreteMobile(whatsAppMediator, "Bob's MobilePhone");
        MobilePhone mobile3 = new ConcreteMobile(whatsAppMediator, "Charlie's MobilePhone");
        MobilePhone mobile4 = new ConcreteMobile(whatsAppMediator, "Diana's MobilePhone");

        whatsAppMediator.addMobile(mobile1);
        whatsAppMediator.addMobile(mobile2);
        whatsAppMediator.addMobile(mobile3);
        whatsAppMediator.addMobile(mobile4);

        mobile1.send("Hi everyone!");
    }
}
abstract class MobilePhone {
    protected WhatsAppMediator mediator;
    protected String name;

    public MobilePhone(WhatsAppMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}
class ConcreteMobile extends MobilePhone {

    public ConcreteMobile(WhatsAppMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + ": Sending Message = " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + ": Received Message = " + message);
    }
}
interface WhatsAppMediator {
    void sendMessage(String message, MobilePhone mobile);
    void addMobile(MobilePhone mobile);
}
class WhatsApp implements WhatsAppMediator {
    private List<MobilePhone> mobiles;

    public WhatsApp() {
        this.mobiles = new ArrayList<>();
    }

    @Override
    public void addMobile(MobilePhone mobile) {
        this.mobiles.add(mobile);
    }

    @Override
    public void sendMessage(String message, MobilePhone mobile) {
        for (MobilePhone m : mobiles) {
            // message should not be received by the mobile sending it
            if (m != mobile) {
                m.receive(message);
            }
        }
    }
}


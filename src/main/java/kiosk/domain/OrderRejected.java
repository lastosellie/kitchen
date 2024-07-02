package kiosk.domain;

import java.time.LocalDate;
import java.util.*;
import kiosk.domain.*;
import kiosk.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderRejected extends AbstractEvent {

    private Long id;
    private String tableId;
    private String menuId;
    private String munuState;
    private String menuPrice;

    public OrderRejected(Kitchen aggregate) {
        super(aggregate);
    }

    public OrderRejected() {
        super();
    }
}
//>>> DDD / Domain Event

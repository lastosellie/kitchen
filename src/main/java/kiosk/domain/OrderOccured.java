package kiosk.domain;

import java.util.*;
import kiosk.domain.*;
import kiosk.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class OrderOccured extends AbstractEvent {

    private Long id;
    private String tableId;
    private String menuId;
    private String menuStatus;
    private String menuPrice;
    private String menuName;
}

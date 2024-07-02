package kiosk.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import kiosk.KitchenApplication;
import lombok.Data;

@Entity
@Table(name = "Kitchen_table")
@Data
//<<< DDD / Aggregate Root
public class Kitchen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tableId;

    private String menuId;

    private String munuState;

    private String menuPrice;

    @PostPersist
    public void onPostPersist() {
        // OrderAccepted orderAccepted = new OrderAccepted(this);
        // orderAccepted.publishAfterCommit();

        // OrderRejected orderRejected = new OrderRejected(this);
        // orderRejected.publishAfterCommit();
    }

    public static KitchenRepository repository() {
        KitchenRepository kitchenRepository = KitchenApplication.applicationContext.getBean(
            KitchenRepository.class
        );
        return kitchenRepository;
    }

    //<<< Clean Arch / Port Method
    public static void orderOccur(OrderOccured orderOccured) {
        //implement business logic here:

        /** Example 1:  new item 
        Kitchen kitchen = new Kitchen();
        repository().save(kitchen);

        OrderAccepted orderAccepted = new OrderAccepted(kitchen);
        orderAccepted.publishAfterCommit();
        OrderRejected orderRejected = new OrderRejected(kitchen);
        orderRejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderOccured.get???()).ifPresent(kitchen->{
            
            kitchen // do something
            repository().save(kitchen);

            OrderAccepted orderAccepted = new OrderAccepted(kitchen);
            orderAccepted.publishAfterCommit();
            OrderRejected orderRejected = new OrderRejected(kitchen);
            orderRejected.publishAfterCommit();

         });
        */
        Kitchen kitchen = new Kitchen();
        kitchen.setId(orderOccured.getId());
        kitchen.setTableId(orderOccured.getTableId());
        kitchen.setMenuId(orderOccured.getMenuId());
        kitchen.setMenuPrice(orderOccured.getMenuPrice());
        
        String menuId = orderOccured.getMenuId();
        if (menuId.contains("1") || menuId.contains("3")) {
            kitchen.setMunuState("조리중");
            repository().save(kitchen);

            System.out.println("orderAccepted ★★★★★★★★★★★★★★★");
            OrderAccepted orderAccepted = new OrderAccepted(kitchen);
            orderAccepted.publishAfterCommit();
        } else {
            System.out.println("orderRejected ★★★★★★★★★★★★★★★");
            kitchen.setMunuState("취소됨");
            OrderRejected orderRejected = new OrderRejected(kitchen);
            orderRejected.publishAfterCommit();
        }
        


    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

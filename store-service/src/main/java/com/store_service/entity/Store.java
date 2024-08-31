package com.store_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STORE_DTLS")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORE_ID")
    private Long id;

    @Column(name = "STORE_NAME")
    private String name;
    
    @Column(name = "STORE_ADDRESS")
    private String address;
    
    @Column(name = "STORE_LATITUDE")
    private double latitude;
    
    @Column(name = "STORE_LONGITUDE")
    private double longitude;
    
  //  @ManyToMany(mappedBy = "stores",fetch = FetchType.LAZY)
   // @ManyToMany(mappedBy = "stores")
   // @JsonBackReference
   // private Set<Dealer> dealers;
    
    public Store(Long storeId, String storeName, boolean storeStatus, String storeAddress, double storeLat, double storeLong/*, Dealer dealer*/) {
        this.id = storeId;
        this.name = storeName;
        this.address = storeAddress;
        this.latitude = storeLat;
        this.longitude = storeLong;
     //   this.dealers = Set.of(dealer);
    }
  
  
}
package com.example.ecommerce.shipping.model;

import com.example.ecommerce.basket.model.Basket;

import javax.persistence.*;


@Entity
@Table(name="shipping_address")
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "district")
    private String district;

    @Column(name = "province")
    private String province;

    @Column(name="tel")
    private String tel;

    @OneToOne(mappedBy = "shippingAddress")
    private Basket basket;


    public ShippingAddress() {
    }

    public ShippingAddress(String address, String postcode, String district, String province, String tel) {
        this.address = address;
        this.postcode = postcode;
        this.district = district;
        this.province = province;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

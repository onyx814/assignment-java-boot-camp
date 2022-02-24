package com.example.ecommerce.member.model;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "address1")
    private String address1;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "district")
    private String district;

    @Column(name = "province")
    private String province;

    @Column(name="tel")
    private String tel;

    @Column(name="default_shipping")
    private String defaultShipping;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", referencedColumnName = "id" ,nullable = false)
    private User user;


    public Address() {
    }


    public Address(String address1, String postcode, String district, String province, String tel, String defaultShipping, User user) {
        this.address1 = address1;
        this.postcode = postcode;
        this.district = district;
        this.province = province;
        this.tel = tel;
        this.defaultShipping = defaultShipping;
        this.user = user;
    }

    public Address(int id, String address1, String postcode, String district, String province, String tel, String defaultShipping, User user) {
        this.id = id;
        this.address1 = address1;
        this.postcode = postcode;
        this.district = district;
        this.province = province;
        this.tel = tel;
        this.defaultShipping = defaultShipping;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
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

    public String getDefaultShipping() {
        return defaultShipping;
    }

    public void setDefaultShipping(String defaultShipping) {
        this.defaultShipping = defaultShipping;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

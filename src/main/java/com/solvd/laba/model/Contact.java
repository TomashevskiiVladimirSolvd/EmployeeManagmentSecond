package com.solvd.laba.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Contact {
    @JsonProperty("id")
    @XmlElement
    private Long id;
    @JsonProperty("email")
    @XmlElement
    private String email;
    @JsonProperty("phone")
    @XmlElement
    private String phone;

    public Contact() {
    }

    ;

    public Contact(Long id, String email, String phone) {
        this.id = id;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id && Objects.equals(email, contact.email) && Objects.equals(phone, contact.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phone);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

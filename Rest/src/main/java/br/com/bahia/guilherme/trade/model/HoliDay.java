/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "holiday_month_day") 
public class HoliDay {

    @Id
    @Column(name = "day")
    private Integer day;
    
    @Column(name = "month")
    private Integer month;

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.month);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HoliDay other = (HoliDay) obj;
        if (!Objects.equals(this.day, other.day)) {
            return false;
        }
        if (!Objects.equals(this.month, other.month)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HoliDay{day=" + day + ", month=" + month + '}';
    }

    
}

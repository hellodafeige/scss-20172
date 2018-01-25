package org.forten.scss.entity;

import org.forten.utils.common.DateUtil;
import org.forten.utils.common.NumberUtil;
import org.forten.utils.common.StringUtil;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="sys_params")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "sysCache")
public class SysParams implements Serializable {
    @Id
    private String id;
    @Column
    private String value;

    public SysParams() {
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIntValue(){
        if(StringUtil.hasText(value)){
            return NumberUtil.parseNumber(value,Integer.class);
        }else{
            return 0;
        }
    }

    public boolean getBooleanValue(){
        if(StringUtil.hasText(value)){
            return Boolean.parseBoolean(value);
        }else{
            return false;
        }
    }

    public Date getDateValue(String pattern){
        if(StringUtil.hasText(value)){
            return DateUtil.convertStringToDate(value,pattern);
        }else{
            throw new IllegalStateException("日期字符串取值非法");
        }
    }

    public Date getDateValue(){
        return getDateValue("yyyy-MM-dd");
    }

    public Date getTimeValue(){
        return getDateValue("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysParams sysParams = (SysParams) o;

        return id != null ? id.equals(sysParams.id) : sysParams.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SysParams{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

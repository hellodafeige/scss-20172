package org.forten.scss.bo;

import org.forten.dao.HibernateDao;
import org.forten.scss.entity.SysParams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysParamsBo {
    @Resource
    private HibernateDao dao;

    @Transactional(readOnly = true)
    public List<SysParams> queryAll() {
        List<SysParams> list = dao.findAll(SysParams.class);
        return list;
    }

    @Transactional(readOnly = true)
    public String getValue(String key) {
        SysParams sp = dao.loadById(SysParams.class, key);
        return sp.getValue();
    }

    @Transactional(readOnly = true)
    public int getIntValue(String key) {
        SysParams sp = dao.loadById(SysParams.class, key);
        return sp.getIntValue();
    }

    @Transactional(readOnly = true)
    public boolean getBooleanValue(String key) {
        SysParams sp = dao.loadById(SysParams.class, key);
        return sp.getBooleanValue();
    }

    @Transactional(readOnly = true)
    public Date getDateValue(String key) {
        SysParams sp = dao.loadById(SysParams.class, key);
        return sp.getDateValue();
    }

    @Transactional(readOnly = true)
    public Date getDateValue(String key, String pattern) {
        SysParams sp = dao.loadById(SysParams.class, key);
        return sp.getDateValue(pattern);
    }

    @Transactional(readOnly = true)
    public Date getTimeValue(String key) {
        SysParams sp = dao.loadById(SysParams.class, key);
        return sp.getTimeValue();
    }
}

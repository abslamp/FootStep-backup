package demo.service.impl;

import demo.domain.Prp;
import demo.domain.PrpMapper;
import demo.service.PrpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LZMA on 2017/2/19.
 */

@Service
public class PrpServiceImpl implements PrpService {
    private static int pageSize;

    @Autowired
    private PrpMapper prpMapper;

    @Override
    public List<Prp> query(Prp cond, int page) {
        int from = (page-1)*pageSize;
        int to = from+pageSize;
        return prpMapper.find(cond, from, to);
    }

    @Override
    public int getCount(Prp cond) {
        return prpMapper.getCount(cond);
    }

    @Override
    public Prp queryById(Long id) {
        Prp prp= prpMapper.findById(id);
        return prpMapper.findById(id);
    }


    @Override
    public int update(Long id, Prp replace) {
        return prpMapper.update(id,replace);
    }
}

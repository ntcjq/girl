package com.example.girl.service;


import com.example.girl.dao.GirlDao;
import com.example.girl.entity.Girl;
import com.example.girl.enums.ResultEnum;
import com.example.girl.exception.GirlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GirlService {


    @Autowired
    private GirlDao girlDao;


    public List<Girl> findAll(){
        return girlDao.findAll();
    }

    public Girl findOne(Integer id){
        return girlDao.findOne(id);
    }

    public List<Girl> findByAge(Integer id){
        return girlDao.findByAge(id);
    }


    /**
     * jpa的新增和更新都是save，根据有没有id或者id是否存在来判断。有id且数据库里存在则更新，否则新增
     * @param girl
     * @return
     */
    @Transactional
    public Girl save(Girl girl){//throws Exception{
        return girlDao.save(girl);
    }

    public void delete(Integer id){
        girlDao.delete(id);
    }





    /**
     * 事务测试
     * @param girl
     * @return
     */
    @Transactional
    public Girl tx(Girl girl){//throws Exception{
        girl = girlDao.save(girl);
//        if(girl.getAge() > 100){
//            throw new Exception("事务失效,非运行时异常，spring事务不回滚");
//        }
        if(girl.getAge() > 100){
            throw new GirlException("事务不失效，运行时异常，spring事务回滚");
//           throw new GirlException(ResultEnum.DATABASE_EXCEPTION);
        }
        return girl;
    }
}

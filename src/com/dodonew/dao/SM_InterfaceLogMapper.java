package com.dodonew.dao;


import com.dodonew.model.SM_InterfaceLog;
import org.springframework.stereotype.Repository;

@Repository("sm_interfaceLogMapper")
public interface SM_InterfaceLogMapper {
    int insert(SM_InterfaceLog record) throws Exception;
}
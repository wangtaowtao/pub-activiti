package com.eyaoshun.activiti.oa.dao;

import java.util.List;

import com.eyaoshun.activiti.oa.entity.Employee;
import com.eyaoshun.activiti.oa.entity.Leavebill;

public interface ILeavebillMapper
{
    List<Leavebill> findLeavebillListByUserid(Employee employee);
    
    void saveLeavebill(Leavebill leavebill);
    
    Leavebill findLeavebillById(Long id);
    
    void updateLeavebill(Leavebill leavebill);
    
    void deleteLeavebillById(Long id);
    
    List<Leavebill> selectLeavebillList();
    
    void updateLeavebillState(Leavebill leavebill);
    
}
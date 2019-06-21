package com.eyaoshun.activiti.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyaoshun.activiti.oa.dao.ILeavebillMapper;
import com.eyaoshun.activiti.oa.entity.Employee;
import com.eyaoshun.activiti.oa.entity.Leavebill;
import com.eyaoshun.activiti.oa.service.ILeavebillService;

@Service("leavebillService")
public class LeavebillServiceImpl implements ILeavebillService {

	@Autowired
	private ILeavebillMapper iLeavebillDao;

	public void setLeavebillDao(ILeavebillMapper leavebillDao) {
		this.iLeavebillDao = leavebillDao;
	}

	/** 查询自己的请假单的信息 */
	public List<Leavebill> findLeavebillListByUserid(Employee employee) {
		List<Leavebill> list = iLeavebillDao.findLeavebillListByUserid(employee);
		return list;
	}

	/** 保存请假单 */
	@Override
	public void saveLeavebill(Leavebill leavebill) {
		System.out.println(leavebill);
		// 获取请假单ID
		Long id = leavebill.getId();
		/** 新增保存 */
		if (id == null) {
			// 2：保存请假单表，添加一条数据
			iLeavebillDao.saveLeavebill(leavebill);
		}
		/** 更新保存 */
		else {
			// 1：执行update的操作，完成更新
			iLeavebillDao.updateLeavebill(leavebill);
		}

	}

	/** 使用请假单ID，查询请假单的对象 */
	@Override
	public Leavebill findLeavebillById(Long id) {
		Leavebill bill = iLeavebillDao.findLeavebillById(id);
		return bill;
	}

	/** 使用请假单ID，删除请假单 */
	@Override
	public void deleteLeavebillById(Long id) {
		iLeavebillDao.deleteLeavebillById(id);
	}

	@Override
	public List<Leavebill> selectLeavebillList() {
		List<Leavebill> billList = iLeavebillDao.selectLeavebillList();
		return billList;
	}

	@Override
	public void updateLeavebillState(Leavebill leavebill) {
		iLeavebillDao.updateLeavebillState(leavebill);
	}
}

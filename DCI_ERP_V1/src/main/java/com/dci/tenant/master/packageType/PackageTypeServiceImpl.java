package com.dci.tenant.master.packageType;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;
@Service
public class PackageTypeServiceImpl implements PackageTypeService{
	@Autowired
	PackageTypeDao packageTypeDao;
	@Override
	public PackageTypeResultBean selectivity() throws Exception {
		
		return packageTypeDao.selectivity();
	}
	@Override
	public List<PackageTypeBean> getList() {
		
		return packageTypeDao.getList();
	}

	@Override
	public Object save(PackageTypeBean bean) throws CustomException {
		
		return packageTypeDao.save(bean);
	}

	@Override
	public PackageTypeBean edit(int rowid) throws Exception {
		
		return packageTypeDao.edit(rowid);
	}

	@Override
	public boolean update(PackageTypeBean update) throws Exception {
		
		return packageTypeDao.update(update);
	}

	@Override
	public boolean delete(int rowid) throws Exception {
		
		return packageTypeDao.delete(rowid);
	}

	
}

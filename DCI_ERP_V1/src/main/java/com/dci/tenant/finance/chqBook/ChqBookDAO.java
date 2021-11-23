package com.dci.tenant.finance.chqBook;

import java.util.List;

public interface ChqBookDAO {

	List<ChqBookBean> getStatusList() throws Exception;

	List<ChqBookBean> getChqBookList() throws Exception;

	List<ChqBookBean> getChqBookListdummy() throws Exception;

	boolean saveChqBook(ChqBookBean objChqBookBean) throws Exception;

	boolean updateChqBook(ChqBookBean objChqBookBean) throws Exception;

	ChqBookResultBean editChqBook(int chqBookId) throws Exception;

	boolean deleteChqBook(int chqBookId) throws Exception;

	List<ChqBookBean> searchList(ChqBookBean objChqBookBean) throws Exception;

}

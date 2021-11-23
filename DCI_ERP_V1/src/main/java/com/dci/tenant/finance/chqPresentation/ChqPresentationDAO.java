package com.dci.tenant.finance.chqPresentation;

import java.util.List;

public interface ChqPresentationDAO {

	List<ChqPresentationBean> getPresentationHdrList(int limit, int offset);

	boolean savePresentation(ChqPresentationBean chqPresentationBean);

	List<ChqPresentationBean> getRealisationList(int limit, int offset);

	List<ChqPresentationBean> getchequelist();

	List<ChqPresentationBean> getPresentationList();

	boolean saveRealisation(ChqPresentationBean chqPresentationBean);

	ChqPresentationBean getCreditNoteForEdit(String prCode);

	boolean updatePresentation(ChqPresentationBean chqPresentationBean);

	boolean deletePresentation(String prCode);

	List<ChqPresentationBean> getPresentationListEdit();

	List<ChqPresentationBean> getChqStatusRprtList(String customer, String company);

}

/**
 *
 */
package com.dci.tenant.user;

import java.util.Comparator;

/**
 * @author paragon
 *
 */
public class FormMasterBeanComparator implements Comparator<FormMasterBean> {

	@Override
	public int compare(FormMasterBean o1, FormMasterBean o2) {
		return o1.getDisplayOrder() - o2.getDisplayOrder();
	}
}

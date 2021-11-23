package com.dci.tenant.finance.transferReceived;

public class TransferReceivedQueryUtil {

	public static final String GET_RECEIVED_LIST = "select stock_received_id receivedId,stock_received_number receivedNo,rcvd.stock_transfer_id transferId,stock_transfer_number transferNo,to_char(stock_transfer_date,'dd/mm/yyyy') transferDate,s.location_name sourceLocName,d.location_name destLocName,to_char(stock_received_date,'dd/mm/yyyy') receivedDate,rcvd.received_by receivedByCode,first_name receivedByName from stock_transfer_received rcvd left join stock_transfer st on rcvd.stock_transfer_id = st.stock_transfer_id left join employee e on e.employee_id =rcvd.received_by left join location s on s.location_id=source_location left join location d on  d.location_id=destination_location where stock_received_number like ? order by stock_received_id desc";

	public static final String SAVE_TRANS_RECIVED = "INSERT INTO stock_transfer_received( stock_received_number, stock_transfer_id, stock_received_date, received_by, received_note,company_id) VALUES (?, ?, to_date(?,'dd/mm/yyyy'), ?, ?,?) returning stock_received_id";

	public static final String SAVE_TRANS_RECIVED_DTL = "INSERT INTO stock_transfer_received_detail(stock_received_id, item_id, transfer_qty, received_qty, pending_qty) VALUES (?, ?, ?, ?, ?)";

	public static final String UPDATE_TRANSFER_DTL = "update stock_transfer_detail set pending_qty =? where stock_transfer_id =? and item_id =?";

	public static final String UPDATE_TRANSFER_STATUS = "update stock_transfer set status =? where stock_transfer_id =? ";

	public static final String HEADER_TRANSFER_RECEIVE_VIEW = "select stock_received_number receivedNo,coalesce(company_name,'') companyName,to_char(stock_received_date,'DD/MM/YYYY') receivedDate,str.received_by receivedByName,received_note receivedNote," + " stock_transfer_number transferNo,coalesce(requested_by,'') requestedBy,to_char(stock_transfer_date,'DD/MM/YYYY')transferDate," + " coalesce(s.location_id,0) sourceLocId,coalesce(s.location_name,'') sourceLocName,coalesce(d.location_id,0) destLocId,coalesce(d.location_name,'') destLocName"
			+ " from stock_transfer_received str" + " inner join stock_transfer st on str.stock_transfer_id = st.stock_transfer_id" + " left join location s on s.location_id=source_location left join location d on  d.location_id=destination_location left join" + " purchase_requisition pr on pr.purchase_requisition_id = st.purchase_requisition_id left join company c on str.company_id = c.company_id" + " where stock_received_id =?";

	public static String GET_STOCK_NUMBER = "SELECT CASE WHEN MAX(stock_received_number) IS NULL  THEN 'CTR0001' ELSE rpad(MAX(stock_received_number),3,'CTR')||  lpad(cast(cast((SUBSTRING(MAX(stock_received_number),4)) as int)+1  as text),4,'0') END as consignTransReceiveNo  FROM stock_transfer_received where stock_received_number like ?";

	public static final String DETAIL_TRANSFER_RECEIVE_VIEW = " select strd.item_id itemId,item.item_id as id,concat(item.item_code,' - ',item.item_name) as text,item_code as itemCode,item_name as itemName,transfer_qty as transferQty,received_qty receivedQty,pending_qty pendingQty from stock_transfer_received_detail strd inner join item_new item on item.item_id=strd.item_id  where strd.stock_received_id =?";

}

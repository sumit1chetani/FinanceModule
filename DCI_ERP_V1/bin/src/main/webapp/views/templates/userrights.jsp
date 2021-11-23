<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set scope="session" var="add" value="A"></c:set>
<c:set scope="session" var="approve" value="AU"></c:set>
<c:set scope="session" var="advice" value="C"></c:set>
<c:set scope="session" var="admin_unlock" value="AUL"></c:set>
<c:set scope="session" var="admin_add_update" value="AUA"></c:set>
<c:set scope="session" var="add_update" value="AM"></c:set>
<c:set scope="session" var="correction_approve" value="CA"></c:set>
<c:set scope="session" var="delete" value="D"></c:set>
<c:set scope="session" var="df_app" value="DA"></c:set>
<c:set scope="session" var="invoice_alloc" value="IA"></c:set>
<c:set scope="session" var="loc_flag" value="L"></c:set>
<c:set scope="session" var="modify" value="M"></c:set>
<c:set scope="session" var="search" value="S"></c:set>
<c:set scope="session" var="unlock" value="U"></c:set>
<c:set scope="session" var="view" value="V"></c:set>
<c:set scope="session" var="upload" value="UP"></c:set>
<c:set scope="session" var="export" value="EX"></c:set>
<c:set scope="session" var="print" value="P"></c:set>
<c:set scope="session" var="send_mail" value="SM"></c:set>
<c:set scope="session" var="delete_all" value="= DAL"></c:set>
<%-- <c:set scope="session" var="add">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.add')" />
</c:set>
<c:set scope="session" var="approve">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.approve')" />
</c:set>
<c:set scope="session" var="advice">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.advice')" />
</c:set>
<c:set scope="session" var="admin_unlock">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.admin_unlock')" />
</c:set>
<c:set scope="session" var="admin_add_update">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.admin_add_update')" />
</c:set>
<c:set scope="session" var="add_update">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.add_update')" />
</c:set>
<c:set scope="session" var="correction_approve">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.correction_approve')" />
</c:set>
<c:set scope="session" var="delete">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.delete')" />
</c:set>
<c:set scope="session" var="df_app">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.df_app')" />
</c:set>
<c:set scope="session" var="invoice_alloc">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.invoice_alloc')" />
</c:set>
<c:set scope="session" var="loc_flag">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.loc_flag')" />
</c:set>
<c:set scope="session" var="modify">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.modify')" />
</c:set>
<c:set scope="session" var="search">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.search')" />
</c:set>
<c:set scope="session" var="unlock">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.unlock')" />
</c:set>
<c:set scope="session" var="view">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.view')" />
</c:set>
<c:set scope="session" var="upload">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.upload')" />
</c:set>
<c:set scope="session" var="export">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.export')" />
</c:set>
<c:set scope="session" var="print">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.print')" />
</c:set>
<c:set scope="session" var="send_mail">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.send_mail')" />
</c:set>
<c:set scope="session" var="delete_all">
 <spring:eval expression="@propertyConfigurer.getProperty('user.rights.form.delete_all')" />
</c:set> --%>
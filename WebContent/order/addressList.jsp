<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<select name="user.id">
	  <option value="">请选择</option>
	<s:iterator value="#session.addressList">
	  <option value="<s:property value="id"/>" ><s:property value="address"/></option>
	</s:iterator>
</select>
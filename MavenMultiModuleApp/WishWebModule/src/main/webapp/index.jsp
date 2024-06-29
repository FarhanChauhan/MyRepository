<%@ page import="org.WishServiceModule.WishMessageService"%>
<h1 style='color:red; text-align: service'>
	hello
	<% WishMessageService wish  =new WishMessageService() %>
	<%= wish.wishMsg("farhan chauhan") %>
</h1>
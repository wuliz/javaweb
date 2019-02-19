package com.wlz.javaweb.chapterFour_Jsp;

public class Test01 {
	public static void main(String[] args) {
		//为什么要有jsp?
		/*
		 * 尽管servlet很强大，可以处理业务逻辑和页面展示，但是，页面展示在servlet中十分繁琐。
		 * jsp将页面展示和逻辑处理分离，jsp可以在html中写Java代码，尽管它看起来和html一致，但本质是一个servlet，不过是内部将输出隐藏了。
		 * 
		 * 第一个jsp
		 * jsp语法：类成员声明<%! %>、表达式<%= %>、代码块<% %>
		 * 示例：myjsp.jsp
		 * calender.jsp
		 *指令：格式<%@ >
		 *page指令:主要属性，language、import、pageEncoding、contentType、errorPage
		 *tablib指令:在当前页面导入自定义标签（JSTL标准标签库）；<%@ taglib uri="标签地址"%>
		 *jsp页面中不应该用Java代码，那响应的逻辑怎么表示，就用标签
		 *include指令，包含页面部分<%@ include file="相对或绝对地址"%>
		 *
		 *jsp中的9大内置对象，只能在表达式或代码块中使用
		 *application,request,session.response,out,pageContext,config,exception,page 
		 *
		 *JSP自定义标签
		 *如何自定义标签：实现Tag类或继承TagSupport类
		 *定义tld文件配置自定义的标签
		 *调用自定义标签
		 *示例（HelloTag.java,lib下的tld文件，hello.jsp）
		 *
		 *JSTL jsp标准标签库的使用
		 *第一：引入标准标签库
		 *第二：使用
		 *主要有 <c:out> <c:set>(把变量值设置到JSP内置对象中,或者设置到JAVABEAN属性中)<c:choose> <c:if>等等，详情请查看api
		 *EL表达式的使用
		 *访问的范围：寻找值顺序：page–》request–》session–》application(局部变量不能用el表达式访问)
		 *语法格式：${name};
		 *
		 *MVC架构
		 *对应web项目的目录结构：
		 *com.wlz.servlet
		 *com.wlz.dao
		 *com.wlz.bean
		 *com.wlz.dao.daoimpl
		 *com.wlz.util
		 *jsp资源文件夹
		 *示例：mvc_jsp
		 *
		 *mvc的完整示例
		 *一个收藏网址的小系统（实现了增删改查）
		 *示例（mvc_collect包）
		 */
	}
}

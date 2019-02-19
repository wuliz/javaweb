package com.wlz.javaweb.chapterThree_Servlet;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Servlet
		 */
		/*
		 * Servlet全称Java
		 * Servlet，是一个基于java技术的Web组件，运行在服务器端，由Servlet容器所管理，用于生成动态的内容
		 * 。狭义Servlet是指Java语言实现的一个接口
		 * ，广义的Servlet是指任何实现了这个Servlet接口的类。【主要处理客户端传过来的HTTP请求，并解析返回一个响应】
		 * Servlet是JavaEE定义的规范，Java实现了接口和一些类。它是运行在服务器端的Java程序，用于生成动态的web内容，
		 * 而不同的服务器对servlet会有不同的实现，一般来说，服务器内部会有一个servlet的容器来管理servlet。
		 * 
		 *第一个Servlet:HelloServlet.java
		 *(注意：)web项目要在服务器运行，先要配置到tomcat的webapp中，需要web.xml文件，配置web项目的基本信息。
		 *
		 *doGet,doPost的调用，如果Servlet中有service方法，则不会调用doGet和doPost
		 *
		 */

		/*
		 * Servlet生命周期
		 * 实例化
		 * 初始化
		 * 请求处理
		 * 服务终止
		 */
		
		/*
		 * 设置初始化参数
		 * 局部初始化参数:当启动这个servlet的时候，可以获得获得它的初始化参数
		 * 初始化参数在web.xml中设置，在servlet的init()方法中获得
		 * 全部初始化参数：当任何一个servlet创建的时候，可以获得全局初始化参数
		 * 全局初始化参数，是被所以servlet共享的，在通过上下文对象（ServletContext）获得。
		 * 初始化参数不能再构造方法中获得。
		 */
		
		/*
		 * 请求转发和请求重定向的区别
		 * 请求转发：地址栏不改变，可以将本次请求的参数传递过去，项目内转发（有req发起请求转发）
		 * 重定向：地址栏改变，不能将本次请求的res,和req传过去，可以定位到项目外（由res发起请求转发）
		 */
		
		/*
		 * 请求头
		 * 主要是获取请求头的信息
		 */
		
		/*
		 * 响应头
		 * 设置相应头的信息
		 * 打印一个报表
		 * PrintExcel.java
		 * 打印一个图片
		 * PrintJpeg.java
		 * 打印时间，设置响应头每各一段时间刷新，这就导致每隔一段时间会发送请求，服务器容易瘫痪，慎用
		 * 示例，FreshServlet.java
		 * Cookie的使用
		 * cookie的作用：由于http的响应不说持久连接的，怎么保存客户端信息，
		 * cookie的创建
		 * cookie的获取
		 * 实现自动登录功能
		 * 示例;Login.jsp,PrepareLoginServlet.java,LoginServlet.java
		 * 
		 * Session：用于服务器端保存客户端信息，用于标识客户，通过，request对象获得，一个浏览器对应一个session.可在所有servlet中访问。
		 * session示例：用户登录
		 * sessionLogin.jsp,SessionLoginServlet,welcome.jsp
		 * 
		 * Servlet中的域对象
		 * request:一次请求
		 * session:浏览器和服务器的对应关系
		 * servletContext:web全局对象
		 * 示例：TestScoptServlet.java,ResultServlet.java
		 * 
		 * Filter:位于客户端与请求资源之间，起到过滤作用
		 * 常用于session管理，权限验证，日志记录，字符编码转换
		 * 示例：EncodingFilter.java（权限验证和字符编码）
		 */
		
		
	}

}

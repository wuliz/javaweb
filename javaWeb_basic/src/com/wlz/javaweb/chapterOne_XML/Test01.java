package com.wlz.javaweb.chapterOne_XML;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 掌握XML的概念
		 * 掌握xml的语法，定义xml
		 * 掌握dtd约束
		 * 掌握schema约束
		 */
		
		/*
		 * 1.xml是什么
		 * 1.1为什么需要xml:xml用于保存现实生活中具有树状关系的数据结构
		 * xml的概念：Extensible markup language可扩展标记语言，所谓可扩展，用户可以按照xml规则自定义标记
		 * 示例（city.xml）
		 * 1.2xml和html的比较
		 * html中的标记是用来显示数据的，xml中的数据是用来描述数据的结构和性质
		 * html不区分大小写，xml严格区分大小写
		 * html可以有多个根元素，xml有且只有一个根元素
		 * html中，空格自动过滤，而xml得空格不会删除
		 * html中得标记是预定义得，而xml中得标记是可以随便定义的
		 */
		
		/*
		 * 2.xml的语法
		 * 2.1.文档声明：表明这个xml文档遵循哪个版本的规范（<? xml 版本信息 ?>）,文档编码,独立文档声明（是否依赖与外部文档）
		 * <? xml version="1.0" encoding="utf-8" standalone="yes">
		 * 2.2元素定义
		 * xml文档中，主体内容都是由元素Element组成的。但元素应该遵从以下规范
		 * 区分大小写
		 * 元素中，不能含特殊符号，不能以数字开头
		 * 等等
		 * 2.3属性定义
		 * 为元素定义属性，或者通过子元素的方式描述相同的信息
		 * 示例：book.xml
		 * 2.4注释
		 * 不做解释
		 * 2.5特殊字符处理
		 * 不能出现：&（&amp;），<(&lt),>(&gt),"(&quot),'(&apos)
		 * 2.6CDATA区
		 * 如果文档中存在大量代码，如果一个一个去转换特殊字符是很麻烦的，所有用这个区来进行原样输出
		 * <![CDATA[代码]]>
		 * 
		 */
		/*
		 * 3DTD约束
		 * 保证xml的数据格式正确
		 * 3.2DTD约束
		 * 7
		 */
	}

}

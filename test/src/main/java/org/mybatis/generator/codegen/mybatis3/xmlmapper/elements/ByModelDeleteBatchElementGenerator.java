package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * mybatis分页查询代码生成器
 * @author yinlei
 * 2013-12-14
 */
public class ByModelDeleteBatchElementGenerator extends AbstractXmlElementGenerator {

	public ByModelDeleteBatchElementGenerator() {
		
	}

	@Override
	public void addElements(XmlElement parentElement) {
	    FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType(
                    introspectedTable.getBaseRecordType());

        XmlElement answer = new XmlElement("delete"); //$NON-NLS-1$
        answer.setComments("根据params所携带条件删除数据。");
        answer.addAttribute(new Attribute("id", //$NON-NLS-1$
                introspectedTable.getDeleteBatchStatementId()));
//        answer.addAttribute(new Attribute(
//                "resultMap", introspectedTable.getBaseResultMapId())); //$NON-NLS-1$
        answer.addAttribute(new Attribute("parameterType", parameterType.getFullyQualifiedName()));

        context.getCommentGenerator().addComment(answer);

        answer.addElement(new TextElement("delete")); //$NON-NLS-1$
        
        StringBuilder sb = new StringBuilder();
        //answer.addElement(getBaseColumnListElement());

        sb.setLength(0);
        sb.append("from "); //$NON-NLS-1$
        sb.append(introspectedTable
                .getAliasedFullyQualifiedTableNameAtRuntime());
        answer.addElement((new TextElement(sb.toString())));
        answer.addElement(getModelWhereClauseElement());
        
        if (context.getPlugins()
                .sqlMapSelectByExampleWithoutBLOBsElementGenerated(answer,
                        introspectedTable)) {
            parentElement.addElement(answer);
        }
		
	}

}

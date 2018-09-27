<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.repository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<#include "/java_imports.include">
@Service
@Transactional
public interface ${className}Repository extends JpaRepository<${className},${table.idColumn.javaType}>{


	
	@Transactional(readOnly=true)
	public Page findPage(${className}Query query) {
		return ${classNameLower}Repository.findPage(query);
	}
<#list table.columns as column>
<#assign columnNameLower = column.columnName?uncap_first>
	<#if column.unique || column.pk>
	${className} findBy${column.columnName}(${column.javaType} ${columnNameLower});
	<#else>
	List<${className}> findBy${column.columnName}(${column.javaType} ${columnNameLower});
	</#if>

</#list>
}

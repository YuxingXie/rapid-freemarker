<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<#include "/java_imports.include">
@Service
@Transactional
public class ${className}Service extends BaseService<${className},${table.idColumn.javaType}>{

	private ${className}Repository ${classNameLower}Repository;

	public void set${className}Repository(${className}Repository repository) {
		this.${classNameLower}Repository = repository;
	}

	public ${className}Repository get${className}Repository() {
		return this.${classNameLower}Repository;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(${className}Query query) {
		return ${classNameLower}Repository.findPage(query);
	}
	
<#list table.columns as column>
<#assign columnNameLower = column.columnName?uncap_first>
<#if column.unique || column.pk>
	public ${className} findBy${column.columnName}(${column.javaType} ${columnNameLower}) {
		return ${classNameLower}Repository.findBy${column.columnName}(${columnNameLower});
	}
<#else>
	public List<${className}> findBy${column.columnName}(${column.javaType} ${columnNameLower}){
		return ${classNameLower}Repository.findBy${column.columnName}(${columnNameLower});
	}
</#if>

</#list>
}

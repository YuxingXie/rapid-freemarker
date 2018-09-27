package ${basepackage}.${moduleName}.domain.controller;
<#include "/macro.include"/>
		<#include "/java_copyright.include">
		<#assign className = table.className>
		<#assign classNameLower = className?uncap_first>
		<#assign pkJavaType = table.idColumn.javaType>
import java.util.*;
import ${basepackage}.${moduleName}.controller.*;
import ${basepackage}.${moduleName}.entity.*;
import ${basepackage}.${moduleName}.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import ${baseBeanPackage}.BaseRestSpringController;
@RestController
@RequestMapping("/${className?lower_case}")
public class ${className}RestController extends BaseRestSpringController{

	@Autowired
	private ${className}Service ${classNameLower}Service;

<#list table.columns as column>
<#assign columnNameLower = column.columnName?uncap_first>
<#if column.pk>

	@RequestMapping(value = "/{${columnNameLower}}",method = RequestMethod.GET)
	public ${className} findBy${column.columnName}(@PathVariable ${column.javaType} ${columnNameLower}) {
			return ${classNameLower}Service.findBy${column.columnName}(${columnNameLower});
	}

<#elseif column.unique>

	@RequestMapping(value ="/findby${columnNameLower}/{${columnNameLower}}",method = RequestMethod.GET)
	public ${className} findBy${column.columnName}(@PathVariable ${column.javaType} ${columnNameLower}) {
		return ${classNameLower}Service.findBy${column.columnName}(${columnNameLower});
	}
<#else>

	@RequestMapping(value ="/findby${columnNameLower}/{${columnNameLower}}",method = RequestMethod.GET)
	public List<${className}> findBy${column.columnName}(@PathVariable ${column.javaType} ${columnNameLower}){
		return ${classNameLower}Service.findBy${column.columnName}(${columnNameLower});
	}

</#if>

</#list>
	@RequestMapping(value ="/add",method = RequestMethod.POST)
	public ${className} add(@RequestBody ${className} ${classNameLower}){
		return ${classNameLower}Service.save(${classNameLower});
	}

	@RequestMapping(value ="/remove/{id}",method = RequestMethod.GET)
	public ${className} remove(@PathVariable ${pkJavaType} id){
		return ${classNameLower}Service.delete(id);
	}
	@RequestMapping(value ="/remove",method = RequestMethod.POST)
	public ${className} remove${className}(@RequestBody ${className} ${classNameLower}){
		return ${classNameLower}Service.delete(${classNameLower});
	}
}
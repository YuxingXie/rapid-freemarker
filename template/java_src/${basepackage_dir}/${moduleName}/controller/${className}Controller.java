package ${basepackage}.${moduleName}.domain.controller;
import com.gzzn.base.view.annotation.SearchType;

<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 




import ${basepackage}.${moduleName}.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

@Controller
public class ${className}Controller{

}